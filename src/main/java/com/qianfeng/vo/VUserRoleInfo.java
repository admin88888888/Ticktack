package com.qianfeng.vo;

import com.qianfeng.entity.Role;

import java.util.List;

public class VUserRoleInfo {

    private Integer id;

    private String no;

    private String name;

    private Integer flag;

    /*private String info;
    private Integer rid;*/
    private List<Role> rids;

    public List<Role> getRids() {
        return rids;
    }

    public void setRids(List<Role> rids) {
        this.rids = rids;
    }
/*public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
