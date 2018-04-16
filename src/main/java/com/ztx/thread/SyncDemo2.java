package com.ztx.thread;
/*
*假设只有一个试衣间
*
*  public synchronized static void buy(String name){
* 给整个 buy方法加上同步关键字 就会顺序执行 就会变成vip式待遇 执行效率会变低
* 理想应该 只在试衣服的时候 加锁
*
*
* 要给试衣服加上synchronized（）{} 注意方法要求传入一个对象通常写this
* 如果synchronized 块在非静态方法中通常锁对象写this
* */
public class SyncDemo2 {
    private static Object object = new Object();
    public static void main(String args[]){
        Thread t1 = new Thread(){
            public void run(){
                buy(getName());
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                buy(getName());
            }
        };
        t1.start();
        t2.start();

    }
    public  static void buy(String name){
        System.out.println(name+"正在挑衣服");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name+"挑完了");
        synchronized(object) {  //里面传入的对象必须为同一个才具有同步效力 通常写this
            System.out.println(name + "准备试衣服");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "试完衣服了");
        }
        System.out.println(name+"结账走了");

    }
}
