package testNG;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestActions {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void open() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 1)
	public void login1() throws InterruptedException {		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
				
	}
	@Test(priority = 2)
	public void login2() throws InterruptedException {		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("problem_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
				
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.close();
	}

}
