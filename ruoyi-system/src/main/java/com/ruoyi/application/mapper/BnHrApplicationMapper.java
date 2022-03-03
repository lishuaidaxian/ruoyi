package com.ruoyi.application.mapper;

import com.ruoyi.application.domain.BnHrApplication;

import java.util.List;

/**
 * 入职申请Mapper接口
 * 
 * @author ls
 * @date 2022-02-25
 */
public interface BnHrApplicationMapper 
{
    /**
     * 查询入职申请
     * 
     * @param id 入职申请主键
     * @return 入职申请
     */
    public BnHrApplication selectBnHrApplicationById(Long id);

    /**
     * 查询入职申请列表
     * 
     * @param bnHrApplication 入职申请
     * @return 入职申请集合
     */
    public List<BnHrApplication> selectBnHrApplicationList(BnHrApplication bnHrApplication);

    /**
     * 新增入职申请
     * 
     * @param bnHrApplication 入职申请
     * @return 结果
     */
    public int insertBnHrApplication(BnHrApplication bnHrApplication);

    /**
     * 修改入职申请
     * 
     * @param bnHrApplication 入职申请
     * @return 结果
     */
    public int updateBnHrApplication(BnHrApplication bnHrApplication);

    /**
     * 删除入职申请
     * 
     * @param id 入职申请主键
     * @return 结果
     */
    public int deleteBnHrApplicationById(Long id);

    /**
     * 批量删除入职申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBnHrApplicationByIds(String[] ids);
}
