package com.example.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * @description: 线程池配置
 * @Date : 2019/4/25 下午2:36
 * @Author : 石冬冬-Seig Heil
 */
@Configuration
@EnableAsync
@Slf4j
public class ThreadPoolConfig {

    static final int BLOCKING_QUEUE_CAPACITY = 5000;

    static final int KEEP_ALIVE_TIME = 60;

    static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    static final int CORE_POOL_SIZE = AVAILABLE_PROCESSORS * 8;

    static final int MAXIMUM_POOL_SIZE = 50;

    static {
        log.info("[availableProcessors]={},corePoolSize={},maximumPoolSize={}", AVAILABLE_PROCESSORS, CORE_POOL_SIZE, MAXIMUM_POOL_SIZE);
    }

    /**
     * 通用线程池配置
     *
     * @return
     */
    @Bean
    public ExecutorService threadPoolExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNamePrefix("common-pool-%d").build();
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(BLOCKING_QUEUE_CAPACITY), threadFactory);
    }

    /**
     * 跑批待处理订单线程池配置
     * blockingQueueCapacity 需要设置合理大小，目前上线一周，每日跑批 1175单左右；即便线程池已满，使用拒绝策略；有补偿机制。
     *
     * @return
     */
    @Bean
    public ExecutorService disposeOrderHandleThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNamePrefix("disposeOrder-pool-%d").build();
        final int corePoolSize = AVAILABLE_PROCESSORS * 6, maxPoolSize = corePoolSize * 2, keepAliveTime = 60, blockingQueueCapacity = 5000;
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(blockingQueueCapacity), threadFactory);
    }

}
