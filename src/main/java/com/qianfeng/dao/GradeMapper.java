package com.qianfeng.dao;

import com.qianfeng.entity.Grade;
import com.qianfeng.vo.VGrade;

import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    /**
     * 修改班级信息
     * @param grade
     * @return
     */
    int updateByPrimaryKeySelective(Grade grade);

    int updateByPrimaryKey(Grade record);

    /**
     * 查询学员班级
     */
    public List<Grade> selectGrade();

    /**
     * 展示所有班级信息
     */
    public List<VGrade> findAll();

    /**
     * 根据id删除班级
     */
    public void deleteById(int id);

    /**
     * 增加班级
     * @param grade
     */
    public void add(Grade grade);

}