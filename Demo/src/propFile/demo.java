package propFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class demo {
	
	String b,n,p;
	WebDriver driver;
	
	@BeforeClass
	public void readData() throws Exception {
		
		File f = new File("src\\propFile\\data.properties");
		FileInputStream fi = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fi);
		
		b = prop.getProperty("browser");
		n = prop.getProperty("username");
		p = prop.getProperty("password");
		
		System.out.println(b);
		System.out.println(n);
		System.out.println(p);		
		
	}
	
	@BeforeMethod
	public void open() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void login() {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys(n);
		driver.findElement(By.name("pass")).sendKeys(p);
		
	}
	
	

}
