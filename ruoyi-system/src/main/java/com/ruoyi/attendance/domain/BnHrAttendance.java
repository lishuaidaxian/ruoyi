package com.ruoyi.attendance.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考勤对象 bn_hr_attendance
 * 
 * @author ls
 * @date 2022-02-21
 */
public class BnHrAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 部门id */
    @Excel(name = "部门id")
    private String deptId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 部门名称 */
//    @Excel(name = "部门名称")
    private String deptName2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day8;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day10;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day11;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day12;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day13;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day14;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day15;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day16;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day17;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day18;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day19;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day20;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day21;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day22;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day23;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day24;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day25;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day26;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day27;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day28;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day29;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day30;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String day31;

    /** 出勤小时 */
    @Excel(name = "出勤小时")
    private String hours;

    /** 出勤天数 */
    @Excel(name = "出勤天数")
    private String days;

    /** 节日加班 */
    @Excel(name = "节日加班")
    private String jrjb;

    /** 加班 */
    @Excel(name = "加班")
    private String jb;

    /** 长白班 */
    @Excel(name = "长白班")
    private String cbb;

    /** 长夜班 */
    @Excel(name = "长夜班")
    private String cyb;

    /** 调休 */
    @Excel(name = "调休")
    private String tx;

    /** 工伤 */
    @Excel(name = "工伤")
    private String gs;

    /** 陪护假 */
    @Excel(name = "陪护假")
    private String phj;

    /** 婚假 */
    @Excel(name = "婚假")
    private String hj;

    /** 出差 */
    @Excel(name = "出差")
    private String cc;

    /** 探亲班 */
    @Excel(name = "探亲班")
    private String tqb;

    /** 休班 */
    @Excel(name = "休班")
    private String xb;

    /** 丧假 */
    @Excel(name = "丧假")
    private String sj;

    /** 旷工 */
    @Excel(name = "旷工")
    private String kg;

    /** 迟到 */
    @Excel(name = "迟到")
    private String cd;

    /** 早退 */
    @Excel(name = "早退")
    private String zt;

    /** 忘记打卡 */
    @Excel(name = "忘记打卡")
    private String wjdk;

    /** 不在打卡 */
    @Excel(name = "不在打卡")
    private String bzdk;

    /** 日期 */
    @Excel(name = "日期")
    private String createDate;
    /** 日期 */
    @Excel(name = "天数标记(1:28,2:29,3:30,4:31)")
    private String sign;

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
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setDay1(String day1) 
    {
        this.day1 = day1;
    }

    public String getDay1() 
    {
        return day1;
    }
    public void setDay2(String day2) 
    {
        this.day2 = day2;
    }

    public String getDay2() 
    {
        return day2;
    }
    public void setDay3(String day3) 
    {
        this.day3 = day3;
    }

    public String getDay3() 
    {
        return day3;
    }
    public void setDay4(String day4) 
    {
        this.day4 = day4;
    }

    public String getDay4() 
    {
        return day4;
    }
    public void setDay5(String day5) 
    {
        this.day5 = day5;
    }

    public String getDay5() 
    {
        return day5;
    }
    public void setDay6(String day6) 
    {
        this.day6 = day6;
    }

    public String getDay6() 
    {
        return day6;
    }
    public void setDay7(String day7) 
    {
        this.day7 = day7;
    }

    public String getDay7() 
    {
        return day7;
    }
    public void setDay8(String day8) 
    {
        this.day8 = day8;
    }

    public String getDay8() 
    {
        return day8;
    }
    public void setDay9(String day9) 
    {
        this.day9 = day9;
    }

    public String getDay9() 
    {
        return day9;
    }
    public void setDay10(String day10) 
    {
        this.day10 = day10;
    }

    public String getDay10() 
    {
        return day10;
    }
    public void setDay11(String day11) 
    {
        this.day11 = day11;
    }

    public String getDay11() 
    {
        return day11;
    }
    public void setDay12(String day12) 
    {
        this.day12 = day12;
    }

    public String getDay12() 
    {
        return day12;
    }
    public void setDay13(String day13) 
    {
        this.day13 = day13;
    }

    public String getDay13() 
    {
        return day13;
    }
    public void setDay14(String day14) 
    {
        this.day14 = day14;
    }

    public String getDay14() 
    {
        return day14;
    }
    public void setDay15(String day15) 
    {
        this.day15 = day15;
    }

    public String getDay15() 
    {
        return day15;
    }
    public void setDay16(String day16) 
    {
        this.day16 = day16;
    }

    public String getDay16() 
    {
        return day16;
    }
    public void setDay17(String day17) 
    {
        this.day17 = day17;
    }

    public String getDay17() 
    {
        return day17;
    }
    public void setDay18(String day18) 
    {
        this.day18 = day18;
    }

    public String getDay18() 
    {
        return day18;
    }
    public void setDay19(String day19) 
    {
        this.day19 = day19;
    }

    public String getDay19() 
    {
        return day19;
    }
    public void setDay20(String day20) 
    {
        this.day20 = day20;
    }

    public String getDay20() 
    {
        return day20;
    }
    public void setDay21(String day21) 
    {
        this.day21 = day21;
    }

    public String getDay21() 
    {
        return day21;
    }
    public void setDay22(String day22) 
    {
        this.day22 = day22;
    }

    public String getDay22() 
    {
        return day22;
    }
    public void setDay23(String day23) 
    {
        this.day23 = day23;
    }

    public String getDay23() 
    {
        return day23;
    }
    public void setDay24(String day24) 
    {
        this.day24 = day24;
    }

    public String getDay24() 
    {
        return day24;
    }
    public void setDay25(String day25) 
    {
        this.day25 = day25;
    }

    public String getDay25() 
    {
        return day25;
    }
    public void setDay26(String day26) 
    {
        this.day26 = day26;
    }

    public String getDay26() 
    {
        return day26;
    }
    public void setDay27(String day27) 
    {
        this.day27 = day27;
    }

    public String getDay27() 
    {
        return day27;
    }
    public void setDay28(String day28) 
    {
        this.day28 = day28;
    }

    public String getDay28() 
    {
        return day28;
    }
    public void setDay29(String day29) 
    {
        this.day29 = day29;
    }

    public String getDay29() 
    {
        return day29;
    }
    public void setDay30(String day30) 
    {
        this.day30 = day30;
    }

    public String getDay30() 
    {
        return day30;
    }
    public void setDay31(String day31) 
    {
        this.day31 = day31;
    }

    public String getDay31() 
    {
        return day31;
    }
    public void setHours(String hours) 
    {
        this.hours = hours;
    }

    public String getHours() 
    {
        return hours;
    }
    public void setDays(String days) 
    {
        this.days = days;
    }

    public String getDays() 
    {
        return days;
    }
    public void setJrjb(String jrjb) 
    {
        this.jrjb = jrjb;
    }

    public String getJrjb() 
    {
        return jrjb;
    }
    public void setJb(String jb) 
    {
        this.jb = jb;
    }

    public String getJb() 
    {
        return jb;
    }
    public void setCbb(String cbb) 
    {
        this.cbb = cbb;
    }

    public String getCbb() 
    {
        return cbb;
    }
    public void setCyb(String cyb) 
    {
        this.cyb = cyb;
    }

    public String getCyb() 
    {
        return cyb;
    }
    public void setTx(String tx) 
    {
        this.tx = tx;
    }

    public String getTx() 
    {
        return tx;
    }
    public void setGs(String gs) 
    {
        this.gs = gs;
    }

    public String getGs() 
    {
        return gs;
    }
    public void setPhj(String phj) 
    {
        this.phj = phj;
    }

    public String getPhj() 
    {
        return phj;
    }
    public void setHj(String hj) 
    {
        this.hj = hj;
    }

    public String getHj() 
    {
        return hj;
    }
    public void setCc(String cc) 
    {
        this.cc = cc;
    }

    public String getCc() 
    {
        return cc;
    }
    public void setTqb(String tqb) 
    {
        this.tqb = tqb;
    }

    public String getTqb() 
    {
        return tqb;
    }
    public void setXb(String xb) 
    {
        this.xb = xb;
    }

    public String getXb() 
    {
        return xb;
    }
    public void setSj(String sj) 
    {
        this.sj = sj;
    }

    public String getSj() 
    {
        return sj;
    }
    public void setKg(String kg) 
    {
        this.kg = kg;
    }

    public String getKg() 
    {
        return kg;
    }
    public void setCd(String cd) 
    {
        this.cd = cd;
    }

    public String getCd() 
    {
        return cd;
    }
    public void setZt(String zt) 
    {
        this.zt = zt;
    }

    public String getZt() 
    {
        return zt;
    }
    public void setWjdk(String wjdk) 
    {
        this.wjdk = wjdk;
    }

    public String getWjdk() 
    {
        return wjdk;
    }
    public void setBzdk(String bzdk) 
    {
        this.bzdk = bzdk;
    }

    public String getBzdk() 
    {
        return bzdk;
    }
    public void setCreateDate(String createDate) 
    {
        this.createDate = createDate;
    }

    public String getCreateDate() 
    {
        return createDate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDeptName2() {
        return deptName2;
    }

    public void setDeptName2(String deptName2) {
        this.deptName2 = deptName2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("day1", getDay1())
            .append("day2", getDay2())
            .append("day3", getDay3())
            .append("day4", getDay4())
            .append("day5", getDay5())
            .append("day6", getDay6())
            .append("day7", getDay7())
            .append("day8", getDay8())
            .append("day9", getDay9())
            .append("day10", getDay10())
            .append("day11", getDay11())
            .append("day12", getDay12())
            .append("day13", getDay13())
            .append("day14", getDay14())
            .append("day15", getDay15())
            .append("day16", getDay16())
            .append("day17", getDay17())
            .append("day18", getDay18())
            .append("day19", getDay19())
            .append("day20", getDay20())
            .append("day21", getDay21())
            .append("day22", getDay22())
            .append("day23", getDay23())
            .append("day24", getDay24())
            .append("day25", getDay25())
            .append("day26", getDay26())
            .append("day27", getDay27())
            .append("day28", getDay28())
            .append("day29", getDay29())
            .append("day30", getDay30())
            .append("day31", getDay31())
            .append("hours", getHours())
            .append("days", getDays())
            .append("jrjb", getJrjb())
            .append("jb", getJb())
            .append("cbb", getCbb())
            .append("cyb", getCyb())
            .append("tx", getTx())
            .append("gs", getGs())
            .append("phj", getPhj())
            .append("hj", getHj())
            .append("cc", getCc())
            .append("tqb", getTqb())
            .append("xb", getXb())
            .append("sj", getSj())
            .append("kg", getKg())
            .append("cd", getCd())
            .append("zt", getZt())
            .append("wjdk", getWjdk())
            .append("bzdk", getBzdk())
            .append("remark", getRemark())
            .append("createDate", getCreateDate())
            .toString();
    }
}
