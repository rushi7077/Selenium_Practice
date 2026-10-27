package xmlDemo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Assert1 {
	
	WebDriver driver;
	
	String ER = "https://www.saucedemo.com/inventory.html";
	
	@BeforeTest
	public void open() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		String AR = driver.getCurrentUrl();
		
		//Assert.assertEquals(ER, AR);
		
		assertTrue(AR.contains("inventory"),"User not login");
		
		driver.close();
		
	}

}
