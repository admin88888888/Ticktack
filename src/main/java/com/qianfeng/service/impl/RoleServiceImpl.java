package com.qianfeng.service.impl;

import com.qianfeng.dao.RoleMapper;
import com.qianfeng.entity.Role;
import com.qianfeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoleAll(int page,int limit) {

        List<Role> list = null;
        int start = (page - 1) * limit;
        try {
            list = roleMapper.selectRoleAll(page, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int selectRoleCount() {
        int count = 0;
        try {
            count = roleMapper.selectRoleCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
