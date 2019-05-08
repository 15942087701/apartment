package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public interface ApartmentMapper {
    void dropout(String accounts);

    //张引胜

    UserModel referuser(UserModel user);


    List<UserModel> refer(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    Long count();

    void deleteuser(Integer sid);

    Long saveuser(UserModel usermodel);


    UserModel saverefer(String userName);


    void savejob(@Param("userId") Integer userId, @Param("userIdentity") Integer userIdentity);

    UserModel toupdate(Integer xid);

    void updateuser(UserModel usermodel);

    List<JobModel> referposition(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    Long positioncount();

    void deletejob(Integer sid);
    @Select("select * from average_tree")
    List<LinkedHashMap<String,Object>> findMenu();

    List<JobModel> referpositiontwo();
    //赵苑辰
    //房东合同总条数
    @Select("select count(1) from t_landlord")
    Long getSumSize();

    List<LandlordBean> findLandlord(LandlordBean landlord, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    //查询房东信息总条数
    @Select("select count(1) from t_landlord_information")
    Long getSumSizeLandlordInformation();
    List<LandlordInformationBean> findLandlordInformation(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("id") Integer id);

    //查询房源信息
    @Select("select count(1) from t_housing_information")
    Long getSumSizeHousingInformation();
    List<HousingInformationBean> findHousingInformation(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("id") Integer id);

    //查询合同信息
    @Select("select count(1) from t_contract_information")
    Long getSumSizeContractInformation();
    List<ContractInformationBean> findContractInformation(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("id") Integer id);

    //查询费用
    @Select("select count(1) from t_cost_settlemen")
    Long getSumSizeCostSettlement();
    List<CostSettlemenBean> findCostSettlement(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("id") Integer id);

    //清退
    List<Contractzuke> clearRefund(@Param("address") String address);

    @Select("select count(1) from t_landlord")
    Long getSumSizeqingtui();
    List<LandlordBean> findqingtui(@Param("start") Integer start, @Param("pageSize") Integer pageSize,@Param("id") Integer id);

    //选项配置
    @Select("select * from t_yewu")
    List<LinkedHashMap<String,Object>> findyewu();

    @Select("select * from t_zujin")
    List<LinkedHashMap<String,Object>> findzujin();

    @Select("select * from t_disanfang")
    List<LinkedHashMap<String,Object>> finddisanfang();

    @Select("select * from t_fukuan")
    List<LinkedHashMap<String,Object>> findfukuan();

    @Select("select * from t_type")
    List<LinkedHashMap<String,Object>> findtype();

    @Select("select * from t_zuzhu")
    List<LinkedHashMap<String,Object>> findzuzhu();

    @Select("select * from t_huxing")
    List<LinkedHashMap<String,Object>> findhuxing();

    @Select("select * from t_peizhi")
    List<LinkedHashMap<String,Object>> findpeizhi();
    //刘瑞广
    @Select("select count(1) from zkcontract")
    Long getSumSize2();

    List<Contractzuke> findcontract(Contractzuke contract, @Param("start") Integer start,@Param("pageSize") Integer pageSize);

    //
    List<Contact> findContact(@Param("start") Integer start, @Param("pageSize") Integer pageSize,@Param("id") Integer id);

    @Select("select count(1) from contract_contact")
    Long getSumSizetwo();

    //
    @Select("select count(1) from contract_information")
    Long getSumSizethree();

    List<Contract> findContractinfo(@Param("start") Integer start,@Param("pageSize") Integer pageSize,@Param("id") Integer id);

    //
    @Select("select count(1) from contract_cost")
    Long getSumSizefour();

    List<Cost> findCost(@Param("start") Integer start,@Param("pageSize") Integer pageSize,@Param("id") Integer id);

    @Select("select count(1) from t_billinfor")
    Long findSumSize();

    List<Income> findIncome(@Param("income") Income income,@Param("start") Integer start,@Param("pageSize") Integer pageSize);
//刘俊宜

    Integer findChargeCount();

    //账单房号查询
    List<Charge> findChargeDataOne(@Param("page") Integer page, @Param("rows")Integer rows,@Param("middleTwo") String middleTwo);
    //付款方查询
    List<Charge> findChargeDataTwo(@Param("page") Integer page, @Param("rows")Integer rows,@Param("middleTwo") String middleTwo);
    //直接查询
    List<Charge> findChargeDataThree(@Param("page") Integer page, @Param("rows")Integer rows,Charge charge);

    Integer findPriceCount();

    //确认收款，改为已经收款
    void updateStatus(@Param("room_id")Integer room_id);

    Charge findChargeById(@Param("id")Integer id);

    void addAlready(@Param("date") Date date, @Param("already") Already already);

    Integer findWaitPriceCount();

    Integer findWaitCount();

    //账单房号查询
    List<Charge> findWaitOne(@Param("page") Integer page, @Param("rows")Integer rows,@Param("middleTwo") String middleTwo);
    //付款方查询
    List<Charge> findWaitTwo(@Param("page") Integer page, @Param("rows")Integer rows,@Param("middleTwo") String middleTwo);
    //直接查询
    List<Charge> findWaitThree(@Param("page") Integer page, @Param("rows")Integer rows,Wait wait);

    //房东确认收款后，将待支付表状态改为二
    void updateWaitStatus(@Param("room_id")Integer roomId);

    //房东确认收款后，将待支付表中数据删除
    void deleteWait(@Param("waitId")Integer waitId);
}
