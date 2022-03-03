package com.ruoyi.application.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入职申请对象 bn_hr_application
 * 
 * @author ls
 * @date 2022-03-01
 */
public class BnHrApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 身份证 */
    @Excel(name = "身份证")
    private String idCard;

    /** 民族 */
    @Excel(name = "民族")
    private String national;

    /** 个人电话 */
    @Excel(name = "个人电话")
    private String phone;

    /** 常住地址 */
    @Excel(name = "常住地址")
    private String address;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalLandscape;

    /** 户口类型 */
    @Excel(name = "户口类型")
    private String accountType;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String maritalStatus;

    /** 紧急联系电话 */
    @Excel(name = "紧急联系电话")
    private String tel;

    /** 电子信箱 */
    @Excel(name = "电子信箱")
    private String email;

    /** 最高学历毕业学校 */
    @Excel(name = "最高学历毕业学校")
    private String mostSchool;

    /** 最高学历毕业时间 */
    @Excel(name = "最高学历毕业时间")
    private String mostDate;

    /** 最高学历专业 */
    @Excel(name = "最高学历专业")
    private String mostPro;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String mostRecord;

    /** 第一学历毕业学校 */
    @Excel(name = "第一学历毕业学校")
    private String firstSchool;

    /** 第一学历毕业时间 */
    @Excel(name = "第一学历毕业时间")
    private String firstDate;

    /** 第一学历专业 */
    @Excel(name = "第一学历专业")
    private String firstPro;

    /** 第一学历 */
    @Excel(name = "第一学历")
    private String firstRecord;

    /** 个人简介 */
    @Excel(name = "个人简介")
    private String personalProfile;

    /** 推荐人 */
    @Excel(name = "推荐人")
    private String referees;

    /** 对象身份证号 */
    @Excel(name = "对象身份证号")
    private String secondCard;

    /** 对象姓名 */
    @Excel(name = "对象姓名")
    private String secondName;

    /** 对象电话 */
    @Excel(name = "对象电话")
    private String secondPhone;

    /** 对象工作单位 */
    @Excel(name = "对象工作单位")
    private String secondUnits;

    /** 父亲姓名 */
    @Excel(name = "父亲姓名")
    private String fatherName;

    /** 父亲身份证号或生日 */
    @Excel(name = "父亲身份证号或生日")
    private String fatherCard;

    /** 母亲姓名 */
    @Excel(name = "母亲姓名")
    private String motherName;

    /** 母亲身份证号或生日 */
    @Excel(name = "母亲身份证号或生日")
    private String motherCard;

    /** 子女名字身份证号或生日 */
    @Excel(name = "子女名字身份证号或生日")
    private String childrenCard;

    /** 兄弟姐妹名字姓名 */
    @Excel(name = "兄弟姐妹名字姓名")
    private String brotherName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setNational(String national) 
    {
        this.national = national;
    }

    public String getNational() 
    {
        return national;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }
    public void setPoliticalLandscape(String politicalLandscape) 
    {
        this.politicalLandscape = politicalLandscape;
    }

    public String getPoliticalLandscape() 
    {
        return politicalLandscape;
    }
    public void setAccountType(String accountType) 
    {
        this.accountType = accountType;
    }

    public String getAccountType() 
    {
        return accountType;
    }
    public void setMaritalStatus(String maritalStatus) 
    {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() 
    {
        return maritalStatus;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setMostSchool(String mostSchool) 
    {
        this.mostSchool = mostSchool;
    }

    public String getMostSchool() 
    {
        return mostSchool;
    }
    public void setMostDate(String mostDate) 
    {
        this.mostDate = mostDate;
    }

    public String getMostDate() 
    {
        return mostDate;
    }
    public void setMostPro(String mostPro) 
    {
        this.mostPro = mostPro;
    }

    public String getMostPro() 
    {
        return mostPro;
    }
    public void setMostRecord(String mostRecord) 
    {
        this.mostRecord = mostRecord;
    }

    public String getMostRecord() 
    {
        return mostRecord;
    }
    public void setFirstSchool(String firstSchool) 
    {
        this.firstSchool = firstSchool;
    }

    public String getFirstSchool() 
    {
        return firstSchool;
    }
    public void setFirstDate(String firstDate) 
    {
        this.firstDate = firstDate;
    }

    public String getFirstDate() 
    {
        return firstDate;
    }
    public void setFirstPro(String firstPro) 
    {
        this.firstPro = firstPro;
    }

    public String getFirstPro() 
    {
        return firstPro;
    }
    public void setFirstRecord(String firstRecord) 
    {
        this.firstRecord = firstRecord;
    }

    public String getFirstRecord() 
    {
        return firstRecord;
    }
    public void setPersonalProfile(String personalProfile) 
    {
        this.personalProfile = personalProfile;
    }

    public String getPersonalProfile() 
    {
        return personalProfile;
    }
    public void setReferees(String referees) 
    {
        this.referees = referees;
    }

    public String getReferees() 
    {
        return referees;
    }
    public void setSecondCard(String secondCard) 
    {
        this.secondCard = secondCard;
    }

    public String getSecondCard() 
    {
        return secondCard;
    }
    public void setSecondName(String secondName) 
    {
        this.secondName = secondName;
    }

    public String getSecondName() 
    {
        return secondName;
    }
    public void setSecondPhone(String secondPhone) 
    {
        this.secondPhone = secondPhone;
    }

    public String getSecondPhone() 
    {
        return secondPhone;
    }
    public void setSecondUnits(String secondUnits) 
    {
        this.secondUnits = secondUnits;
    }

    public String getSecondUnits() 
    {
        return secondUnits;
    }
    public void setFatherName(String fatherName) 
    {
        this.fatherName = fatherName;
    }

    public String getFatherName() 
    {
        return fatherName;
    }
    public void setFatherCard(String fatherCard) 
    {
        this.fatherCard = fatherCard;
    }

    public String getFatherCard() 
    {
        return fatherCard;
    }
    public void setMotherName(String motherName) 
    {
        this.motherName = motherName;
    }

    public String getMotherName() 
    {
        return motherName;
    }
    public void setMotherCard(String motherCard) 
    {
        this.motherCard = motherCard;
    }

    public String getMotherCard() 
    {
        return motherCard;
    }
    public void setChildrenCard(String childrenCard) 
    {
        this.childrenCard = childrenCard;
    }

    public String getChildrenCard() 
    {
        return childrenCard;
    }
    public void setBrotherName(String brotherName) 
    {
        this.brotherName = brotherName;
    }

    public String getBrotherName() 
    {
        return brotherName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("idCard", getIdCard())
            .append("national", getNational())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("nativePlace", getNativePlace())
            .append("politicalLandscape", getPoliticalLandscape())
            .append("accountType", getAccountType())
            .append("maritalStatus", getMaritalStatus())
            .append("tel", getTel())
            .append("email", getEmail())
            .append("mostSchool", getMostSchool())
            .append("mostDate", getMostDate())
            .append("mostPro", getMostPro())
            .append("mostRecord", getMostRecord())
            .append("firstSchool", getFirstSchool())
            .append("firstDate", getFirstDate())
            .append("firstPro", getFirstPro())
            .append("firstRecord", getFirstRecord())
            .append("personalProfile", getPersonalProfile())
            .append("referees", getReferees())
            .append("secondCard", getSecondCard())
            .append("secondName", getSecondName())
            .append("secondPhone", getSecondPhone())
            .append("secondUnits", getSecondUnits())
            .append("fatherName", getFatherName())
            .append("fatherCard", getFatherCard())
            .append("motherName", getMotherName())
            .append("motherCard", getMotherCard())
            .append("childrenCard", getChildrenCard())
            .append("brotherName", getBrotherName())
            .toString();
    }
}
