package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Grade;
import com.qianfeng.service.GradeService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VGrade;
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
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/gradeName.do")
    public List<Grade> selectGradeName(){
        List<Grade> list = gradeService.selectByGrade();
        return list;
    }

    @RequestMapping("/list.do")
    public Map<String, Object> findByAlLGrade(){
        List<VGrade> list = gradeService.findByAll();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 10);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/gradedelete.do")
    public JsonBean deleteGrade(int id){
        gradeService.deleteByGradeId(id);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("/gradeadd.do")
    public void addAllCourse(Grade grade, HttpServletRequest request, HttpServletResponse response) throws IOException {
        gradeService.addGrade(grade);
        response.sendRedirect(request.getContextPath() + "/gradelist.html");
    }

    @RequestMapping("/gradeupdate.do")
    public void query(Grade grade, HttpServletRequest request, HttpServletResponse response) throws IOException {

        gradeService.updateGrade(grade);
        response.sendRedirect(request.getContextPath() + "/gradelist.html");

    }

}
