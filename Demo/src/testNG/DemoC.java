package testNG;

import org.testng.annotations.*;

public class DemoC{
	
	@Test
	public void test1() {
		System.out.println("1C");
	}
	
	@Test
	public void test2() {
		System.out.println("2C");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test C");
	}
	
	@AfterTest
	public void afterTestest() {
		System.out.println("This is after test C");
	}

}
