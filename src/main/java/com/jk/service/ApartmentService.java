package com.jk.service;

import com.jk.model.*;
import com.jk.util.MenuTree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface ApartmentService {

    HashMap<String, Object> findUserByNamePwd(LoginUser loginUser);


    List<MenuTree> getTree(String jobId);

    void dropout(String accounts);
    //张引胜
    UserModel referuser(UserModel user);

    HashMap<String,Object> refer(Integer start, Integer pageSize);

    void deleteuser(Integer sid);

    void saveuser(UserModel usermodel);

    UserModel toupdate(Integer xid);

    void updateuser(UserModel usermodel);

    HashMap<String,Object> referposition(Integer start, Integer pageSize);

    void deletejob(Integer sid);

    List<LinkedHashMap<String,Object>> findMenu();

    List<JobModel> referpositiontwo();
    //赵苑辰
    HashMap<String,Object> findLandlord(LandlordBean landlord, Integer start , Integer pageSize);

    HashMap<String,Object> findLandlordInformation(Integer start , Integer pageSize,Integer id);

    HashMap<String,Object> findHousingInformation(Integer start , Integer pageSize,Integer id);

    HashMap<String,Object> findContractInformation(Integer start , Integer pageSize,Integer id);

    HashMap<String,Object> findCostSettlement(Integer start , Integer pageSize,Integer id);

    HashMap<String,Object> findqingtui(Integer start , Integer pageSize,Integer id);

    List<Contractzuke> clearRefund(String address);

    List<LinkedHashMap<String,Object>> findyewu();

    List<LinkedHashMap<String,Object>> findzujin();

    List<LinkedHashMap<String,Object>> finddisanfang();

    List<LinkedHashMap<String,Object>> findfukuan();

    List<LinkedHashMap<String,Object>> findtype();

    List<LinkedHashMap<String,Object>> findzuzhu();

    List<LinkedHashMap<String,Object>> findhuxing();

    List<LinkedHashMap<String,Object>> findpeizhi();
    //刘瑞广
    HashMap<String,Object> findcontract(Contractzuke contract, Integer start, Integer pageSize);

    HashMap<String,Object> findContact(Integer start,Integer pageSize,Integer id);

    HashMap<String,Object> findContractinfo(Integer start, Integer pageSize,Integer id);

    HashMap<String,Object> findCost(Integer start, Integer pageSize, Integer id);

    HashMap<String,Object> findIncome(Income income, Integer start, Integer pageSize);

    HashMap<String,Object> findbill(Integer start, Integer pageSize, Integer id);

    HashMap<String,Object> findpay(Integer start, Integer pageSize, Integer id);

    //刘军宜
    HashMap<String,Object> findCharge(Integer page, Integer rows, Charge charge);

    Integer findPriceCount();

    void updateStatus(Integer room_id);

    Charge findChargeById(Integer id);

    Charge toFindPage(Integer id);

    void addAlready(Integer roomId, Already already);

    Integer findWaitPriceCount();

    HashMap<String,Object> findWait(Integer page, Integer rows, Wait wait);
}
