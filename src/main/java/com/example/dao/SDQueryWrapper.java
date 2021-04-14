package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.session.ResultHandler;

import java.util.Map;


/**
 * @Author: w00990
 * @Date: 2021/4/12
 */
@Mapper
public interface SDQueryWrapper {

    /**
     * ResultSetType.FORWARD_ONLY 表示游标只向前滚动
     * fetchSize 每次查询數量
     *
     * @param sql     SQL語句
     * @param handler 返回处理数据对象
     * @ResultTyp 定义返回的对象类型
     */
    @Select("${sql}")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1000)
    @ResultType(Map.class)
    void streamDataDynamicHandle(@Param("sql") String sql, ResultHandler<Map> handler);

    @Select("${sql}")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 2)
    @ResultType(User.class)
    void dynamicSelectLargeData1(@Param("sql") String sql, ResultHandler<User> handler);

    @Select("select * from user t ${ew.customSqlSegment}")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1000, statementType = StatementType.PREPARED)
    @ResultType(User.class)
    void getOrgWithBigData(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, ResultHandler<User> handler);
}