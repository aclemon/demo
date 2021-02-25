package com.example.schedule;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
    static final Semaphore sp = new Semaphore(3);
    static final Semaphore spq = new Semaphore(30);
    static BlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<Runnable>(50);
    static RejectedExecutionHandler abort = new ThreadPoolExecutor.AbortPolicy();
    static ThreadFactory namedThreadFacgtory = new ThreadFactoryBuilder().setNamePrefix("test-pool-").build();
    static ExecutorService fixedThreadPool = new ThreadPoolExecutor(3, 5, 50L, TimeUnit.MILLISECONDS, blockQueue,
            namedThreadFacgtory, abort);

    public static void main(String[] args) throws Exception {
//        testAA();
//        log.info("开始执行");
//        TestAsync testAsync = new TestAsync();
//        testAsync.testCompletableFuture();
//        log.info("执行结束");
//        log.info("执行完成");
//        thenApply();
//        runAsync();

//        testRR();


        for (int i = 0; i < 10; i++) {
            log.info("main.runAsync++++++:{}", i);
//            sp.tryAcquire(10, TimeUnit.SECONDS);
            sp.acquire();
            int finalI = i;
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
                try {
                    runAsync(finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    sp.release();
                }
            });

//            voidCompletableFuture.get();

        }
        while (true) {
            TimeUnit.SECONDS.sleep(1000);
        }
    }

    private static void testRR() {
        System.out.println("testRR");
        CompletableFuture future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("sdfsdf");
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("over");
            }
        });
        //同步等待消息执行结果
        try {
            log.info("get" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Async
    boolean isUnique() throws InterruptedException {
        log.info("isUnique");
        TimeUnit.SECONDS.sleep(5);
        otherAsync();
        return true;
    }

    @Async
    boolean otherAsync() throws InterruptedException {
        log.info("otherAsync");
        TimeUnit.SECONDS.sleep(5);
        return true;
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
    public static void runAsync(Integer integer) throws Exception {
        log.info("页码{}:runAsync开始---", integer);

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                silentSign(integer);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }, fixedThreadPool);
//        future.get();
        silentSign(integer);
//        while (!future.isDone()) {
//            /**
//             * 线程池的每个线程都有一个任务队列，如果有的线程早早完成了的话，那么可能会从
//             * 其他线程的队列中“偷”过任务来执行，称为work-stealing。
//             * getStealCount方法可以用来衡量多线程的任务分派是否合理。数字太大说明分派不均
//             * 匀，数字太小，则最好考虑不使用work-stealing，因为“偷”的过程也有一定的开销。
//             */
//            log.debug("!future.isDone()");
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                log.error("ex:", e);
//            }
//        }
//
        log.info("页码{}:runAsync结束---", integer);
    }


    private static void silentSign(Integer integer) throws InterruptedException, ExecutionException {

//         List<CompletableFuture<Void>> completableFutures = resolvers.stream()
//                .map(resolver -> supplyAsync(() -> task.doWork()))
//                .collect(toList());
//        CompletableFuture.allOf()

        List<CompletableFuture<Void>> completableFutures = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            log.info("任务：{}---第{}，silentSign+++", integer, i);
            CompletableFuture<Void> silentSignxx = CompletableFuture.runAsync(() -> {
                try {
                    log.info("silentSignxx");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, fixedThreadPool);
            completableFutures.add(silentSignxx);
//            silentSignxx.get();
            log.info("任务：{}第{}，silentSign---", integer, i);
        }

//        List<CompletableFuture<R>> futureList = taskList.stream().map(workFunction).collect(Collectors.toList());
        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allCompletableFuture.get();
//        CompletableFuture.allOf(completableFutures.stream().);
//        voidCompletableFuture.get();
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
