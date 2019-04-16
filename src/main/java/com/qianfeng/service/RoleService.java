package com.qianfeng.service;

import com.qianfeng.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     *  获取所有角色信息
     * @return
     */
    List<Role> selectRoleAll(int page, int limit, String no, Integer flag);

    /**
     *  获取所有角色总数
     * @return
     */
    int selectRoleCount();

    /**
     * 获取有效的所有的角色信息
     * @return
     */
    List<Role> selectAll();

    /**
     * 通过改变角色状态达到假删除角色
     * @param id
     *      角色id
     */
    void roleFalseDelete(Integer id);


}
