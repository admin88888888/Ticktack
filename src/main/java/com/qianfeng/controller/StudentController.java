package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Student;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService stuService;

    @RequestMapping("/list.do")
    public Map<String, Object> stuAll(){
        List<VStudent> list = stuService.findStuAll();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 10);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/studentdelete.do")
    public JsonBean deleteStudent(String no){
        stuService.deleteByStudentNo(no);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("/studentadd.do")
    public void addByStudent(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException {
        stuService.addStudent(student);
        response.sendRedirect(request.getContextPath() + "/studentlist.html");
    }

    @RequestMapping("/query.do")
    public void queryStudent(Student student, HttpServletResponse response, HttpServletRequest request) throws IOException {
        stuService.updateGrade(student);
        response.sendRedirect(request.getContextPath() + "/studentlist.html");
    }

}
