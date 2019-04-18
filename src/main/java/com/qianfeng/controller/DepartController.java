package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.depart;
import com.qianfeng.service.DepartService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VDepart;
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
@RequestMapping("/dep")
public class DepartController {

    @Autowired
    private DepartService depService;

    @RequestMapping("/list.do")
    public Map<String, Object> findByAlLGrade(){
        List<VDepart> list = depService.findByAll();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 10);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/delete.do")
    public JsonBean deleteById(int id){
        depService.deleteId(id);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("/add.do")
    public void addDepart(depart depart, HttpServletRequest request, HttpServletResponse response) throws IOException {
        depService.add(depart);
        response.sendRedirect(request.getContextPath() + "/departlist.html");
    }

    @RequestMapping("/departupdate.do")
    public void updateByDepart(depart depart, HttpServletResponse response, HttpServletRequest request) throws IOException {
        depService.updateDepart(depart);
        response.sendRedirect(request.getContextPath() + "/departlist.html");
    }

}
