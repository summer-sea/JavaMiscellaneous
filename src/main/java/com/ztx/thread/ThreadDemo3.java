package com.ztx.thread;

/*
* 线程协同工作
*   download.join() 。等待download线程执行完毕，并行线程就会变成串行
*   当调用wait后必须焦勇notify才会继续执行否则会一直等待
*   object.wait(),和notify（）时必须加上同步锁 否则 语法上没有错误但是运行会报错
*   notifyall(),方法是解除所有的wait，如果有多个wait调用notify的话随机解除一个
* */
public class ThreadDemo3 {
    public static Boolean isFinish;
    public static Object object = new Object();
    public static void main(String args[]){
        final Thread download = new Thread(){
            public void run() {
                System.out.println("开始下载了");
                for (int i = 0; i < 100; i++) {
                    System.out.println("download:" + i + "%");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("图片下载完毕");
                isFinish =true;
                /*
                * 当图片下载完成通知显示图片的线程开始工作
                * 文档中要求必须加锁
                * */
                synchronized (object) {
                    object.notify();
                }

                System.out.println("开始下载附件了");
                for (int i = 0; i < 100; i++) {
                    System.out.println("附件download:" + i + "%");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("附件下载完毕");
            }
        };

        Thread show = new Thread(){
            public void run(){
                System.out.println("开始显示图片");
                try {
                    //等待download线程执行完毕，并行线程就会变成串行
                  //  download.join();
                    synchronized (object) {
                        object.wait();  //等待
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(!isFinish){
                    throw new RuntimeException("没有找到图片");
                }
                System.out.println("图片显示完毕");
            }
        };
        download.start();
        show.start();


    }
}
