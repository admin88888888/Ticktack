package com.qianfeng.service.impl;

import com.qianfeng.dao.UserMapper;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.VUserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User findPwdByNo(String no) {

        return null;
    }

    @Override
    public List<VUserRoleInfo> findAllUserRole(int page, int limit, String no, Integer flag) {
        List<VUserRoleInfo> list = null;
        int start = (page - 1) * limit;
        try {

            list = userMapper.findAllUserRole(start, limit, no , flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int findUserRoleCount() {
        int count = 0;
        try {
           count = userMapper.findUserRoleCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void UserRoleDelete(Integer id, Integer rid) {

        try {
            userMapper.UserRoleDelete(id, rid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
