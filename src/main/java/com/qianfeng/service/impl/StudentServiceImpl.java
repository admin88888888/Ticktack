package com.qianfeng.service.impl;

import com.qianfeng.dao.StudentMapper;
import com.qianfeng.entity.Student;
import com.qianfeng.service.StudentService;
import com.qianfeng.vo.VStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper stuDao;

    @Override
    public List<VStudent> findStuAll() {
        return stuDao.findAll();
    }

    @Override
    public void deleteByStudentNo(String no) {
        stuDao.deleteByNo(no);
    }

    @Override
    public void addStudent(Student student) {
        // 添加前，先判断是否有同样的学号，如果有，不能添加
        Student stu = stuDao.findByNo(student.getNo());
        if(stu != null){
            throw new RuntimeException("学号重复，不能添加");
        }
        // 添加数据
        stuDao.add(student);
    }

    @Override
    public void updateGrade(Student student) {
        stuDao.updateByPrimaryKeySelective(student);
    }

    @Override
    public void addStudentBatch(List<Student> list) {
        // 每100条记录，进行一次批量操作
        int count = 1;
        List<Student> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){

            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                stuDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if(tempList.size() != 0){
            stuDao.addBatch(tempList);
        }
    }
}
