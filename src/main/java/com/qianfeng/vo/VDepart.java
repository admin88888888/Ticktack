package com.qianfeng.vo;

import java.util.Date;

public class VDepart {

    private Integer id;
    private String name;
    private Integer snum;
    private Date createtime;

    public VDepart() {}

    public VDepart(Integer id, String name, Integer snum, Date createtime) {
        this.id = id;
        this.name = name;
        this.snum = snum;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
