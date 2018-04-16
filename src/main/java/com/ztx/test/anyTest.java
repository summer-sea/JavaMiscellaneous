package com.ztx.test;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Think on 2016/10/26.
 */
public class anyTest {
	public static  final Logger log = Logger.getLogger(anyTest.class);
	@Test
	public void math(){
		try {
			log.info("开始");
			long dd = 0;
			long ds =0;
			dd = Math.round(11.5);
			ds= Math.round(-11.5);
			System.out.println("dd:"+dd);
			System.out.println("ds:"+ds);
			log.info("结束");

		} catch (Exception e) {
			e.printStackTrace();
		}



	}
	//@Test
	public void test(){
		int i;
		for(i=0;i<=10;i++){
			++i;
		}
		System.out.println("i的值为："+i);
		/*值为12*/
	}
	//@Test
	public void testOen(){
		String str="test";
		str.toUpperCase();
		String STR= str.toUpperCase();
		System.out.println("STR："+STR);
		str.replace("t", "a");
		System.out.println("str:"+str);
		String strr =str.replace("t", "a");
		System.out.println(strr);

	}
	@Test
	public void testTwo(){
		Integer i=1;
		boolean result = i==null;
		System.out.println("result:"+result);
		if(result)
		{
			System.out.println("ifresult"+result);
		}

	}



}
