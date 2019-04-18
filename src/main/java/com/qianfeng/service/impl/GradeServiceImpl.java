package com.qianfeng.service.impl;

import com.qianfeng.dao.GradeMapper;
import com.qianfeng.entity.Grade;
import com.qianfeng.service.GradeService;
import com.qianfeng.vo.VGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeDao;

    @Override
    public List<Grade> selectByGrade() {
        List<Grade> list = gradeDao.selectGrade();
        return list;
    }

    @Override
    public List<VGrade> findByAll() {
        List<VGrade> list = gradeDao.findAll();
        return list;
    }

    @Override
    public void deleteByGradeId(int id) {
        gradeDao.deleteById(id);
    }

    @Override
    public void addGrade(Grade grade) {
        gradeDao.add(grade);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeDao.updateByPrimaryKeySelective(grade);
    }
}
