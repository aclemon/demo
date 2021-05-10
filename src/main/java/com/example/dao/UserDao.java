package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.entity.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-28 14:28:19
 */
//@Mapper
public interface UserDao extends BaseMapper<User> {

    //    ew.customSqlSegment又是啥，该值是WHERE + sql语句
    @Select("select ${ew.sqlSelect} from system_user t ${ew.customSqlSegment}")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 10)
    @ResultType(User.class)
    void getUserListBigData(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, ResultHandler<User> handler);

}
