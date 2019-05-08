package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.*;
import com.jk.util.HttpClient;
import com.jk.service.ApartmentService;
import com.jk.util.MenuTree;
import com.jk.util.TreeNoteUtil;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("apartment")
public class ApartmentController {
    @Resource
    private ApartmentService apartmentService;

    /**
     * 去登陆页面
     */
    @RequestMapping("toLogin")
    private String toLogin(){
            return "UserLogin";
    }

    /**
     * 邮箱验证码
     */
    @RequestMapping("getemailCode")
    @ResponseBody
    public String emailCode(String emailName){
        Jedis jedis = new Jedis();
        String flg="1";
        HtmlEmail email=new HtmlEmail();
        int newcode = (int)(Math.random()*899999)+100000;
        Long llen = jedis.llen(emailName);
        if(llen>=3){
            flg="2";
        }else{
        email.setHostName("smtp.163.com");
        try {
            email.setCharset("UTF-8");
            email.addTo(emailName);
            email.setFrom("15942087701@163.com","登录验证码");
            email.setAuthentication("15942087701@163.com","han7758521");
            email.setSubject("验证码");
            email.setMsg(newcode+"");
            email.send();
        }catch (EmailException e) {
            e.printStackTrace();
        }
        jedis.set(emailName+"1",newcode+"");
        jedis.expire(emailName+"1",60*2);
        jedis.lpush(emailName,newcode+"");
        jedis.expire(emailName,60*60*24);

        flg="1";
        }


        return flg;
    }

    /**
     *手机验证码
     */
    @RequestMapping("getphoneCode")
    @ResponseBody
    public String getphoneCode(String phoneName){
         String flg="1";
        Jedis jedis = new Jedis();
        Long llen = jedis.llen(phoneName);
        int newcode = (int)(Math.random()*899999)+100000;
        if(llen>=3){
            flg="2";
        }else{
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("mobile",phoneName);
        hashMap.put("tpl_id","156275");
        hashMap.put("tpl_value","%23code%23%3d"+newcode);
        hashMap.put("key","a70999110fa25d1a7be51036d57272ff");
        String s = HttpClient.sendGet("http://v.juhe.cn/sms/send", hashMap);
       jedis.set(phoneName+"1",newcode+"");
       jedis.expire(phoneName+"1",60*2);
       jedis.lpush(phoneName,newcode+"");
       jedis.expire(phoneName,60*60*24);
        flg="1";
        }
        return flg;
    }

    /**
     *登录
     */
    @RequestMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(LoginUser loginUser){
       //1:登录成功 2:验证码错误 3:账号或密码错误
        Jedis jedis = new Jedis();
        String code=null;
        HashMap<String, Object> hashMap = new HashMap<>();
        if(loginUser!=null){
        if(loginUser.getEmailName()!=null&&loginUser.getEmailName().length()>0){
            code= jedis.get(loginUser.getEmailName() + "1");
        }else{
            code= jedis.get(loginUser.getPhoneName() + "1");
        }
        if(loginUser.getCode()!=null&&code.equals(loginUser.getCode())){
            hashMap=apartmentService.findUserByNamePwd(loginUser);
        }else{
            hashMap.put("flg","2");
        }
        }
        return hashMap;
    }

    /**
     *普通树
     */
    @RequestMapping("getTree")
    @ResponseBody
    private List<MenuTree> getTree(String jobId){
        List<MenuTree> list=apartmentService.getTree(jobId);
        return TreeNoteUtil.getFatherNode(list);
    }

    /**
     *去树页面
     */
    @RequestMapping("toTreePage")
    public String toTreePage(String accounts,String userPassWord,String jobId,String userName,Model model){
        model.addAttribute("accounts",accounts);
        model.addAttribute("userPassWord",userPassWord);
        model.addAttribute("jobId",jobId);
        model.addAttribute("userName",userName);
        return "treePage";
    }
    /**
     * 用户退出
     */
    @RequestMapping("dropout")
    @ResponseBody
    public String dropout(String accounts){
        apartmentService.dropout(accounts);
        return null;
    }
    /**
     * 忘记密码页面
     */
    @RequestMapping("toforgetPasswordPage")
    public String toforgetPasswordPage(){
        return "forgetPasswordPage";
    }
    @RequestMapping("toShow")
    public String toShow(){
        return "shouye";
    }
    //张引胜
//账号信息页
    @RequestMapping("referuser")
    public String  referuser(UserModel user, Model model){
        UserModel userModel=apartmentService.referuser(user);
        model.addAttribute("user",userModel);
        return "Count";
    }
    //跳转增加子账户页面
    @RequestMapping("tosaveandupdate")
    public String tosaveandupdate(){
        return "saveandupdate";
    }
    //跳转查询页面
    @RequestMapping("toshow")
    public String toshow(){
        return "show";
    }
    //人员配置页面
    @RequestMapping("refer")
    @ResponseBody
    public HashMap<String,Object> refer(Integer start,Integer pageSize){

        return apartmentService.refer(start,pageSize);
    }

    //删除
    @RequestMapping("deleteuser")
    @ResponseBody
    public void deleteuser(Integer sid){
        apartmentService.deleteuser(sid);
    }

    //添加子账户
    @RequestMapping("saveuser")
    @ResponseBody
    public void saveuser(UserModel usermodel){
        if (usermodel.getUserId()==null) {
            apartmentService.saveuser(usermodel);
        }else{
            apartmentService.updateuser(usermodel);
        }
    }

    //跳转修改回显页面
    @RequestMapping("toupdate")
    public String toupdate(Integer xid,Model model){
        UserModel user=apartmentService.toupdate(xid);
        return "saveandupdate";
    }
    @RequestMapping("toposition")
    public String toposition(){
        return "position";
    }
    @RequestMapping("referposition")
    @ResponseBody
    public HashMap<String,Object> referposition(Integer start,Integer pageSize){

        return apartmentService.referposition(start,pageSize);
    }
    @RequestMapping("deletejob")
    @ResponseBody
    public void deletejob(Integer sid){
        apartmentService.deletejob(sid);
    }
    @RequestMapping("tosaveposition")
    public String tosaveposition(){
        return "saveandupdateposition";
    }

    //findMenu ztree显示
    @RequestMapping("findMenu")
    @ResponseBody
    public  List<LinkedHashMap<String, Object>> findMenu(){
        return  apartmentService.findMenu();
    }
    @RequestMapping("referpositiontwo")
    @ResponseBody
    public List<JobModel> referpositiontwo(){
        return apartmentService.referpositiontwo();
    }
    //赵苑辰
    //显示页面
    @RequestMapping("toindex")
    public String index(){
        return "landlord";
    }
    //清退页面
    @RequestMapping("toqingtui")
    public String qingtui(){
        return "qingtui";
    }
    //选项配置页面 Configuration options
    @RequestMapping("tooptions")
    public String options(){
        return "options";
    }

    //房东合同查询方法
    @RequestMapping("findLandlord")
    @ResponseBody
    public HashMap<String,Object> findLandlord(LandlordBean landlord, Integer start , Integer pageSize){

        return apartmentService.findLandlord(landlord,start,pageSize);
    }

    //查看详情 dialog  findPage
    @RequestMapping("findPage")
    public String findPage(Integer id,Model model){
        model.addAttribute("id",id);
        return "findPage";
    }
    //查询房东信息  findLandlordInformation
    @RequestMapping("findLandlordInformation")
    @ResponseBody
    public HashMap<String,Object> findLandlordInformation(Integer start , Integer pageSize,Integer id){
        System.out.print(id);
        return apartmentService.findLandlordInformation(start,pageSize,id);
    }
    //查询房源信息 findHousingInformation
    @RequestMapping("findHousingInformation")
    @ResponseBody
    public HashMap<String,Object> findHousingInformation(Integer start , Integer pageSize,Integer id){

        return apartmentService.findHousingInformation(start,pageSize,id);
    }
    //查询合同信息 findContractInformation
    @RequestMapping("findContractInformation")
    @ResponseBody
    public HashMap<String,Object> findContractInformation(Integer start , Integer pageSize,Integer id){

        return apartmentService.findContractInformation(start,pageSize,id);
    }
    //费用结算 findCostSettlement
    @RequestMapping("findCostSettlement")
    @ResponseBody
    public HashMap<String,Object> findCostSettlement(Integer start , Integer pageSize,Integer id){

        return apartmentService.findCostSettlement(start,pageSize,id);
    }
    //清退查询页面 findqingtui
    @RequestMapping("findqingtui")
    @ResponseBody
    public HashMap<String,Object> findqingtui(Integer start , Integer pageSize,Integer id){

        return apartmentService.findqingtui(start,pageSize,id);
    }

    //清退 clearRefund    string address
    @RequestMapping("clearRefund")
    @ResponseBody
    public List<Contractzuke> clearRefund(String address){
        List<Contractzuke> list = apartmentService.clearRefund(address);
        String jsonString = JSON.toJSONString(list);
        System.out.print(jsonString);
        return list;
    }

    //业务区域查询 findyewu
    @RequestMapping("findyewu")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findyewu(){
        return apartmentService.findyewu();
    }
    //租金支付方式 findzujin
    @RequestMapping("findzujin")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findzujin(){
        return apartmentService.findzujin();
    }
    //第三方金融 finddisanfang
    @RequestMapping("finddisanfang")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> finddisanfang(){
        return apartmentService.finddisanfang();
    }
    //付款方式 findfukuan
    @RequestMapping("findfukuan")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findfukuan(){
        return apartmentService.findfukuan();
    }
    //账单类型 findtype
    @RequestMapping("findtype")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findtype(){
        return apartmentService.findtype();
    }
    //租住方式 findzuzhu
    @RequestMapping("findzuzhu")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findzuzhu(){
        return apartmentService.findzuzhu();
    }
    //房源户型 findhuxing
    @RequestMapping("findhuxing")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findhuxing(){
        return apartmentService.findhuxing();
    }
    //房源配置 findpeizhi
    @RequestMapping("findpeizhi")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> findpeizhi(){
        return apartmentService.findpeizhi();
    }
    //刘瑞广
    /**
     * 查询
     */
    @RequestMapping("toContract")
    public String tocontract(){

        return "contract";
    }

    @RequestMapping("findcontract")
    @ResponseBody
    public HashMap<String, Object> findcontract(Contractzuke contract,Integer start,Integer pageSize) {

        return apartmentService.findcontract(contract,start,pageSize);
    }


    /**
     * 查看详情
     */
    @RequestMapping("findAll")
    public String findAll(Integer id,Model model){
        model.addAttribute("id",id);
        return "findAll";
    }

    /**
     * 查询联系人
     */
    @RequestMapping("findContact")
    @ResponseBody
    public HashMap<String, Object> findContact(Integer start,Integer pageSize,Integer id){

        return apartmentService.findContact(start,pageSize,id);
    }

    /**
     * 查询合同信息
     */
    @RequestMapping("findContractinfo")
    @ResponseBody
    public HashMap<String, Object> findContractinfo(Integer start,Integer pageSize,Integer id){

        return apartmentService.findContractinfo(start,pageSize,id);
    }

    /**
     * 查询费用
     */
    @RequestMapping("findCost")
    @ResponseBody
    public HashMap<String, Object> findCost(Integer start,Integer pageSize,Integer id){

        return apartmentService.findCost(start,pageSize,id);
    }

    /**
     * 收支流水
     */
    @RequestMapping("findIncome")
    @ResponseBody
    public HashMap<String, Object> findIncome(Income income,Integer start, Integer pageSize){

        return apartmentService.findIncome(income,start,pageSize);
    }

    @RequestMapping("tofindIncome")
    public String findIncome(){

        return "Income";
    }

    /**
     * 更多
     */
    @RequestMapping("findincoinfo")
    public ModelAndView findincoinfo(Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("id",id);
        mv.setViewName("findincoinfo");
        return mv;
    }

    /**
     * 查询账单信息
     */
    @RequestMapping("findbill")
    @ResponseBody
    public HashMap<String, Object> findbill (Integer start,Integer pageSize,Integer id){

        return apartmentService.findbill(start,pageSize,id);
    }

    /**
     *查询支付方式
     */
    @RequestMapping("findpay")
    @ResponseBody
    public HashMap<String, Object> findpay(Integer start,Integer pageSize,Integer id){

        return apartmentService.findpay(start,pageSize,id);
    }

//刘军宜
    /**
     * 跳转代收账单页面
     */
    @RequestMapping("toCharge")
    public String toCharge(){
        return "findCharge";
    }

    /**
     * 跳转代支付账单页面
     */
    @RequestMapping("toWait")
    public String toWait(){
        return "findWait";
    }


    /**
     * 页面顶部代收总额查询
     */
    @RequestMapping("findPriceCount")
    @ResponseBody
    public Integer findPriceCount(){
        Integer count=apartmentService.findPriceCount();
        return count;
    }

    /**
     * 代收账单查询
     * @return
     */
    @RequestMapping("findCharge")
    @ResponseBody
    public HashMap<String ,Object> findCharge(Integer page,Integer rows,Charge charge){
        HashMap<String ,Object> hashMap=apartmentService.findCharge(page,rows,charge);
        return hashMap;
    }


    /**
     * 确认收款 updateStatus
     */
    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus(Integer room_id){
        apartmentService.updateStatus(room_id);
        return null;
    }


    /**
     * 确认收款打开弹框  toPage
     */
    @RequestMapping("toPage")
    public String toPage(Integer id,Model model){
        Charge charge=apartmentService.findChargeById(id);
        model.addAttribute("charge",charge);
        return "updatePage";
    }


    /**
     * 查看更多信息   toFindPage
     */
    @RequestMapping("toFindPage")
    public String toFindPage(Integer id,Model model){
        Charge charge=apartmentService.toFindPage(id);
        model.addAttribute("one",charge);
        return "updatePageAll";
    }


    /**
     * 点击确认收款弹框的提交 addAlready
     */
    @RequestMapping("addAlready")
    @ResponseBody
    public String addAlready(Already already){
        Integer roomId = already.getRoomId();
        apartmentService.addAlready(roomId,already);
        return null;
    }


    /**
     * 待支付页面顶部代支总额  findWaitPriceCount
     */
    @RequestMapping("findWaitPriceCount")
    @ResponseBody
    public Integer findWaitPriceCount(){
        Integer count=apartmentService.findWaitPriceCount();
        return count;
    }


    /**
     * 待支付页面查询  findWait
     */
    @RequestMapping("findWait")
    @ResponseBody
    public HashMap<String ,Object> findWait(Integer page, Integer rows, Wait wait){
        HashMap<String ,Object> hashMap=apartmentService.findWait(page,rows,wait);
        return hashMap;
    }


}
