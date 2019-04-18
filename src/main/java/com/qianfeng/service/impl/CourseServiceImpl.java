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
}
