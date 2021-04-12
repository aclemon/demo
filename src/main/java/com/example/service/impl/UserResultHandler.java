package com.example.service.impl;

import com.example.entity.User;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @Author: w00990
 * @Date: 2021/4/12
 */
public class UserResultHandler<T> implements ResultHandler<T> {
    public final Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    /**
     * 线程池线程数
     */
    private int threadPollNum = 100;

    public UserResultHandler() {
    }

    public UserResultHandler(int threadPollNum) {
        this.threadPollNum = threadPollNum;
    }

    // 线程池
    public ExecutorService executorService = Executors.newFixedThreadPool(threadPollNum);
    // 线程执行结果
    public List<Future> futureList = new ArrayList<>();

    @Override
    public void handleResult(ResultContext<? extends T> resultContext) {
        // 这里获取流式查询每次返回的单条结果
        T user = resultContext.getResultObject();
        while (futureList.size() > 200) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futureList = futureList.stream().filter(future -> !future.isDone()).collect(Collectors.toList());
            logger.info("条数：" + resultContext.getResultCount() + "->未完成结果" + futureList.size());
        }

        UserThread ut = new UserThread(user);
        Future<?> future = executorService.submit(ut);
        futureList.add(future);
    }

    /**
     * 保证所有线程执行完成，并关闭线程池
     */
    public void end() {
        while (futureList.size() != 0) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futureList = futureList.stream().filter(future -> !future.isDone()).collect(Collectors.toList());
        }
        executorService.shutdown();
    }

    public static class UserThread<T> implements Runnable {
        private T obejct;

        public UserThread(T obejct) {
            this.obejct = obejct;
        }

        @Override
        public void run() {
            System.out.println(((User) obejct).getId());
        }

        public T getObejct() {
            return obejct;
        }

        public void setObejct(T obejct) {
            this.obejct = obejct;
        }
    }

}
