package com.qianfeng.vo;

import java.util.Date;

public class VGrade {

    private int id;
    private String name;
    private String cname;
    private Integer cnum;
    private String week;
    private String location;
    private Date createdate;

    public VGrade() {}

    public VGrade(int id, String name, String cname, Integer cnum, String week, String location, Date createdate) {
        this.id = id;
        this.name = name;
        this.cname = cname;
        this.cnum = cnum;
        this.week = week;
        this.location = location;
        this.createdate = createdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}