package com.example.service.impl;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author: w00990
 * @Date: 2021/1/28
 */

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;


    @Resource
    Redisson redisson;

    /**
     * 可重入锁
     *
     * @throws InterruptedException
     */
    @Test
    public void testLock() throws InterruptedException {
        RLock lock = redisson.getLock("mylock");
        // 默认30秒
        // 加锁以后10秒钟自动解锁
        // 无需调用unlock方法手动解锁
        lock.lock(50, TimeUnit.SECONDS);
        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
//        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
//        boolean b = lock.tryLock();
        //  异步执行的相关方法
        RFuture<Boolean> booleanRFuture = lock.tryLockAsync();

        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        // boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        Console.log("=>");
        Console.log("=>");
        Console.log("=>");
        Console.log("=>");


    }

    int inventory = 11;
    int NUM = 10;

    @Test
    public void testRedisson() throws InterruptedException {


        ExecutorService executorService = ThreadUtil.newExecutor(inventory, inventory, 10);
        long start = System.currentTimeMillis();

        final RLock lock = redisson.getLock("lock1");
        CountDownLatch countDownLatch = ThreadUtil.newCountDownLatch(11);

        for (int i = 0; i <= NUM; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "争抢锁");
                    lock.lock();
                    inventory--;
                    System.out.println(inventory);
                    countDownLatch.countDown();
                    lock.unlock();
                }
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "   总耗时:" + (end - start) + "  库存数为:" + inventory);
    }

    @Test
    public void testAsyncLock() {
        // 异步加锁
        RLock lock = redisson.getLock("anyLock");
        lock.lockAsync();
        lock.lockAsync(10, TimeUnit.SECONDS);
        Future<Boolean> res = lock.tryLockAsync(100, 10, TimeUnit.SECONDS);
    }

    /**
     * 公平锁
     */
    @Test
    public void testFairLock() {
        RLock fairLock = redisson.getFairLock("anyLock");
        fairLock.lockAsync();
        fairLock.lockAsync(10, TimeUnit.SECONDS);
        Future<Boolean> res = fairLock.tryLockAsync(100, 10, TimeUnit.SECONDS);
    }

    @Test
    public void testMultiLock() throws InterruptedException {


        RLock lock1 = redisson.getLock("lock1");
        RLock lock2 = redisson.getLock("lock2");
        RLock lock3 = redisson.getLock("lock3");

        RedissonMultiLock lock = new RedissonMultiLock(lock1, lock2, lock3);
// 给lock1，lock2，lock3加锁，如果没有手动解开的话，10秒钟后将会自动解开
        lock.lock(10, TimeUnit.SECONDS);

// 为加锁等待100秒时间，并在加锁成功10秒钟后自动解开
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        Console.log("=>" + res);
        lock.unlock();
    }


    @Test
    public void testRedLock() {
        RLock lock1 = redisson.getLock("lock1");
        RLock lock2 = redisson.getLock("lock2");
        RLock lock3 = redisson.getLock("lock3");

        RedissonRedLock lock = new RedissonRedLock(lock1, lock2, lock3);
// 同时加锁：lock1 lock2 lock3
// 红锁在大部分节点上加锁成功就算成功。
        lock.lock();
//...
        lock.unlock();
    }

    @Test
    public void testReadWriteLock() throws InterruptedException {
        RReadWriteLock rwlock = redisson.getReadWriteLock("anyRWLock");
        // 10秒钟以后自动解锁
        // 无需调用unlock方法手动解锁
        rwlock.readLock().lock(10, TimeUnit.SECONDS);
        // 或
        rwlock.writeLock().lock(10, TimeUnit.SECONDS);

        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        boolean res = rwlock.readLock().tryLock(100, 10, TimeUnit.SECONDS);
        // 或
        //        boolean res = rwlock.writeLock().tryLock(100, 10, TimeUnit.SECONDS);
        //...
        //        lock.unlock();
    }

    @Test
    public void testSemaphore() throws InterruptedException {
        RSemaphore semaphore = redisson.getSemaphore("semaphore");
        semaphore.acquire();
//或
        semaphore.acquireAsync();
        semaphore.acquire(23);
        semaphore.tryAcquire();
//或
        semaphore.tryAcquireAsync();
        semaphore.tryAcquire(23, TimeUnit.SECONDS);
//或
        semaphore.tryAcquireAsync(23, TimeUnit.SECONDS);
        semaphore.release(10);
        semaphore.release();
//或
        semaphore.releaseAsync();
    }


    @Test
    public void testPermitExpirableSemaphore() throws InterruptedException {
        RPermitExpirableSemaphore semaphore = redisson.getPermitExpirableSemaphore("mySemaphore");
        String permitId = semaphore.acquire();
// 获取一个信号，有效期只有2秒钟。
//        String permitId = semaphore.acquire(2, TimeUnit.SECONDS);
// ...
        semaphore.release(permitId);
    }

    @Test
    public void testCountDownLatch() throws InterruptedException {
        RCountDownLatch latch = redisson.getCountDownLatch("anyCountDownLatch");
        latch.trySetCount(1);
        latch.await();

        // 在其他线程或其他JVM里
//        RCountDownLatch latch = redisson.getCountDownLatch("anyCountDownLatch");
//        latch.countDown();
    }


    @Test
    public void testWrapper() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.ge(User::getId, "1");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(1, 3);
        IPage<User> page1 = userService.page(page, userLambdaQueryWrapper);
        Console.log("list=>" + page1.getRecords());
    }


    @Test
    public void testInsert() {

        User ahuan = User.builder()
                .id("1")
                .username("ahuan")
                .build();
        final boolean b = userService.saveOrUpdate(ahuan);
        Console.log("b=>" + b);
    }

}
