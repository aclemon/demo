package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-28 14:28:19
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select ${ew.sqlSelect} from t_app_usermlq t ${ew.customSqlSegment}")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 10)
    @ResultType(User.class)
    void getUserListBigData(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, ResultHandler<User> handler);

}
