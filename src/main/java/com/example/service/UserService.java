package com.example.service;

import com.example.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-01-28 14:28:19
 */
public interface UserService extends WService<User> {

    /**
     * 查询
     *
     * @param sqlSelect
     * @param subDeptIdList
     * @return
     */
    List<User> getUserListBigData(String sqlSelect, List<Long> subDeptIdList);
}
