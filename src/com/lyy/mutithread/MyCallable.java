package com.lyy.mutithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 * @autohor liuyouyun
 * @date 2022/1/7 - 10:51
 */
public class MyCallable  {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(i);
                        sum += i;
                    }
                }
                return sum;
            }
        });
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
