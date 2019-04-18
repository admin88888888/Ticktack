package com.qianfeng.dao;

import com.qianfeng.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 查询所有学科
     */
    public List<Course> findAll();

    /**
     * 通过名称获取课程信息
     * @param name
     * @return
     */
    Course findCourseByName(String name);

    void flagDeleteCourse(int id);
}