package com.example.schedule;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: w00990
 * @Date: 2021/2/20
 */
@Slf4j
public class TestAsync {
    //日期格式器
    private final static DateFormat format = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws Exception {
//        testAA();

        log.info("开始执行");
//        TestAsync testAsync = new TestAsync();
//        testAsync.testCompletableFuture();
//        log.info("执行完成");
        thenApply();
//        runAsync();
    }

    private static void thenApply() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1=" + result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t * 5;
                System.out.println("result2=" + result);
                return result;
            }
        });

        long result = future.get();
        System.out.println(result);
    }

    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.SECONDS.sleep(100);
                log.info("线程---");
            }
        });
        log.info("结束---");
        future.get();
        log.info("get结束---");
    }

    private void testCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                if (isUnique()) {
//                    TimeUnit.SECONDS.sleep(10);
                    log.info("线程---");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        log.info("结束---");
        voidCompletableFuture.get();
        log.info("get结束---");

    }

    @Async
    boolean isUnique() throws InterruptedException {
        log.info("isUnique");
        TimeUnit.SECONDS.sleep(100);
        return true;
    }

    private static void testAA() throws InterruptedException, ExecutionException {
        //异步处理，把每个待处理订单放在disposeOrderHandleThreadPool（待处理线程池）去处理
//        CompletableFuture.runAsync(() -> operateStrategyManager.execute(operateContext), disposeOrderHandleThreadPool);
        ExecutorService executor = ExecutorBuilder.create()
                .setCorePoolSize(5)
                .setMaxPoolSize(10)
                .setWorkQueue(new LinkedBlockingQueue<>(100))
                .build();
        CompletionService<String> objectCompletionService = ThreadUtil.newCompletionService(executor);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            objectCompletionService.submit(
                    new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            Thread.sleep(100);
                            return String.format("CompletionServiced调用：%s,调用时间：%s", finalI, TestAsync.format.format(new Date()));
                        }
                    }
            );
        }
        //显示商品图片
        try {
            for (int i = 0; i < 10; i++) {
                Future<String> imageFuture = objectCompletionService.take();
                String image = imageFuture.get();
                log.info("结果：{},当前时间：{}", image, format.format(new Date()));
            }
        } catch (InterruptedException e) {
            // 如果显示图片发生中断异常则重新设置线程的中断状态
            // 这样做可以让wait中的线程唤醒
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            try {
                throw new Throwable(e.getCause());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }


    }
}
