package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.VUserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UseRoleController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserRole.do")
   public Map<String,Object> findAllUserRole(){


        Map<String, Object> map = new HashMap<>();

        try {
            List<VUserRoleInfo> list = userService.findAllUserRole();
            int userCount = userService.findUserCount();
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", userCount);
            map.put("data", list);

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
