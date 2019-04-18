package com.qianfeng.service;

import com.qianfeng.entity.Staff;
import com.qianfeng.vo.VStaff;

import java.util.List;

public interface StaffService {
    // 查找所有员工
    public List<VStaff> sstaffFindAll();

    // 员工添加
    public void saddStaff(Staff sta);

    // 员工修改（修改时先获取修改的员工信息）
    public Staff sfindStaffByNo(String no);
    public void supdateStaff(Staff sta);

    // 员工删除（根据no删除员工数据）
    public void sdeleteStaffByNo(String no);

    //查询所有招生老师
    public List<Staff> selectAllRecruiter();

    public void addBatch(List<Staff> list);
}

