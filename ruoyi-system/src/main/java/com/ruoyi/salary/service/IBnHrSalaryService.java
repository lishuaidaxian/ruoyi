package com.ruoyi.salary.service;

import java.util.List;
import com.ruoyi.salary.domain.BnHrSalary;

/**
 * 人力资源工资统计Service接口
 * 
 * @author ls
 * @date 2022-02-16
 */
public interface IBnHrSalaryService 
{
    /**
     * 查询人力资源工资统计
     * 
     * @param id 人力资源工资统计主键
     * @return 人力资源工资统计
     */
    public BnHrSalary selectBnHrSalaryById(Long id);

    /**
     * 查询人力资源工资统计列表
     * 
     * @param bnHrSalary 人力资源工资统计
     * @return 人力资源工资统计集合
     */
    public List<BnHrSalary> selectBnHrSalaryList(BnHrSalary bnHrSalary);

    /**
     * 新增人力资源工资统计
     * 
     * @param bnHrSalary 人力资源工资统计
     * @return 结果
     */
    public int insertBnHrSalary(BnHrSalary bnHrSalary);

    /**
     * 修改人力资源工资统计
     * 
     * @param bnHrSalary 人力资源工资统计
     * @return 结果
     */
    public int updateBnHrSalary(BnHrSalary bnHrSalary);

    /**
     * 批量删除人力资源工资统计
     * 
     * @param ids 需要删除的人力资源工资统计主键集合
     * @return 结果
     */
    public int deleteBnHrSalaryByIds(String ids);

    /**
     * 删除人力资源工资统计信息
     * 
     * @param id 人力资源工资统计主键
     * @return 结果
     */
    public int deleteBnHrSalaryById(Long id);

    String importBnHrSalary(List<BnHrSalary> bnHrSalaries);
}
