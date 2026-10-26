package testNG;

import org.testng.annotations.*;

public class DemoB {
	
	@Test
	public void test1() {
		System.out.println("1B");
	}
	
	@Test
	public void test2() {
		System.out.println("2B");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test");
	}
	
	@AfterTest
	public void afterTestest() {
		System.out.println("This is after test");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("This is before suite");
	}
	
	

}
