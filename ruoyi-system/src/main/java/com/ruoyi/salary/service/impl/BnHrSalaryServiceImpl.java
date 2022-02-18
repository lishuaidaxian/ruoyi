package com.ruoyi.salary.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.salary.mapper.BnHrSalaryMapper;
import com.ruoyi.salary.domain.BnHrSalary;
import com.ruoyi.salary.service.IBnHrSalaryService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 人力资源工资统计Service业务层处理
 * 
 * @author ls
 * @date 2022-02-16
 */
@Service
public class BnHrSalaryServiceImpl implements IBnHrSalaryService 
{
    @Autowired
    private BnHrSalaryMapper bnHrSalaryMapper;

    /**
     * 查询人力资源工资统计
     * 
     * @param id 人力资源工资统计主键
     * @return 人力资源工资统计
     */
    @Override
    public BnHrSalary selectBnHrSalaryById(Long id)
    {
        return bnHrSalaryMapper.selectBnHrSalaryById(id);
    }

    /**
     * 查询人力资源工资统计列表
     * 
     * @param bnHrSalary 人力资源工资统计
     * @return 人力资源工资统计
     */
    @Override
    public List<BnHrSalary> selectBnHrSalaryList(BnHrSalary bnHrSalary)
    {
        return bnHrSalaryMapper.selectBnHrSalaryList(bnHrSalary);
    }

    /**
     * 新增人力资源工资统计
     * 
     * @param bnHrSalary 人力资源工资统计
     * @return 结果
     */
    @Override
    public int insertBnHrSalary(BnHrSalary bnHrSalary)
    {
        return bnHrSalaryMapper.insertBnHrSalary(bnHrSalary);
    }

    /**
     * 修改人力资源工资统计
     * 
     * @param bnHrSalary 人力资源工资统计
     * @return 结果
     */
    @Override
    public int updateBnHrSalary(BnHrSalary bnHrSalary)
    {
        return bnHrSalaryMapper.updateBnHrSalary(bnHrSalary);
    }

    /**
     * 批量删除人力资源工资统计
     * 
     * @param ids 需要删除的人力资源工资统计主键
     * @return 结果
     */
    @Override
    public int deleteBnHrSalaryByIds(String ids)
    {
        return bnHrSalaryMapper.deleteBnHrSalaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人力资源工资统计信息
     * 
     * @param id 人力资源工资统计主键
     * @return 结果
     */
    @Override
    public int deleteBnHrSalaryById(Long id)
    {
        return bnHrSalaryMapper.deleteBnHrSalaryById(id);
    }


    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public String importBnHrSalary(List<BnHrSalary> salaryList) {
        if (StringUtils.isNull(salaryList) || salaryList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BnHrSalary bnHrSalary : salaryList)
        {
            try{
                bnHrSalaryMapper.insertBnHrSalary(bnHrSalary);
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
}
