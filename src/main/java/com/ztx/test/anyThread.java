package com.ztx.test;


import com.ztx.thread.threadA;
import com.ztx.thread.threadB;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Think on 2016/11/11.
 */
public class anyThread {
	private  static final Logger log = Logger.getLogger(anyThread.class);

	@Test
	public void testThread(){

		try {
			threadA threada = new threadA();
			threadB threadb  = new threadB();
			log.info("线程开始");
			/*
			*run 和start的区别
			* run只是个方法，调用相当于调用函数方法，程序顺序执行，并没有开启线程，
			*
			* start开启线程，先运行主线程在运行子线程
			* */
			threada.start();
			threadb.start();
			//threada.run();
			//threadb.run();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
