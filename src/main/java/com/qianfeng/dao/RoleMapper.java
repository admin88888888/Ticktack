package com.qianfeng.dao;

import com.qianfeng.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     *  获取所有角色信息
     * @return
     */
    List<Role> selectRoleAll(@Param("start") int start, @Param("limit") int limit);

    /**
     *  获取所有角色总数
     * @return
     */
    int selectRoleCount();
}