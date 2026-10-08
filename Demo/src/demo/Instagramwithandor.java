package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagramwithandor {
	
	WebDriver driver ;
	
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
		driver.get("https://www.instagram.com/?hl=en-in");
		driver.findElement(By.xpath("//input[@id='_r_2_' or @name='email']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='_r_5_' or @name='pass']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("(//div[contains(@class,'x1ja2u2z')])[42]")).click();
	}

	public static void main(String[] args) {
		Instagramwithandor x  =new Instagramwithandor();
		
		x.open();
		x.login();
		x.close();
		
		

	}

}
