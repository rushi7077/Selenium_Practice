package xmlDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Login3 {
	
	static WebDriver driver;
	
	@BeforeTest
	public void open() {		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	@BeforeClass
	public void openPage() {
		driver.get("https://www.saucedemo.com/");				
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("problem_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
	}

}
