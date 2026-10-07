package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagramxpath {
	
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
		driver.findElement(By.xpath("(//input[starts-with(@class,'x1i10hfl')])[1]")).sendKeys("standard_user");
		driver.findElement(By.xpath("(//input[starts-with(@class,'x1i10hfl')])[2]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("(//div[contains(@class,'x1ja2u2z')])[42]")).click();
	}

	public static void main(String[] args) {
		Instagramxpath x  =new Instagramxpath();
		
		x.open();
		x.login();
		x.close();
		
		

	}

}
