package com.jeff.junit.demo01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author 58
 * JUnit中的这几个注解的测试
 */
public class JunitDemo01 {

	/**
	 * 加上这个注解正常而言这个方法只会执行一次，但是经过测试，这个注解与@Before
	 * 是一样的效果，也就是说，没执行一个@Test方法就会执行这个方法。注意这个方法是静态的。
	 */
	@BeforeClass
	public static void beforeClass() {}{
		System.out.println("JunitDemo01.beforeClass()");
	}
	
	/**
	 * 每执行一个测试方法，就会执行一个@Before
	 */
	@Before
	public void before() {}{
		System.out.println("JunitDemo01.before()");
	}
	
	@Test
	public void test01() {
		System.out.println("JunitDemo01.test01()");
	}
	
	@Test
	public void test02() {
		System.out.println("JunitDemo01.test02()");
	}
	
	@Test
	public void test03() {
		System.out.println("JunitDemo01.test03()");
	}
	/**
	 * 每执行完一个测试方法，就会执行一个@After的方法，可以在里面释放资源
	 */
	@After
	public void after() {
		System.out.println("JunitDemo01.after()");
	}
	/**
	 * 这个只会执行一次，这个在所有方法执行完，会调用一次。这个是好使的，也是静态方法。
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("JunitDemo01.afterClass()");
	}
}
