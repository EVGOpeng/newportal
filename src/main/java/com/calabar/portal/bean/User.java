package com.calabar.portal.bean;

import com.calabar.portal.bean.common.BaseQuery;
import com.calabar.portal.utils.Validator;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@ToString
public class User extends BaseQuery {
    private long id;
    private String code;
    private String name;
    private String sex;
    private long departId;
    private String category;
    private long companyid;
    private String worksection;
    private String workcompany;
    private long seqencing;
    private long status;
    private String creator;
    private Date lastEditDate;
    private String officePhone;
    private String telPhone;
    private String account;
    //职位
    private String job;
    //地址
    private String address;
    //传真
    private String fax;
    //房号
    private String homeNumber;
    private String imgurl;
    //邮箱
    private String email;
    //微信号
    private String wechat;
    //qq
    private String qq;
    //主数据ID
    private String mid;
    /**
     *新角色
     */
    private List<Role> list;
    /**
     * 老角色
     */
    private List<OldRole> roles;

    public List<Role> getList() {
        return list;
    }

    public void setList(List<Role> list) {
        this.list = list;
    }

    public List<OldRole> getRoles() {
        return roles;
    }

    public void setRoles(List<OldRole> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(Validator.isNull(name)){
            this.name = "";
        }
        this.name = name;
    }
    public String getOfficePhone() {
        return officePhone;
    }
    public void setOfficePhone(String officePhone) {
        if(Validator.isNull(officePhone)){
            this.officePhone = "";
        }else{
            this.officePhone = officePhone;
        }
    }
    public String getTelPhone() {
        return telPhone;
    }
    public void setTelPhone(String telPhone) {
        if(Validator.isNull(telPhone)){
            this.telPhone = "";
        }else{
            this.telPhone = telPhone;
        }
    }
    public long getDepartId() {
        return departId;
    }
    public void setDepartId(long departId) {
        this.departId = departId;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public long getCompanyid() {
        return companyid;
    }
    public void setCompanyid(long companyid) {
        this.companyid = companyid;
    }
    public String getWorksection() {
        return worksection;
    }
    public void setWorksection(String worksection) {
        this.worksection = worksection;
    }
    public String getWorkcompany() {
        return workcompany;
    }
    public void setWorkcompany(String workcompany) {
        this.workcompany = workcompany;
    }
    public long getSeqencing() {
        return seqencing;
    }
    public void setSeqencing(long seqencing) {
        this.seqencing = seqencing;
    }
    public long getStatus() {
        return status;
    }
    public void setStatus(long status) {
        this.status = status;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Date getLastEditDate() {
        return lastEditDate;
    }
    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        if(Validator.isNull(job)){
            this.job = "";
        }else{
            this.job = job;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(Validator.isNull(address)){
            this.address = "";
        }else{
            this.address = address;
        }
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        if(Validator.isNull(fax)){
            this.fax = "";
        }else{
            this.fax = fax;
        }
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        if(Validator.isNull(homeNumber)){
            this.homeNumber = "";
        }else{
            this.homeNumber = homeNumber;
        }
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the wechat
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * @param wechat the wechat to set
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the mid
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
    }
}
