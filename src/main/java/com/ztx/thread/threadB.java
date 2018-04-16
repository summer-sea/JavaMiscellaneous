package com.ztx.thread;

import org.apache.log4j.Logger;

/**
 * Created by Think on 2016/11/11.
 */
public class threadB extends Thread{
	public static final Logger log = Logger.getLogger(threadB.class);
	public void run(){
		try {
			for (int i=0;i<10;i++){
				System.out.println("线程B开始第"+i+"次执行");
				System.out.println("线程B睡2秒");
				sleep(2000);
			}
			}catch(Exception e){
			e.printStackTrace();
		}
	}
}
