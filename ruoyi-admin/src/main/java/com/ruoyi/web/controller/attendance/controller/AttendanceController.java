package com.ruoyi.web.controller.attendance.controller;

import com.ruoyi.attendance.domain.BnHrAttendance;
import com.ruoyi.attendance.service.IBnHrAttendanceService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.salary.domain.BnHrSalary;
import com.ruoyi.salary.service.IBnHrSalaryService;
import com.ruoyi.web.controller.tool.ExcelUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 人力资源工资统计Controller
 * 
 * @author ls
 * @date 2022-02-16
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController extends BaseController
{
    private String prefix = "attendance";

    @Autowired
    private IBnHrAttendanceService bnHrAttendanceService;
    @Autowired
    private IBnHrSalaryService bnHrSalaryService;

    //@RequiresPermissions("salary:role:view")
    @GetMapping()
    public String salary()
    {
        return prefix + "/index";
    }



    /**
     * 查询考勤列表
     */
//    @RequiresPermissions("salary:attendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BnHrAttendance bnHrAttendance)
    {
        bnHrAttendance = bnHrAttendanceService.selectDeptName2(bnHrAttendance);
        startPage();
        List<BnHrAttendance> list = bnHrAttendanceService.selectBnHrAttendanceList(bnHrAttendance);
        return getDataTable(list);
    }

    /**
     * 导出人力资源工资统计列表
     */
    //@RequiresPermissions("salary:role:export")
    @Log(title = "人力资源工资统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    @ResponseBody
    public void export(BnHrAttendance bnHrAttendance, HttpServletResponse response)
    {
        bnHrAttendance = bnHrAttendanceService.selectDeptName2(bnHrAttendance);
        List<BnHrAttendance> bnHrAttendances = bnHrAttendanceService.selectBnHrAttendanceList(bnHrAttendance);
        ExcelUtils.exportAttendanceExcel(response, bnHrAttendances);
    }

    /**
     * 导出人力资源工资统计列表
     */
    //@RequiresPermissions("salary:role:exportData")
    @Log(title = "人力资源工资统计", businessType = BusinessType.EXPORT)
    @PostMapping("/exportData")
    @ResponseBody
    public AjaxResult exportData(BnHrAttendance bnHrAttendance, HttpServletResponse response)
    {
        List<BnHrAttendance> list = bnHrAttendanceService.selectBnHrAttendanceList(bnHrAttendance);
        ExcelUtil<BnHrAttendance> util = new ExcelUtil<BnHrAttendance>(BnHrAttendance.class);
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
    public AjaxResult importData(MultipartFile file, BnHrAttendance bnHrAttendance) throws Exception
    {
        List<BnHrAttendance> bnHrAttendances = ExcelUtils.readBnHrAttendanceExcel(file);
        String message = "";
        try{
            message = bnHrAttendanceService.importBnHrAttendance(bnHrAttendances, bnHrAttendance);
        }catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
        }
        return AjaxResult.success(message);
    }

    /**
     * 新增保存人力资源工资统计
     */
//    //@RequiresPermissions("salary:role:add")
    @Log(title = "添加考勤统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BnHrAttendance bnHrAttendance)
    {
        return toAjax(bnHrAttendanceService.insertBnHrAttendance(bnHrAttendance));
    }


    /**
     * 修改保存人力资源工资统计
     */
    //@RequiresPermissions("salary:role:edit")
    @Log(title = "修改考勤统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BnHrAttendance bnHrAttendance)
    {
        return toAjax(bnHrAttendanceService.updateBnHrAttendance(bnHrAttendance));
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
        return toAjax(bnHrAttendanceService.deleteBnHrAttendanceByIds(ids));
    }

    /**
     * 删除人力资源工资统计
     */
    //@RequiresPermissions("salary:role:remove")
    @Log(title = "人力资源工资统计", businessType = BusinessType.DELETE)
    @PostMapping( "/removeMonth")
    @ResponseBody
    public AjaxResult removeMonth(BnHrAttendance bnHrAttendance)
    {
        return toAjax(bnHrAttendanceService.deleteBnHrAttendanceByCreateDate(bnHrAttendance));
    }
}
