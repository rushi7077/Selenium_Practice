package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo1 {
	
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
			e.printStackTrace();
		}
		driver.close();
	}
	
	public void login() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[starts-with(@name,'username')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[starts-with(@name,'password')]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[starts-with(@class,'oxd-button')]")).click();
	}
	
	public static void main(String[] args){
		
		Xpathdemo1 x = new Xpathdemo1();
		x.open();
		x.login();
		x.close();
	
}
}
