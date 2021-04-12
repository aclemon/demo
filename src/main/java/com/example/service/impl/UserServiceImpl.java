package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-01-28 14:28:19
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public List<User> getUserListBigData(String sqlSelect, List<Long> subDeptIdList) {
        List<User> appUserEntities = new ArrayList<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(sqlSelect);
        queryWrapper.gt("id", 0);
//        queryWrapper.eq("status", 0);
//        queryWrapper.eq("del_flag", 0);
//        queryWrapper.in("dept_id", subDeptIdList);
//        queryWrapper.getCustomSqlSegment();
        // 流式条件查询
        ResultHandler<User> userResultHandler = resultContext -> {
            log.info("查询结果,{}", resultContext);

            Optional.ofNullable(resultContext.getResultObject()).ifPresent(appUserEntities::add);
        };

        this.baseMapper.getUserListBigData(queryWrapper, userResultHandler);

        return appUserEntities;
    }

}
