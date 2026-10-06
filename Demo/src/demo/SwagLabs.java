package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs {
	
	WebDriver driver;
	
	public void open() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	public void close() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	public void login() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("Rushikesh");
		driver.findElement(By.id("password")).sendKeys("iyrfugug");
		driver.findElement(By.id("login-button")).click();
	}
	

	public static void main(String[] args) {
		SwagLabs obj = new SwagLabs();
		
		obj.open();
		obj.login();
		obj.close();
		
	}

}
