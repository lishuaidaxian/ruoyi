package com.ruoyi.web.controller.application.wx;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.application.domain.BnHrApplication;
import com.ruoyi.application.service.IBnHrApplicationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入职申请Controller
 * 
 * @author ls
 * @date 2022-02-25
 */
@Controller
@RequestMapping("/wx/application")
public class BnHrWxApplicationController extends BaseController
{
    private String prefix = "application";

    @Autowired
    private IBnHrApplicationService bnHrApplicationService;

    @GetMapping()
    public String application()
    {
        return prefix + "/application";
    }

    /**
     * 查询入职申请列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BnHrApplication bnHrApplication)
    {
        startPage();
        List<BnHrApplication> list = bnHrApplicationService.selectBnHrApplicationList(bnHrApplication);
        return getDataTable(list);
    }

    /**
     * 导出入职申请列表
     */
    @Log(title = "入职申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BnHrApplication bnHrApplication)
    {
        List<BnHrApplication> list = bnHrApplicationService.selectBnHrApplicationList(bnHrApplication);
        ExcelUtil<BnHrApplication> util = new ExcelUtil<BnHrApplication>(BnHrApplication.class);
        return util.exportExcel(list, "入职申请数据");
    }

    /**
     * 新增入职申请
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存入职申请
     */
    @Log(title = "入职申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BnHrApplication bnHrApplication)
    {
        return toAjax(bnHrApplicationService.insertBnHrApplication(bnHrApplication));
    }

    /**
     * 修改入职申请
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BnHrApplication bnHrApplication = bnHrApplicationService.selectBnHrApplicationById(id);
        mmap.put("bnHrApplication", bnHrApplication);
        return prefix + "/edit";
    }

    /**
     * 修改保存入职申请
     */
    @RequiresPermissions("attendance:application:edit")
    @Log(title = "入职申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BnHrApplication bnHrApplication)
    {
        return toAjax(bnHrApplicationService.updateBnHrApplication(bnHrApplication));
    }

    /**
     * 删除入职申请
     */
    @RequiresPermissions("attendance:application:remove")
    @Log(title = "入职申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bnHrApplicationService.deleteBnHrApplicationByIds(ids));
    }
}
