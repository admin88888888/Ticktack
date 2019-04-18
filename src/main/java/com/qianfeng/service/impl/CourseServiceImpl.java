package com.qianfeng.service.impl;

import com.qianfeng.dao.CourseMapper;
import com.qianfeng.entity.Course;
import com.qianfeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseDao;

    @Override
    public List<Course> findAllCourse() {
        List<Course> list = courseDao.findAll();
        return list;
    }



    @Override
    public Course findCourseByName(String name) {
        Course course = null;
        if (name != null){
            courseDao.findCourseByName(name);
        }
        return course;
    }

    @Override
    public int insertSelective(Course record) {

        Course course = courseDao.findCourseByName(record.getName());
        if (course != null){
            throw new RuntimeException("该课程表已存在！！！");
        }

        record.setFlag(1);
        int a = -1;
        try {

           a = courseDao.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public void flagDeleteCourse(int id) {

        courseDao.flagDeleteCourse(id);
    }

    @Override
    public void updateByPrimaryKeySelective(Course record) {

        courseDao.updateByPrimaryKeySelective(record);
    }
}
