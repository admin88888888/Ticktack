package com.qianfeng.service;



import com.qianfeng.entity.User;
import com.qianfeng.vo.VUserRoleInfo;

import java.util.List;


public interface UserService {

    /**
     *
     * 根据工号查询用户信息
     * @param no
     *      工号
     * @return
     *      成功返回User对象，失败null
     */
    public User findPwdByNo(String no);

    /**
     * 获取所有用户角色信息
     * @return
     */
    public List<VUserRoleInfo> findAllUserRole();

    /**
     *  获取用户人数
     * @return
     *      成功返回总人数,失败返回0
     */
    public int findUserCount();
}