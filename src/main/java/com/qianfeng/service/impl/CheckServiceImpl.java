package com.qianfeng.service.impl;

import com.qianfeng.dao.CheckMapper;
import com.qianfeng.entity.Check;
import com.qianfeng.service.CheckService;
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
}
