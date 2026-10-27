package xmlDemo;

import org.testng.Assert;
import org.testng.annotations.*;

public class AssertJava {
	
	@Test
	public void test1() {
		Assert.assertEquals("Hello", "hello");
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("Java", "Java");
	}

}
