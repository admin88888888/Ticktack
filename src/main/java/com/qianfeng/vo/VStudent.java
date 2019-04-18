package com.qianfeng.vo;

import java.util.Date;

public class VStudent {

    private String no;

    private String name;

    private String gradename;

    private String sex;

    private String phone;

    private String email;

    private String school;

    private String education;

    private Date birthday;

    private Date createdate;

    public VStudent() {}

    public VStudent(String no, String name, String gradename, String sex, String phone, String email, String school, String education, Date birthday, Date createdate) {
        this.no = no;
        this.name = name;
        this.gradename = gradename;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.school = school;
        this.education = education;
        this.birthday = birthday;
        this.createdate = createdate;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
