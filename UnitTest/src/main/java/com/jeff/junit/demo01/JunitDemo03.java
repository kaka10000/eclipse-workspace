package com.jeff.junit.demo01;

import org.junit.Ignore;
import org.junit.Test;
/**
 * 
 * @author 58
 * 
 * 
 * 测试其它注解
 */
public class JunitDemo03 {

	/**
	 * @Ignore 在方法上加上这个注解，这个方法就会忽略，不会执行。
	 */
	@Ignore
	@Test
	public void test01() {
		System.out.println("JunitDemo03.test01()");
	}
}
