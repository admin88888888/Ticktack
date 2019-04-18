package com.qianfeng.dao;

import com.qianfeng.entity.depart;
import com.qianfeng.vo.VDepart;

import java.util.List;

public interface departMapper {
    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(depart record);

    /**
     * 添加部门
     * @param  depart
     * @return
     */
    int insertSelective(depart depart);

    depart selectByPrimaryKey(Integer id);

    /**
     * 修改部门
     * @param depart
     * @return
     */
    int updateByPrimaryKeySelective(depart depart);

    int updateByPrimaryKey(depart record);

    /**
     * 查询所有部门
     * @return
     */
    public List<VDepart> findAll();

    /**
     * 查询部门名称
     * @param name
     * @return
     */
    public depart findByName(String name);
}