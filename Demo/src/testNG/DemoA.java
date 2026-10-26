package testNG;

import org.testng.annotations.*;

public class DemoA {
	
	@Test
	public void test1() {
		System.out.println("1A");
	}
	
	@Test
	public void test2() {
		System.out.println("2A");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("this is before class A");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("this is after class A");
	}

}
