package com.ruoyi.application.service.impl;

import java.util.List;

import com.ruoyi.application.domain.BnHrApplication;
import com.ruoyi.application.mapper.BnHrApplicationMapper;
import com.ruoyi.application.service.IBnHrApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 入职申请Service业务层处理
 * 
 * @author ls
 * @date 2022-02-25
 */
@Service
public class BnHrApplicationServiceImpl implements IBnHrApplicationService
{
    @Autowired
    private BnHrApplicationMapper bnHrApplicationMapper;

    /**
     * 查询入职申请
     * 
     * @param id 入职申请主键
     * @return 入职申请
     */
    @Override
    public BnHrApplication selectBnHrApplicationById(Long id)
    {
        return bnHrApplicationMapper.selectBnHrApplicationById(id);
    }

    /**
     * 查询入职申请列表
     * 
     * @param bnHrApplication 入职申请
     * @return 入职申请
     */
    @Override
    public List<BnHrApplication> selectBnHrApplicationList(BnHrApplication bnHrApplication)
    {
        return bnHrApplicationMapper.selectBnHrApplicationList(bnHrApplication);
    }

    /**
     * 新增入职申请
     * 
     * @param bnHrApplication 入职申请
     * @return 结果
     */
    @Override
    public int insertBnHrApplication(BnHrApplication bnHrApplication)
    {
        return bnHrApplicationMapper.insertBnHrApplication(bnHrApplication);
    }

    /**
     * 修改入职申请
     * 
     * @param bnHrApplication 入职申请
     * @return 结果
     */
    @Override
    public int updateBnHrApplication(BnHrApplication bnHrApplication)
    {
        return bnHrApplicationMapper.updateBnHrApplication(bnHrApplication);
    }

    /**
     * 批量删除入职申请
     * 
     * @param ids 需要删除的入职申请主键
     * @return 结果
     */
    @Override
    public int deleteBnHrApplicationByIds(String ids)
    {
        return bnHrApplicationMapper.deleteBnHrApplicationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除入职申请信息
     * 
     * @param id 入职申请主键
     * @return 结果
     */
    @Override
    public int deleteBnHrApplicationById(Long id)
    {
        return bnHrApplicationMapper.deleteBnHrApplicationById(id);
    }
}
