package com.lyy.mutithread;

/**
 * @autohor liuyouyun
 * @date 2022/1/7 - 10:59
 */
public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread tr1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if(i % 5 == 0){
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        });

        Thread tr2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if(i % 3 == 0){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        });
        tr1.start();
        tr2.start();

        for (int i = 0; i < 1000; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***********main()************");
            }
        }
    }
}
