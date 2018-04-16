package com.ztx.thread;
/*
*synchronized 同步锁关键字  同步代码块
* */
public class SyncDemo {
    public static int beans = 20;

    public static void main(String args[]) {
        Thread t1 = new Thread() {
            public void run() {
                int bean = 0;
                while (true) {
                    bean = getbean();
                    Thread.yield(); //让出cpu时间 增加线程安全出现的几率
                    System.out.println(this.getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                int bean = 0;
                while (true) {
                    bean = getbean();
                    System.out.println(this.getName() + ":" + bean);
                }
            }
        };
        t1.start();
        t2.start();
    }


    public synchronized static int getbean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        return beans--;

    }
}
