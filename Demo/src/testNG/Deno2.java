package testNG;

import org.testng.annotations.*;

public class Deno2 {
	
	@BeforeTest
	public void beforeTest() {		
		System.out.println("This is the before test condition.");		
	}
	@AfterTest
	public void afterTest() {		
		System.out.println("This is the after test condition.");		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is the before method condition.");				
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is the after method condition.");				
	}
	
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}

}
