package com.qianfeng.controller;

import com.qianfeng.entity.Role;
import com.qianfeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/roleList.do")
    @ResponseBody
    public Map<String, Object> selectRoleAll(int page,int limit){
        List<Role> list = roleService.selectRoleAll(page, limit);
        int count = roleService.selectRoleCount();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 0 表示成功
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }
}
