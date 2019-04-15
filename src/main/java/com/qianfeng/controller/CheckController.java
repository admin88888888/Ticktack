package com.qianfeng.controller;

import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import com.qianfeng.service.CheckService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;

    @RequestMapping("/processToDoList.do")
    public Map<String, Object> findCheckToDoLimit(int page,int limit){
        List<Check> list = checkService.findCheckToDo(page, limit);
        int count = checkService.findToDoCount();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 0 表示成功
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/processlist.do")
    public Map<String, Object> findCheckRecordLimit(int page, int limit){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Check> list = checkService.findCheckAll(user.getName(), page, limit);
        int count = checkService.findRecordCount(user.getName());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 0 表示成功
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }
}
