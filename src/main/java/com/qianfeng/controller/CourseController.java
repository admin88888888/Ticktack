package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Course;
import com.qianfeng.service.CourseService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list.do")
    @ResponseBody
    public Map<String, Object> findAllByCourse(int page,int limit){
        PageHelper.startPage(page, limit);
        Map<String, Object> map = new HashMap<>();
        try {
            List<Course> list = courseService.findAllCourse();

            long total = ((Page)list).getTotal();
            map.put("code", 0); // 0表示成功
            map.put("msg", "");
            map.put("count", total);
            map.put("data", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/add.do")

    public String insertSelective(Course record){

        courseService.insertSelective(record);
        return "redirect:/courselist.html";

    }

    @RequestMapping("flagDelete.do")
    @ResponseBody
    public JsonBean flagDeleteCourse(int id){

        courseService.flagDeleteCourse(id);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("update.do")
    public String updateByPrimaryKeySelective(Course record){

        courseService.updateByPrimaryKeySelective(record);
        return "redirect:/courselist.html";
    }
}
