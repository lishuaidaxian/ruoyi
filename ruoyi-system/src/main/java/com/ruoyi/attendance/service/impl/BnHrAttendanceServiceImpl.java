package com.ruoyi.attendance.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ruoyi.attendance.domain.BnHrAttendance;
import com.ruoyi.attendance.mapper.BnHrAttendanceMapper;
import com.ruoyi.attendance.service.IBnHrAttendanceService;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.salary.domain.BnHrSalary;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 考勤Service业务层处理
 * 
 * @author ls
 * @date 2022-02-21
 */
@Service
public class BnHrAttendanceServiceImpl implements IBnHrAttendanceService
{
    @Autowired
    private BnHrAttendanceMapper bnHrAttendanceMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询考勤
     * 
     * @param id 考勤主键
     * @return 考勤
     */
    @Override
    public BnHrAttendance selectBnHrAttendanceById(Long id)
    {
        return bnHrAttendanceMapper.selectBnHrAttendanceById(id);
    }

    /**
     * 查询考勤列表
     * 
     * @param bnHrAttendance 考勤
     * @return 考勤
     */
    @Override
    public List<BnHrAttendance> selectBnHrAttendanceList(BnHrAttendance bnHrAttendance)
    {
        return bnHrAttendanceMapper.selectBnHrAttendanceList(bnHrAttendance);
    }

    /**
     * 查询考勤列表
     *
     * @param bnHrAttendance 考勤
     * @return 考勤
     */
    @Override
    public BnHrAttendance selectDeptName2(BnHrAttendance bnHrAttendance)
    {
        //根据登陆人权限查询部门相关数据
        SysUser sysUser = ShiroUtils.getSysUser();
        //判断是否为普通用户
        List<SysRole> roles = sysUser.getRoles();
        for(SysRole role :roles){
            if(role.getRoleId()==1l||role.getRoleId()==3l){
                return bnHrAttendance;
            }
        }
        Long deptId = sysUser.getDeptId();
        if(deptId!=null){
            SysDept sysDept = new SysDept();
            sysDept.setAncestors(deptId.toString());
            List<SysDept> sysDepts = sysDeptMapper.selectDeptList(sysDept);
//            List<String> nameList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(SysDept dept: sysDepts){
                sb.append(dept.getDeptName());
            }
            bnHrAttendance.setDeptName2(sb.toString());
        }
        return bnHrAttendance;
    }

    /**
     * 新增考勤
     * 
     * @param bnHrAttendance 考勤
     * @return 结果
     */
    @Override
    public int insertBnHrAttendance(BnHrAttendance bnHrAttendance)
    {
        bnHrAttendance.setName(null);
        return bnHrAttendanceMapper.insertBnHrAttendance(bnHrAttendance);
    }

    /**
     * 修改考勤
     * 
     * @param bnHrAttendance 考勤
     * @return 结果
     */
    @Override
    public int updateBnHrAttendance(BnHrAttendance bnHrAttendance)
    {
        int i = bnHrAttendanceMapper.updateBnHrAttendance(bnHrAttendance);
        if(StringUtils.isEmpty(bnHrAttendance.getRemark())){
            //计算总小时与总天数
            BnHrAttendance attendance = bnHrAttendanceMapper.selectBnHrAttendanceById(bnHrAttendance.getId());
            BnHrAttendance result = sumHoursAndDays(attendance);
            i = bnHrAttendanceMapper.updateBnHrAttendance(result);
        }
        return i;
    }

    //计算当月总小时与总天数
    private BnHrAttendance sumHoursAndDays(BnHrAttendance bnHrAttendance){
        String day1 = bnHrAttendance.getDay1();
        String day2 = bnHrAttendance.getDay2();
        String day3 = bnHrAttendance.getDay3();
        String day4 = bnHrAttendance.getDay4();
        String day5 = bnHrAttendance.getDay5();
        String day6 = bnHrAttendance.getDay6();
        String day7 = bnHrAttendance.getDay7();
        String day8 = bnHrAttendance.getDay8();
        String day9 = bnHrAttendance.getDay9();
        String day10 = bnHrAttendance.getDay10();
        String day11 = bnHrAttendance.getDay11();
        String day12 = bnHrAttendance.getDay12();
        String day13 = bnHrAttendance.getDay13();
        String day14 = bnHrAttendance.getDay14();
        String day15 = bnHrAttendance.getDay15();
        String day16 = bnHrAttendance.getDay16();
        String day17 = bnHrAttendance.getDay17();
        String day18 = bnHrAttendance.getDay18();
        String day19 = bnHrAttendance.getDay19();
        String day20 = bnHrAttendance.getDay20();
        String day21 = bnHrAttendance.getDay21();
        String day22 = bnHrAttendance.getDay22();
        String day23 = bnHrAttendance.getDay23();
        String day24 = bnHrAttendance.getDay24();
        String day25 = bnHrAttendance.getDay25();
        String day26 = bnHrAttendance.getDay26();
        String day27 = bnHrAttendance.getDay27();
        String day28 = bnHrAttendance.getDay28();
        String day29 = bnHrAttendance.getDay29();
        String day30 = bnHrAttendance.getDay30();
        String day31 = bnHrAttendance.getDay31();
        BigDecimal hours = getBigDecimalSum(new BigDecimal(0), new BigDecimal(nullToZero(day1)), new BigDecimal(nullToZero(day2)), new BigDecimal(nullToZero(day3)), new BigDecimal(nullToZero(day4)),
                new BigDecimal(nullToZero(day5)), new BigDecimal(nullToZero(day6)), new BigDecimal(nullToZero(day7)), new BigDecimal(nullToZero(day8)), new BigDecimal(nullToZero(day9)),
                new BigDecimal(nullToZero(day10)), new BigDecimal(nullToZero(day11)), new BigDecimal(nullToZero(day12)), new BigDecimal(nullToZero(day13)), new BigDecimal(nullToZero(day14)),
                new BigDecimal(nullToZero(day15)), new BigDecimal(nullToZero(day16)), new BigDecimal(nullToZero(day17)), new BigDecimal(nullToZero(day18)), new BigDecimal(nullToZero(day19)),
                new BigDecimal(nullToZero(day20)), new BigDecimal(nullToZero(day21)), new BigDecimal(nullToZero(day22)), new BigDecimal(nullToZero(day23)), new BigDecimal(nullToZero(day24)),
                new BigDecimal(nullToZero(day25)), new BigDecimal(nullToZero(day26)), new BigDecimal(nullToZero(day27)), new BigDecimal(nullToZero(day28)), new BigDecimal(nullToZero(day29)),
                new BigDecimal(nullToZero(day30)), new BigDecimal(nullToZero(day31)));
        BigDecimal days = hours.divide(new BigDecimal("8"), 1, RoundingMode.DOWN);
        BnHrAttendance result = new BnHrAttendance();
        result.setId(bnHrAttendance.getId());
        result.setHours(hours.toString());
        result.setDays(days.toString());
        return result;
    }

    private String nullToZero(String day){
        if(StringUtils.isEmpty(day)){
            day = "0";
        }
        return day;
    }

//    public static void main(String[] args) {
//        BigDecimal add = new BigDecimal("4").add(new BigDecimal("8"));
//        BigDecimal divide = add.divide(new BigDecimal("8"), 1, RoundingMode.DOWN);
//        System.out.println(add);
//        System.out.println(divide);
//    }

    //多个Decimal相加
    private BigDecimal getBigDecimalSum(BigDecimal i, BigDecimal... arg) {
        BigDecimal sum = i;
        for (BigDecimal b : arg) {
            if(b!=null){
                sum = sum.add(b);
            }
        }
        return sum;
    }

    /**
     * 批量删除考勤
     * 
     * @param ids 需要删除的考勤主键
     * @return 结果
     */
    @Override
    public int deleteBnHrAttendanceByIds(String ids)
    {
        return bnHrAttendanceMapper.deleteBnHrAttendanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤信息
     * 
     * @param id 考勤主键
     * @return 结果
     */
    @Override
    public int deleteBnHrAttendanceById(Long id)
    {
        return bnHrAttendanceMapper.deleteBnHrAttendanceById(id);
    }

    @Override
    public String importBnHrAttendance(List<BnHrAttendance> bnHrAttendances, BnHrAttendance searchModel) {
        if (StringUtils.isNull(bnHrAttendances) || bnHrAttendances.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        Date date = new Date();
        //获取当前登录用户
        SysUser sysUser = ShiroUtils.getSysUser();
        String userName = sysUser.getUserName();
        //获取录入日期
//        String toDate = searchModel.getToDate();
        String toDate = DateUtils.parseDateToStr("yyyyMM", date);
        for (BnHrAttendance bnHrAttendance : bnHrAttendances)
        {
            try{
                BnHrAttendance search = new BnHrAttendance();
                search.setName(bnHrAttendance.getName());
                search.setDeptName(bnHrAttendance.getDeptName());
                search.setCreateDate(bnHrAttendance.getCreateDate());
                List<BnHrAttendance> bnHrAttendanceList = bnHrAttendanceMapper.selectBnHrAttendanceList(search);
                if(bnHrAttendanceList.size()>0){
//                    throw new Exception("部门:"+bnHrAttendance.getDeptName()+",姓名:"+bnHrAttendance.getName()+",考勤日期:"+bnHrAttendance.getCreateDate()+" 已导入！");

                    failureNum++;
                    failureMsg.append("<br/>" + "部门:"+bnHrAttendance.getDeptName()+",姓名:"+bnHrAttendance.getName()+",考勤日期:"+bnHrAttendance.getCreateDate()+" 已导入！");
                    continue;
                }
                bnHrAttendanceMapper.insertBnHrAttendance(bnHrAttendance);
                successNum++;
            }catch (Exception e){
                e.printStackTrace();
                failureNum++;
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public int deleteBnHrAttendanceByCreateDate(BnHrAttendance bnHrAttendance) {
        return bnHrAttendanceMapper.deleteBnHrAttendanceByCreateDate(bnHrAttendance);
    }
}
