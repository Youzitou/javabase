package com.lyy.mutithread;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * @autohor liuyouyun
 * @date 2022/1/7 - 15:05
 */
public class ThreadPoolTest {
     public static void main(String[] args) {

        Thread tr1 = new Thread(() -> {
            for(int i = 0;i <= 100;i++){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        });

        Thread tr2 = new Thread(() -> {
            for(int i = 0;i <= 100;i++){
                if(i % 2 != 0){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        });

        Callable callable = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                if(i % 2 == 0){
                    System.out.println(i);
                    sum += i;
                }
            }
            return sum;
        };
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
         try {
             tr2.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(tr1);//适合适用于Runnable
        service.execute(tr2);//适合适用于Runnable

        service.submit(callable); //适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }
}
