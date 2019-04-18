package com.qianfeng.dao;

import com.qianfeng.entity.Staff;
import com.qianfeng.vo.VStaff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(String no);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    // 额外添加

    // 查找所有员工
    public List<VStaff> staffFindAll();

    // 员工添加(员工可能存在同名的情况，从员工的工号来区别是不是有这个员工)
    public void addStaff(Staff sta);

    // 员工修改（修改时先获取修改的员工信息）
    public Staff findStaffByNo(String no);
    public void updateStaff(Staff sta);

    // 员工删除（根据no更改员工为无效）
    public void deleteStaffByNo(String no);

    // 员工更改为有效
    public void updateStaffFlag(Staff sta);

    //查询所有招生老师
    public List<Staff> selectAllRecruiter();

    // 员工批量导入
    public void addBatch(List<Staff> list);

}