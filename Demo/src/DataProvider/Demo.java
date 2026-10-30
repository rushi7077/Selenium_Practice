package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Demo {
	
	WebDriver driver;
	
	@DataProvider	
	public Object[][] testData(){
		
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"},
			{"user4","pass4"}
		};
		
	}
	
	@BeforeClass
	public void open() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@Test(dataProvider="testData")
	public void login(String u,String p) throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys(u);
		driver.findElement(By.name("pass")).sendKeys(p);
		
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
}
