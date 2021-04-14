package com.example.mybatis;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: w00990
 * @Date: 2021/4/12
 */
public abstract class SDQueryResultHandler implements ResultHandler<Map> {

    private final static Logger logger = LoggerFactory.getLogger(SDQueryResultHandler.class);

    // 这是每一个批处理查询的数量
    public int batchSize = 1000;
    //初始值
    public int size = 0;
    // 存储每批数据的临时容器
    public List<Map> list = new ArrayList<Map>();

    @Override
    public void handleResult(ResultContext<? extends Map> resultContext) {
        // 这里获取流式查询每次返回的单条结果
        Map map = resultContext.getResultObject();
        list.add(map);
        size++;
        if (size == batchSize) {
            logger.info("本批次处理数据量 :{}", size);
            handle();
        }
    }

    // 1.这个方需要子类重写此接口，处理具体业务逻辑
    public abstract void handle();

    //处理最后一批不到 batchSize(查询设定的阀值)的数据
    public void lastSDHandle() {
        logger.info("最后批次处理数据量 :{}", size);
        handle();
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
}
