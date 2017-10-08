package com.jeff.junit.demo01;

import org.junit.Test;
/**
 * 
 * @author 58
 * 
 * 
 * 测试Test注解的参数
 */
public class JunitDemo02 {

	/**
	 * 执行执行这个方法，超出这个时间，就会抛出异常
	 */
	@Test(timeout=1000)
	public void test01() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("JunitDemo02.test01()");
	}
	
	/**
	 * 执行下面的方法，期待抛出这个异常，一旦没有抛出这个异常的话，就会报错
	 */
	@Test(expected=NullPointerException.class)
	public void test02() {
		
		Object o = null;
		o.toString();
		
		System.out.println("JunitDemo02.test02()");
	}
}
