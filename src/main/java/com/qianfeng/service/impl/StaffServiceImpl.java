package com.qianfeng.service.impl;
/**
 * Copyright (C), 2019-2019, dff
 * FileName: StaffServiceImpl
 * Author:   DFF
 * Date:     2019/4/16 15:08
 * Description:
 */

import com.qianfeng.dao.StaffMapper;
import com.qianfeng.entity.Staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.vo.VStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




/**
 * Created by DFF on 2019/4/16.
 */

    @Service
    public class StaffServiceImpl implements StaffService {
        @Autowired
        private StaffMapper staffMapper;
        @Override
        public List<VStaff> sstaffFindAll() {
            List<VStaff> list = null;
            try {
                list = staffMapper.staffFindAll();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                throw new RuntimeException("查询所有员工数据异常");
            }
            return list;
        }

        @Override
        public void saddStaff(Staff sta) {
            // 添加前，先判断是否有同等工号的员工
            Staff staff = staffMapper.findStaffByNo(sta.getNo());
            if(staff != null){
                /*if (staff.getFlag() == 2) {
                    // 数据库有这个员工存在，只是flag失效，则更改
                    staffMapper.updateStaffFlag(sta);
                } else {*/
                    throw new RuntimeException("存在同名员工，不能添加");
                //}
            } else {
                // 添加数据
                sta.setFlag(1);
                staffMapper.addStaff(sta);
            }
        }

        @Override
        public Staff sfindStaffByNo(String no) {
            return staffMapper.findStaffByNo(no);
        }

        @Override
        public void supdateStaff(Staff sta) {
            // 判断是否存在
            Staff staff = staffMapper.findStaffByNo(sta.getNo());
            if(staff != null){
                // 更新
                staffMapper.updateStaff(sta);
            }else {
                throw new RuntimeException("没有该员工，不能修改");
            }
        }

        @Override
        public void sdeleteStaffByNo(String no) {
            staffMapper.deleteStaffByNo(no);
        }

        @Override
        public List<Staff> selectAllRecruiter() {

            return staffMapper.selectAllRecruiter();
        }

        @Override
        public void addBatch(List<Staff> list) {
            int count = 1;
            List<Staff> tempList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {

                if (count % 100 != 0) {
                    tempList.add(list.get(i));
                    count++;
                } else {
                    staffMapper.addBatch(tempList);
                    tempList.clear();
                    tempList.add(list.get(i));
                    count = 1;
                }

            }
            if (tempList.size() != 0) {
                staffMapper.addBatch(tempList);
            }
        }
    }


