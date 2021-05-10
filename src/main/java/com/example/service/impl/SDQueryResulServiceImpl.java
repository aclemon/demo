package com.example.service.impl;

/**
 * @Author: w00990
 * @Date: 2021/4/12
 */

import com.example.dao.SDQueryWrapper;
import com.example.mybatis.SDQueryResultHandler;
import com.example.service.ISDQueryResulService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SDQueryResulServiceImpl extends SDQueryResultHandler implements ISDQueryResulService {

    private final static Logger logger = LoggerFactory.getLogger(SDQueryResulServiceImpl.class);

    @Resource
    private SDQueryWrapper sdQueryWrapper;

    @Override
    public void batchSDHandle() {
        String sql = "select * from system_user";
        SDQueryResulServiceImpl sdQueryResulService = new SDQueryResulServiceImpl();
        //批量处理数据量  根据实际情况设置
        sdQueryResulService.setBatchSize(2);
        //1.按批次处理查询结果集数据
        sdQueryWrapper.streamDataDynamicHandle(sql, sdQueryResulService);
        //2.处理最后一个批次的查询结果数据
        sdQueryResulService.lastSDHandle();
    }

    /**
     * 在这里可以对你获取到的批量结果数据进行需要的业务处理
     */
    @Override
    public void handle() {
        try {
            logger.info("---------------------:{}", list.size());
            //list 批量查询结果集,对此list进行业务处理
            for (int i = 0; i < list.size(); i++) {
                logger.info("---------------------:{}", list.get(i).get("username"));
            }
        } finally {
            // 处理完每批数据后后将临时清空
            size = 0;
            list.clear();
        }
    }
}

