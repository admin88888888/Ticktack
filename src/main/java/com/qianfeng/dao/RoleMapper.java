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
     *  获取所有角色信息分页和条件查询
     * @return
     */
    List<Role> selectRoleAll(@Param("start") int start, @Param("limit") int limit, @Param("name") String no, @Param("flag") Integer flag);

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

    /**
     * 获得我的角色信息
     * @param id
     * @return
     */
    List<Role> findMyRole(int id);

}