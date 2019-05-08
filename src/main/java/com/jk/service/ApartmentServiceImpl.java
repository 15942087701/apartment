package com.jk.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.jk.mapper.ApartmentMapper;
import com.jk.model.*;
import com.jk.util.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApartmentServiceImpl implements ApartmentService{

    @Reference(timeout = 3000)
     DubboService dubboService;
    @Autowired
    private ApartmentMapper apartmentMapper;

    @Override
    /**
     * 验证账号密码是否正确
     */
    public HashMap<String, Object> findUserByNamePwd(LoginUser loginUser) {
        return dubboService.findUserByNamePwd(loginUser);
    }

    @Override
    public List<MenuTree> getTree(String jobId) {
        return dubboService.getTree(jobId);
    }

    @Override
    public void dropout(String accounts) {
        apartmentMapper.dropout(accounts);
    }
    //张引胜
    @Override
    public UserModel referuser(UserModel user) {

        return apartmentMapper.referuser(user);
    }

    @Override
    public HashMap<String, Object> refer(Integer start, Integer pageSize) {
        List<UserModel> list=apartmentMapper.refer(start,pageSize);
        Long count=apartmentMapper.count();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",count);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void deleteuser(Integer sid) {
        apartmentMapper.deleteuser(sid);
    }

    @Override
    public void saveuser(UserModel usermodel) {
        usermodel.setAccounts(UUID.randomUUID().toString().replace("-",""));
        Long i=apartmentMapper.saveuser(usermodel);
        if (i!=0){
            UserModel user=apartmentMapper.saverefer(usermodel.getUserName());
            apartmentMapper.savejob(user.getUserId(),usermodel.getUserIdentity());
        }

    }

    @Override
    public UserModel toupdate(Integer xid) {
        return apartmentMapper.toupdate(xid);
    }

    @Override
    public void updateuser(UserModel usermodel) {
        apartmentMapper.updateuser(usermodel);
    }

    @Override
    public HashMap<String, Object> referposition(Integer start, Integer pageSize) {
        List<JobModel> list=apartmentMapper.referposition(start,pageSize);
        Long count=apartmentMapper.positioncount();
        HashMap<String , Object> hashMap = new HashMap<>();
        hashMap.put("total",count);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void deletejob(Integer sid) {
        apartmentMapper.deletejob(sid);
    }

    @Override
    public List<LinkedHashMap<String, Object>> findMenu() {
        return apartmentMapper.findMenu();
    }

    @Override
    public List<JobModel> referpositiontwo() {
        return apartmentMapper.referpositiontwo();
    }
//赵苑辰
@Override
public HashMap<String, Object> findLandlord(LandlordBean landlord, Integer start, Integer pageSize) {
    Long sumSize = apartmentMapper.getSumSize();
    List<LandlordBean> list = apartmentMapper.findLandlord(landlord,start,pageSize);
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("total",sumSize);
    hashMap.put("rows",list);
    return hashMap;
}

    @Override
    public HashMap<String, Object> findLandlordInformation(Integer start, Integer pageSize,Integer id) {
        Long sumSize = apartmentMapper.getSumSizeLandlordInformation();
        List<LandlordInformationBean> list = apartmentMapper.findLandlordInformation(start,pageSize,id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findHousingInformation(Integer start, Integer pageSize, Integer id) {
        Long sumSize = apartmentMapper.getSumSizeHousingInformation();
        List<HousingInformationBean> list = apartmentMapper.findHousingInformation(start,pageSize,id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findContractInformation(Integer start, Integer pageSize, Integer id) {
        Long sumSize = apartmentMapper.getSumSizeContractInformation();
        List<ContractInformationBean> list = apartmentMapper.findContractInformation(start,pageSize,id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findCostSettlement(Integer start, Integer pageSize, Integer id) {
        Long sumSize = apartmentMapper.getSumSizeCostSettlement();
        List<CostSettlemenBean> list = apartmentMapper.findCostSettlement(start,pageSize,id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }
    @Override
    public HashMap<String, Object> findqingtui(Integer start, Integer pageSize, Integer id) {
        Long sumSize = apartmentMapper.getSumSizeqingtui();
        List<LandlordBean> list = apartmentMapper.findqingtui(start,pageSize,id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public List<Contractzuke> clearRefund(String address) {
        List<Contractzuke> list = apartmentMapper.clearRefund(address);
        String jsonString = JSON.toJSONString(list);
        System.out.print("list数据"+jsonString);
        return list;
    }

    @Override
    public List<LinkedHashMap<String, Object>> findyewu() {
        return apartmentMapper.findyewu();
    }
    @Override
    public List<LinkedHashMap<String, Object>> findzujin() {
        return apartmentMapper.findzujin();
    }
    @Override
    public List<LinkedHashMap<String, Object>> finddisanfang() {
        return apartmentMapper.finddisanfang();
    }
    @Override
    public List<LinkedHashMap<String, Object>> findfukuan() {
        return apartmentMapper.findfukuan();
    }
    @Override
    public List<LinkedHashMap<String, Object>> findtype() {
        return apartmentMapper.findtype();
    }
    @Override
    public List<LinkedHashMap<String, Object>> findzuzhu() {
        return apartmentMapper.findzuzhu();
    }
    @Override
    public List<LinkedHashMap<String, Object>> findhuxing() {
        return apartmentMapper.findhuxing();
    }
    @Override
    public List<LinkedHashMap<String, Object>> findpeizhi() {
        return apartmentMapper.findpeizhi();
    }
//刘瑞广
@Override
public HashMap<String, Object> findcontract(Contractzuke contract, Integer start, Integer pageSize) {
    Long sumSize=apartmentMapper.getSumSize2();
    List<Contractzuke> list=apartmentMapper.findcontract(contract,start,pageSize);
    HashMap<String,Object> hashMap=new HashMap<>();
    hashMap.put("total",sumSize);
    hashMap.put("rows",list);
    return hashMap;
}

    @Override
    public HashMap<String, Object> findContact(Integer start,Integer pageSize,Integer id) {
        Long sumSize=apartmentMapper.getSumSizetwo();
        List<Contact> list=apartmentMapper.findContact(start,pageSize,id);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findContractinfo(Integer start, Integer pageSize,Integer id) {
        Long sumSize=apartmentMapper.getSumSizethree();
        List<Contract> list=apartmentMapper.findContractinfo(start,pageSize,id);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findCost(Integer start, Integer pageSize, Integer id) {
        Long sumSize=apartmentMapper.getSumSizefour();
        List<Cost> list=apartmentMapper.findCost(start,pageSize,id);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findIncome(Income income, Integer start, Integer pageSize) {
        Long sumSize=apartmentMapper.findSumSize();
        List<Income> list=apartmentMapper.findIncome(income,start,pageSize);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("total",sumSize);
        hashMap.put("rows",list);
        return hashMap;
    }
    //刘军宜
    /**
     * 代收账单查询
     * @param page
     * @param rows
     * @param charge
     * @return
     */
    @Override
    public HashMap<String, Object> findCharge(Integer page, Integer rows, Charge charge) {
        Integer count=apartmentMapper.findChargeCount();

        if(charge.getMiddleOne()!=null && charge.getMiddleOne()!=0 && charge.getMiddleOne()==1){  //账单房号查询
            List<Charge> list=apartmentMapper.findChargeDataOne(page,rows,charge.getMiddleTwo());
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("total",count);
            hashMap.put("rows",list);
            return hashMap;
        }
        else if(charge.getMiddleOne()!=null && charge.getMiddleOne()!=0 && charge.getMiddleOne()==2){  //付款方查询
            List<Charge> list=apartmentMapper.findChargeDataTwo(page,rows,charge.getMiddleTwo());
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("total",count);
            hashMap.put("rows",list);
            return hashMap;
        }
        else{
            List<Charge> list=apartmentMapper.findChargeDataThree(page,rows,charge);
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("total",count);
            hashMap.put("rows",list);
            return hashMap;
        }


    }


    /**
     * 页面顶部代收总额查询
     * @return
     */
    @Override
    public Integer findPriceCount() {
        Integer count=apartmentMapper.findPriceCount();
        return count;
    }


    /**
     * 确认收款 更改状态
     * @param room_id
     */
    @Override
    public void updateStatus(Integer room_id) {
        apartmentMapper.updateStatus(room_id);
    }


    /**
     * 确认收款打开弹框
     * @param id
     * @return
     */
    @Override
    public Charge findChargeById(Integer id) {
        Charge charge=apartmentMapper.findChargeById(id);
        return charge;
    }

    /**
     * 查看更多信息
     * @param id
     * @return
     */
    @Override
    public Charge toFindPage(Integer id) {
        Charge charge=apartmentMapper.findChargeById(id);
        return charge;
    }


    /**
     * 点击确认收款时提交
     * @param roomId
     * @param already
     */
    @Override
    public void addAlready(Integer roomId, Already already) {
        apartmentMapper.updateStatus(roomId);
        apartmentMapper.updateWaitStatus(already.getWaitId());
        apartmentMapper.deleteWait(already.getWaitId());
        Date date=new Date();
        apartmentMapper.addAlready(date,already);


    }

    /**
     * 待支付页面待支付总额查询
     * @return
     */
    @Override
    public Integer findWaitPriceCount() {
        Integer count=apartmentMapper.findWaitPriceCount();
        return count;
    }


    /**
     * 待支付页面查询
     * @param page
     * @param rows
     * @param wait
     * @return
     */
    @Override
    public HashMap<String, Object> findWait(Integer page, Integer rows, Wait wait) {
        Integer count=apartmentMapper.findWaitCount();

        if(wait.getMiddleOne()!=null && wait.getMiddleOne()!=0 && wait.getMiddleOne()==1){  //账单房号查询
            List<Charge> list=apartmentMapper.findWaitOne(page,rows,wait.getMiddleTwo());
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("total",count);
            hashMap.put("rows",list);
            return hashMap;
        }
        else if(wait.getMiddleOne()!=null && wait.getMiddleOne()!=0 && wait.getMiddleOne()==2){  //付款方查询
            List<Charge> list=apartmentMapper.findWaitTwo(page,rows,wait.getMiddleTwo());
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("total",count);
            hashMap.put("rows",list);
            return hashMap;
        }
        else{
            List<Charge> list=apartmentMapper.findWaitThree(page,rows,wait);
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("total",count);
            hashMap.put("rows",list);
            return hashMap;
        }

    }

}
