//package com.example.schedule;
//
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
///**
// * @Author: w00990
// * @Date: 2021/2/25
// */
//public class FutureTaskWorkerTest {
//
//    @Test
//    public void getAllResult() {
//        List<Long> list = new ArrayList<>(3);
//        list.add(1000L);
//        list.add(2000L);
//        list.add(3000L);
//        FutureTaskWorker<Long, String> futureTaskWorker = new FutureTaskWorker<>(list, (Long e) -> getThreadName(e));
//        long begin = System.currentTimeMillis();
//        List<String> allResult = futureTaskWorker.getAllResult();
//        long end = System.currentTimeMillis();
//        System.out.println(allResult);
//        System.out.println("结束耗时:" + (end - begin));
//    }
//
//
//    private CompletableFuture<String> getThreadName(long sleepTime) {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(sleepTime);
//                System.out.println(Thread.currentThread().getName() + "已经睡眠" + sleepTime + "毫秒");
//                return Thread.currentThread().getName();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        });
//    }
//}
