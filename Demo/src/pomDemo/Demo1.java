package pomDemo;


import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.*;

public class Demo1 extends Utility {
	
	@BeforeTest
	public void open() {
		
		open("firefox");
		open_url("https://www.saucedemo.com/");
	}
	
	@Test
	public void login1(){		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		try {
			screenShot("swag");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void login2(){		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
	}
	
	@AfterMethod
	public void logout(){
		pause(3000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
	}
	
	@AfterClass
	public void close() {
		pause(3000);
		close();
	}
	


}
