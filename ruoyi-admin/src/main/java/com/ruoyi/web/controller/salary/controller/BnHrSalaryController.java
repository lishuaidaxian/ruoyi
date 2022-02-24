package com.ruoyi.web.controller.salary.controller;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.demo.domain.UserOperateModel;
import com.ruoyi.web.controller.tool.ExcelUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.salary.domain.BnHrSalary;
import com.ruoyi.salary.service.IBnHrSalaryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 人力资源工资统计Controller
 * 
 * @author ls
 * @date 2022-02-16
 */
@Controller
@RequestMapping("/salary")
public class BnHrSalaryController extends BaseController
{
    private String prefix = "salary";

    @Autowired
    private IBnHrSalaryService bnHrSalaryService;

    //@RequiresPermissions("salary:role:view")
    @GetMapping()
    public String salary()
    {
        return prefix + "/salary";
    }

    /**
     * 查询人力资源工资统计列表
     */
    //@RequiresPermissions("salary:role:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BnHrSalary bnHrSalary)
    {
        startPage();
        List<BnHrSalary> list = bnHrSalaryService.selectBnHrSalaryList(bnHrSalary);
        return getDataTable(list);
    }

    /**
     * 导出人力资源工资统计列表
     */
    //@RequiresPermissions("salary:role:export")
    @Log(title = "人力资源工资统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    @ResponseBody
    public void export(BnHrSalary bnHrSalary, HttpServletResponse response)
    {
        List<BnHrSalary> list = bnHrSalaryService.selectBnHrSalaryList(bnHrSalary);
        ExcelUtil<BnHrSalary> util = new ExcelUtil<BnHrSalary>(BnHrSalary.class);
        ExcelUtils.exportSalaryExcel(response);
//        return util.exportExcel(list, "人力资源工资统计数据");
    }

    /**
     * 导出人力资源工资统计列表
     */
    //@RequiresPermissions("salary:role:exportData")
    @Log(title = "人力资源工资统计", businessType = BusinessType.EXPORT)
    @PostMapping("/exportData")
    @ResponseBody
    public AjaxResult exportData(BnHrSalary bnHrSalary, HttpServletResponse response)
    {
        List<BnHrSalary> list = bnHrSalaryService.selectBnHrSalaryList(bnHrSalary);
        ExcelUtil<BnHrSalary> util = new ExcelUtil<BnHrSalary>(BnHrSalary.class);
        return util.exportExcel(list, "人力资源工资统计数据");
    }

    /**
     * 新增人力资源工资统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BnHrSalary> util = new ExcelUtil<BnHrSalary>(BnHrSalary.class);
        return util.importTemplateExcel("工资数据");
    }



    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, BnHrSalary bnHrSalary) throws Exception
    {
//        ExcelUtil<BnHrSalary> util = new ExcelUtil<BnHrSalary>(BnHrSalary.class);
//        List<BnHrSalary> salaryList = util.importExcel(file.getInputStream());
        List<BnHrSalary> bnHrSalaries = ExcelUtils.readExcel(file);
        String message = "";
        try{
            message = bnHrSalaryService.importBnHrSalary(bnHrSalaries, bnHrSalary);
        }catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
        }
        return AjaxResult.success(message);
    }

    /**
     * 导入用户数据
     *
     * @param salaryList 用户数据列表
     * @return 结果
     */
    public String importBnHrSalary(List<BnHrSalary> salaryList)
    {
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

    /**
     * 新增保存人力资源工资统计
     */
//    //@RequiresPermissions("salary:role:add")
    @Log(title = "人力资源工资统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BnHrSalary bnHrSalary)
    {
        return toAjax(bnHrSalaryService.insertBnHrSalary(bnHrSalary));
    }

    /**
     * 修改人力资源工资统计
     */
    //@RequiresPermissions("salary:role:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BnHrSalary bnHrSalary = bnHrSalaryService.selectBnHrSalaryById(id);
        mmap.put("bnHrSalary", bnHrSalary);
        return prefix + "/edit";
    }

    /**
     * 修改保存人力资源工资统计
     */
    //@RequiresPermissions("salary:role:edit")
    @Log(title = "人力资源工资统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BnHrSalary bnHrSalary)
    {
        return toAjax(bnHrSalaryService.updateBnHrSalary(bnHrSalary));
    }

    /**
     * 删除人力资源工资统计
     */
    //@RequiresPermissions("salary:role:remove")
    @Log(title = "人力资源工资统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bnHrSalaryService.deleteBnHrSalaryByIds(ids));
    }
}
