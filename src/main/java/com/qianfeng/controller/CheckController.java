package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import com.qianfeng.service.CheckService;
import com.qianfeng.utils.JsonUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckController {

    @Autowired
    private CheckService checkService;

    /**
     *  展示待办事项
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/processToDoList.do")
    @ResponseBody
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

    /**
     * 展示我的记录
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/processlist.do")
    @ResponseBody
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

    /**
     * 事项进行对指定记录进行状态改变
     * @param id
     * @param flag
     * @return
     */
    @RequestMapping("updateMatter.do")
    @ResponseBody
    public JsonBean updateMatter(int id, int flag){

        checkService.updateMatter(id, flag);
        return JsonUtils.createJsonBean(1000, null);
    }

    @RequestMapping("processAdd.do")
    public String insertSelective(Check record){

        checkService.insertSelective(record);
        return  "redirect:/processlist.html";
    }
}
