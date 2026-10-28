package ParawithFacebook;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Facebook {
	
	WebDriver driver;
	
	@BeforeMethod
	public void open() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	@Parameters({"name","pass"})
	public void login(String userName,String password) {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("pass")).sendKeys(password);
		
	}

}
