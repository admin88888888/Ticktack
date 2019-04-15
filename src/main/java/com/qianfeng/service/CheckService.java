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
}
