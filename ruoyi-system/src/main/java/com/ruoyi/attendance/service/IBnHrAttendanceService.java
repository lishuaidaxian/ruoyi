package com.ruoyi.attendance.service;

import com.ruoyi.attendance.domain.BnHrAttendance;

import java.util.List;

/**
 * 考勤Service接口
 * 
 * @author ls
 * @date 2022-02-21
 */
public interface IBnHrAttendanceService 
{
    /**
     * 查询考勤
     * 
     * @param id 考勤主键
     * @return 考勤
     */
    public BnHrAttendance selectBnHrAttendanceById(Long id);

    /**
     * 查询考勤列表
     * 
     * @param bnHrAttendance 考勤
     * @return 考勤集合
     */
    public List<BnHrAttendance> selectBnHrAttendanceList(BnHrAttendance bnHrAttendance);

    public BnHrAttendance selectDeptName2(BnHrAttendance bnHrAttendance);

    /**
     * 新增考勤
     * 
     * @param bnHrAttendance 考勤
     * @return 结果
     */
    public int insertBnHrAttendance(BnHrAttendance bnHrAttendance);

    /**
     * 修改考勤
     * 
     * @param bnHrAttendance 考勤
     * @return 结果
     */
    public int updateBnHrAttendance(BnHrAttendance bnHrAttendance);

    /**
     * 批量删除考勤
     * 
     * @param ids 需要删除的考勤主键集合
     * @return 结果
     */
    public int deleteBnHrAttendanceByIds(String ids);

    /**
     * 删除考勤信息
     * 
     * @param id 考勤主键
     * @return 结果
     */
    public int deleteBnHrAttendanceById(Long id);

    String importBnHrAttendance(List<BnHrAttendance> bnHrAttendances, BnHrAttendance bnHrAttendance);

    int deleteBnHrAttendanceByCreateDate(BnHrAttendance bnHrAttendance);
}
