package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo5 {
	
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
		driver.get("https://demo.applitools.com/");
		driver.findElement(By.xpath("(//input[starts-with(@class,'form')])[1]")).sendKeys("Rushikesh");
		driver.findElement(By.xpath("(//input[starts-with(@class,'form')])[2]")).sendKeys("49684dsa");
		driver.findElement(By.xpath("//a[starts-with(@class,'btn')]")).click();
	}
	
	public static void main(String[] args){
		
		Xpathdemo5 x = new Xpathdemo5();
		x.open();
		x.login();
		x.close();
	
}
}
