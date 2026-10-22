package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Demo1 {
	
	WebDriver driver;
	
	@Test(priority = 1)
	public void test1() {
		
		System.out.println("This is test 1");
		
	}
	
	@Test(priority = 2)
	public void open() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 3)
	public void login() {		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
	}
	
	@Test(priority=4,timeOut=4000,dependsOnMethods = "login")
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
	}
	
	@Test(priority = 5)
	public void close() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.close();
	}

}
