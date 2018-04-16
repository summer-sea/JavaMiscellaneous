package com.ztx.thread;

/**
 * Created by Think on 2016/11/11.
 */
public class threadA extends Thread {

	public void run(){
		try {
			for(int i =0;i<10;i++) {
				System.out.println("线程A开始第" + i + "次执行");
				System.out.println("线程A睡3秒");
				sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
