package com.ruoyi.salary.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人力资源工资统计对象 bn_hr_salary
 * 
 * @author ls
 * @date 2022-02-17
 */
public class BnHrSalary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String card;

    /** 工资卡号 */
    @Excel(name = "工资卡号")
    private String bankCard;

    /** 开户银行 */
    @Excel(name = "开户银行")
    private String bankName;

    /** 行号 */
    @Excel(name = "行号")
    private String bankLine;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    /** 出勤天数 */
    @Excel(name = "出勤天数")
    private BigDecimal cqDays;

    /** 岗位工资 */
    @Excel(name = "岗位工资")
    private BigDecimal gwSal;

    /** 标准绩效 */
    @Excel(name = "标准绩效")
    private String bzjx;

    /** 绩效工资 */
    @Excel(name = "绩效工资")
    private BigDecimal jxSal;

    /** 出勤工资 */
    @Excel(name = "出勤工资")
    private BigDecimal cqSal;

    /** 年终奖 */
    @Excel(name = "年终奖")
    private BigDecimal yearSal;

    /** 扣款 */
    @Excel(name = "扣款")
    private BigDecimal kq;

    /** 工龄补助 */
    @Excel(name = "工龄补助")
    private BigDecimal glbz;

    /** 职称补贴 */
    @Excel(name = "职称补贴")
    private BigDecimal zcbt;

    /** 学历补贴 */
    @Excel(name = "学历补贴")
    private BigDecimal xlbt;

    /** 保健费 */
    @Excel(name = "保健费")
    private BigDecimal bjf;

    /** 夜餐补助 */
    @Excel(name = "夜餐补助")
    private BigDecimal ycbz;

    /** 高温补贴 */
    @Excel(name = "高温补贴")
    private BigDecimal gwbt;

    /** 交通补贴 */
    @Excel(name = "交通补贴")
    private BigDecimal jtbt;

    /** 其他补贴 */
    @Excel(name = "其他补贴")
    private BigDecimal qtbt;

    /** 实发补贴 */
    @Excel(name = "实发补贴")
    private BigDecimal sfbt;

    /** 应发工资 */
    @Excel(name = "应发工资")
    private BigDecimal yfgz;

    /** 养老保险 */
    @Excel(name = "养老保险")
    private BigDecimal ylbx;

    /** 医疗保险 */
    @Excel(name = "医疗保险")
    private BigDecimal ylbx2;

    /** 失业保险 */
    @Excel(name = "失业保险")
    private BigDecimal sybx;

    /** 住房公积金 */
    @Excel(name = "住房公积金")
    private BigDecimal zfgjj;

    /** 个税 */
    @Excel(name = "个税")
    private BigDecimal gs;

    /** 房款 */
    @Excel(name = "房款")
    private BigDecimal fk;

    /** 其他扣款 */
    @Excel(name = "其他扣款")
    private BigDecimal qtkk;

    /** 实发工资 */
    @Excel(name = "实发工资")
    private BigDecimal sfgz;

    /** 领款人签字 */
    @Excel(name = "领款人签字")
    private String lkSign;

    /** 公司 */
    @Excel(name = "公司")
    private String company;

    /** 车间 */
    @Excel(name = "车间")
    private String department;

    /** 录入日期 */
    @Excel(name = "录入日期")
    private String toDate;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改时间 */
    private Date updateDate;

    /** 删除标志(0:未删除1:已删除) */
    private Integer isDel;

    /** 审核标志(0:未审核1:审核通过2:审核驳回) */
    private Integer checkNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCard(String card) 
    {
        this.card = card;
    }

    public String getCard() 
    {
        return card;
    }
    public void setBankCard(String bankCard) 
    {
        this.bankCard = bankCard;
    }

    public String getBankCard() 
    {
        return bankCard;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setBankLine(String bankLine) 
    {
        this.bankLine = bankLine;
    }

    public String getBankLine() 
    {
        return bankLine;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setCqDays(BigDecimal cqDays)
    {
        this.cqDays = cqDays;
    }

    public BigDecimal getCqDays()
    {
        return cqDays;
    }
    public void setGwSal(BigDecimal gwSal) 
    {
        this.gwSal = gwSal;
    }

    public BigDecimal getGwSal() 
    {
        return gwSal;
    }
    public void setBzjx(String bzjx) 
    {
        this.bzjx = bzjx;
    }

    public String getBzjx() 
    {
        return bzjx;
    }
    public void setJxSal(BigDecimal jxSal) 
    {
        this.jxSal = jxSal;
    }

    public BigDecimal getJxSal() 
    {
        return jxSal;
    }
    public void setCqSal(BigDecimal cqSal) 
    {
        this.cqSal = cqSal;
    }

    public BigDecimal getCqSal() 
    {
        return cqSal;
    }
    public void setYearSal(BigDecimal yearSal) 
    {
        this.yearSal = yearSal;
    }

    public BigDecimal getYearSal() 
    {
        return yearSal;
    }
    public void setKq(BigDecimal kq) 
    {
        this.kq = kq;
    }

    public BigDecimal getKq() 
    {
        return kq;
    }
    public void setGlbz(BigDecimal glbz) 
    {
        this.glbz = glbz;
    }

    public BigDecimal getGlbz() 
    {
        return glbz;
    }
    public void setZcbt(BigDecimal zcbt) 
    {
        this.zcbt = zcbt;
    }

    public BigDecimal getZcbt() 
    {
        return zcbt;
    }
    public void setXlbt(BigDecimal xlbt) 
    {
        this.xlbt = xlbt;
    }

    public BigDecimal getXlbt() 
    {
        return xlbt;
    }
    public void setBjf(BigDecimal bjf) 
    {
        this.bjf = bjf;
    }

    public BigDecimal getBjf() 
    {
        return bjf;
    }
    public void setYcbz(BigDecimal ycbz) 
    {
        this.ycbz = ycbz;
    }

    public BigDecimal getYcbz() 
    {
        return ycbz;
    }
    public void setGwbt(BigDecimal gwbt) 
    {
        this.gwbt = gwbt;
    }

    public BigDecimal getGwbt() 
    {
        return gwbt;
    }
    public void setJtbt(BigDecimal jtbt) 
    {
        this.jtbt = jtbt;
    }

    public BigDecimal getJtbt() 
    {
        return jtbt;
    }
    public void setQtbt(BigDecimal qtbt) 
    {
        this.qtbt = qtbt;
    }

    public BigDecimal getQtbt() 
    {
        return qtbt;
    }
    public void setSfbt(BigDecimal sfbt) 
    {
        this.sfbt = sfbt;
    }

    public BigDecimal getSfbt() 
    {
        return sfbt;
    }
    public void setYfgz(BigDecimal yfgz) 
    {
        this.yfgz = yfgz;
    }

    public BigDecimal getYfgz() 
    {
        return yfgz;
    }
    public void setYlbx(BigDecimal ylbx) 
    {
        this.ylbx = ylbx;
    }

    public BigDecimal getYlbx() 
    {
        return ylbx;
    }
    public void setYlbx2(BigDecimal ylbx2) 
    {
        this.ylbx2 = ylbx2;
    }

    public BigDecimal getYlbx2() 
    {
        return ylbx2;
    }
    public void setSybx(BigDecimal sybx) 
    {
        this.sybx = sybx;
    }

    public BigDecimal getSybx() 
    {
        return sybx;
    }
    public void setZfgjj(BigDecimal zfgjj) 
    {
        this.zfgjj = zfgjj;
    }

    public BigDecimal getZfgjj() 
    {
        return zfgjj;
    }
    public void setGs(BigDecimal gs) 
    {
        this.gs = gs;
    }

    public BigDecimal getGs() 
    {
        return gs;
    }
    public void setFk(BigDecimal fk) 
    {
        this.fk = fk;
    }

    public BigDecimal getFk() 
    {
        return fk;
    }
    public void setQtkk(BigDecimal qtkk) 
    {
        this.qtkk = qtkk;
    }

    public BigDecimal getQtkk() 
    {
        return qtkk;
    }
    public void setSfgz(BigDecimal sfgz) 
    {
        this.sfgz = sfgz;
    }

    public BigDecimal getSfgz() 
    {
        return sfgz;
    }
    public void setLkSign(String lkSign) 
    {
        this.lkSign = lkSign;
    }

    public String getLkSign() 
    {
        return lkSign;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setIsDel(Integer isDel) 
    {
        this.isDel = isDel;
    }

    public Integer getIsDel() 
    {
        return isDel;
    }
    public void setCheckNum(Integer checkNum) 
    {
        this.checkNum = checkNum;
    }

    public Integer getCheckNum() 
    {
        return checkNum;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("card", getCard())
            .append("bankCard", getBankCard())
            .append("bankName", getBankName())
            .append("bankLine", getBankLine())
            .append("deptName", getDeptName())
            .append("deptId", getDeptId())
            .append("cqDays", getCqDays())
            .append("gwSal", getGwSal())
            .append("bzjx", getBzjx())
            .append("jxSal", getJxSal())
            .append("cqSal", getCqSal())
            .append("yearSal", getYearSal())
            .append("kq", getKq())
            .append("glbz", getGlbz())
            .append("zcbt", getZcbt())
            .append("xlbt", getXlbt())
            .append("bjf", getBjf())
            .append("ycbz", getYcbz())
            .append("gwbt", getGwbt())
            .append("jtbt", getJtbt())
            .append("qtbt", getQtbt())
            .append("sfbt", getSfbt())
            .append("yfgz", getYfgz())
            .append("ylbx", getYlbx())
            .append("ylbx2", getYlbx2())
            .append("sybx", getSybx())
            .append("zfgjj", getZfgjj())
            .append("gs", getGs())
            .append("fk", getFk())
            .append("qtkk", getQtkk())
            .append("sfgz", getSfgz())
            .append("lkSign", getLkSign())
            .append("company", getCompany())
            .append("department", getDepartment())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updateDate", getUpdateDate())
            .append("updateBy", getUpdateBy())
            .append("isDel", getIsDel())
            .append("checkNum", getCheckNum())
            .append("remark", getRemark())
            .toString();
    }
}
