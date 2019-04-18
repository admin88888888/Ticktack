package com.qianfeng.controller;

import com.qianfeng.entity.Course;
import com.qianfeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list.do")
    public List<Course> findAllByCourse(){
        List<Course> list = courseService.findAllCourse();
        return list;
    }

}
