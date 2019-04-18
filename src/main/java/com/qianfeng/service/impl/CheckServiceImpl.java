package com.qianfeng.service.impl;

import com.qianfeng.dao.CheckMapper;
import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import com.qianfeng.service.CheckService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public List<Check> findCheckToDo(int page, int limit) {
        List<Check> list = null;
        try {
            int start = (page - 1) * limit;
            list = checkMapper.findCheckToDo(start , limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int findToDoCount() {
        int count = 0;
        try {
            count = checkMapper.findToDoCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int findCheckCount() {

        int count = 0;
        try {
            count = checkMapper.findCheckCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Check> findCheckAll(String startname, int page, int limit) {

        List<Check> list = null;
        try {
            int start = (page - 1) * limit;
            list = checkMapper.findCheckAll(startname, start, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int findRecordCount(String startname) {
        int count = 0;
        try {
            count = checkMapper.findRecordCount(startname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void updateMatter(int id, int flag) {

        try {
            checkMapper.updateMatter(id, flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertSelective(Check record) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        record.setStartname(user.getName());
        record.setStartno(user.getNo());
        record.setFlag(1);
        int a = 10000;
        int b = (int)(Math.random()*10000);
        a += b;
        String pid = a+"";
        record.setPid(pid);
        List<Check> list = checkMapper.findCheckByStartName(user.getName());
        for (Check pids:list) {
           if( pids.getPid() == record.getPid()){
               return -1;
           }
        }




        int i = 0;
        try {
          i =  checkMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Check findByPid(String pid) {

        Check check = null;
        try {
            check = checkMapper.findByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
