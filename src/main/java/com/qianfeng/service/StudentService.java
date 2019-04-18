package com.qianfeng.service;

import com.qianfeng.entity.Student;
import com.qianfeng.vo.VStudent;

import java.util.List;

public interface StudentService {

    public List<VStudent> findStuAll();

    public void deleteByStudentNo(String no);

    public void addStudent(Student student);

    public void updateGrade(Student student);

    public void addStudentBatch(List<Student> list);

}
