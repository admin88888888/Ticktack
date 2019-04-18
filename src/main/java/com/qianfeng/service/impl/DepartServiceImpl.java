package com.qianfeng.service.impl;

import com.qianfeng.dao.departMapper;
import com.qianfeng.entity.depart;
import com.qianfeng.service.DepartService;
import com.qianfeng.vo.VDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private departMapper depDao;

    @Override
    public List<VDepart> findByAll() {
        List<VDepart> list = depDao.findAll();
        return list;
    }

    @Override
    public void deleteId(int id) {
        depDao.deleteByPrimaryKey(id);
    }

    @Override
    public void add(depart depart) {
        // 添加前，先判断是否有同样的部门，如果有，不能添加
        com.qianfeng.entity.depart dep1 = depDao.findByName(depart.getName());
        if(dep1 != null){
            throw new RuntimeException("部门重复，不能添加");
        }
        depDao.insertSelective(depart);
    }

    @Override
    public void updateDepart(depart depart) {
        depDao.updateByPrimaryKeySelective(depart);
    }
}
