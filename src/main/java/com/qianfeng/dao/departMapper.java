package com.qianfeng.dao;

import com.qianfeng.entity.depart;

public interface departMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(depart record);

    int insertSelective(depart record);

    depart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(depart record);

    int updateByPrimaryKey(depart record);
}