package com.ztx.thread;

import org.junit.Test;

/*
* 第一种线程的方法继承thread类覆写run方法
*  junit测试不支持多线程，具体百度
*
* */
public class ThreadDemo {

    public static void main(String args[]){

       // MyThread1 myThread1 = new MyThread1();
        //MyThread2 myThread2 = new MyThread2();

        Runnable myRunable1 = new myRunable1();
        MyThread1 myThread1 = new MyThread1();
        myRunable1.run();
        myThread1.start();
       // myThread2.start();
    }


}
/*
 * 第一种线程的方法继承thread类覆写run方法
 *  junit测试不支持多线程，具体百度
 *
 * */
    class MyThread1 extends Thread{
        public void run(){
            for(int i =0;i<1000;i++){
                System.out.println("你是谁");
            }

        }


    }
    class MyThread2 extends Thread{
        public void run(){
            for(int i =0;i<1000;i++){
                System.out.println("我是查水表的");
            }
        }


    }
/*
 * 第二种线程的方法
 * 定义线程体Runable
 *  junit测试不支持多线程，具体百度
 *
 * */

class myRunable1 implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<1000;i++){
            System.out.println("你是谁");
        }


    }
}
class myRunable2 implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<1000;i++){
            System.out.println("我是查水表的");
        }


    }
}