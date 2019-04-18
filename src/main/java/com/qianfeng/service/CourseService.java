package com.qianfeng.service;

import com.qianfeng.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> findAllCourse();

    /**
     * 通过名称获取课程信息
     * @param name
     * @return
     */
    Course findCourseByName(String name);

    int insertSelective(Course record);

    void flagDeleteCourse(int id);

    void updateByPrimaryKeySelective(Course record);
}
