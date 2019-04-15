package com.qianfeng.dao;

import com.qianfeng.entity.Authority;
import com.qianfeng.vo.VMenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    /**
     * 根据用户id获取权限
     * @param id
     *      用户id
     * @return
     */
    public List<VMenuInfo> findAuthorityAll(int id);

    /**
     * 获取所有权限信息
     * @return
     *      成功返回权限集合，失败为null
     */
    List<Authority> findAll(@Param("start") int start,@Param("limit") int limit);

    /**
     * 获取所有权限总数
     * @return
     *      成功返回总数，失败返回0
     */
    int findAuthorityCount();
}