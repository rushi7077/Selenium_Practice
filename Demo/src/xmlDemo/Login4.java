package xmlDemo;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Login4 extends Login3{
	
	@BeforeClass
	public void openPage() {
		driver.get("https://www.saucedemo.com/");				
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("error_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
	}

}
