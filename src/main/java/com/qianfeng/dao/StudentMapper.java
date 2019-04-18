package com.qianfeng.dao;

import com.qianfeng.entity.Student;
import com.qianfeng.vo.VStudent;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String no);

    /**
     * 修改学员信息
     * @param student
     * @return
     */
    int updateByPrimaryKeySelective(Student student);

    int updateByPrimaryKey(Student record);

    /**
     * 查询所有学员
     * @return
     */
    public List<VStudent> findAll();

    /**
     * 根绝学号'no'删除学员
     */
    public void deleteByNo(String no);

    /**
     * 添加学员
     * @param student
     */
    public void add(Student student);

    /**
     * 批量添加
     * @param list
     */
    public void addBatch(List<Student> list);

    /**
     * 查询学员学号
     * @param no
     * @return
     */
    public Student findByNo(String no);
}