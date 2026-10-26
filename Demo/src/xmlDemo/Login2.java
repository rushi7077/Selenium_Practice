package xmlDemo;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Login2 extends Login1{
	
	@BeforeClass
	public void openPage() {
		driver.get("https://www.saucedemo.com/");				
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("locked_out_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
	}

}
