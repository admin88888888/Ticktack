package com.qianfeng.service;

import com.qianfeng.entity.Grade;
import com.qianfeng.vo.VGrade;

import java.util.List;

public interface GradeService {

    public List<Grade> selectByGrade();

    public List<VGrade> findByAll();

    public void deleteByGradeId(int id);

    public void addGrade(Grade grade);

    public void updateGrade(Grade grade);

}
