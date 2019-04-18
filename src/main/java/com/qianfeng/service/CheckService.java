package com.qianfeng.service;

import com.qianfeng.entity.Check;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CheckService {

    /**
     *  分页查询考勤管理信息
     * @param page
     *      第几页
     * @param limit
     *      查询几条数据
     * @return
     */
    List<Check> findCheckToDo(int page, int limit);

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
     *  获取我的所有记录
     * @return
     */
    List<Check> findCheckAll(String startname, int page, int limit);

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
     * 添加信息
     * @param record
     * @return
     */
    int insertSelective(Check record);

    /**
     * 通过任务号查询记录
     * @param pid
     * @return
     */
    Check findByPid(String pid);
}
