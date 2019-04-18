package com.qianfeng.dao;

import com.qianfeng.entity.Check;
import com.qianfeng.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Check record);

    /**
     * 添加信息
     * @param record
     * @return
     */
    int insertSelective(Check record);

    Check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);

    /**
     *  分页查询考勤管理代办信息
     * @param start
     *      从第几条数据开始查
     * @param limit
     *      查询几条数据
     * @return
     */
    List<Check> findCheckToDo(@Param("start") int start, @Param("limit") int limit);

    /**
     *获取待处理总数
     * @return
     */
    int findToDoCount();



    /**
     *  获取考勤管理信息总数
     * @return
     */
    int findCheckCount();

    /**
     * 根据发起人名称获取我的所有记录
     * @param startname
     *      发起人名称
     * @param start
     *      从第几个数据开始查
     * @param limit
     *      查几条数据
     * @return
     */
    List<Check> findCheckAll(@Param("startname") String startname, @Param("start") int start, @Param("limit") int limit);

    /**
     * 根据发起人名称获取我的所有记录总数
     * @param startname
     *      发起人名称
     * @return
     */
    int findRecordCount(String startname);

    /**
     * 事项进行对指定记录进行状态改变flag为2同意，flag为3拒绝
     * @param id
     *      指定记录的id
     * @param flag
     *      改变记录的状态
     */
    void updateMatter(@Param("id") int id, @Param("flag") int flag);


    /**
     * 通过发起人姓名获取记录信息
     * @param startname
     * @return
     */
    List<Check> findCheckByStartName(String startname);

    /**
     * 通过任务号查询记录
     * @param pid
     * @return
     */
    Check findByPid(String pid);

}