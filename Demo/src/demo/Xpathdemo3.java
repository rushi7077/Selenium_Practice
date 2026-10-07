package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo3 {
	
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
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.findElement(By.xpath("(//input[starts-with(@value,'admin')])[1]")).sendKeys("Rushikesh");
		driver.findElement(By.xpath("(//input[starts-with(@value,'admin')])[2]")).sendKeys("49684dsa");
		driver.findElement(By.xpath("//button[starts-with(@class,'button')]")).click();
	}
	
	public static void main(String[] args){
		
		Xpathdemo3 x = new Xpathdemo3();
		x.open();
		x.login();
		x.close();
	
}
}
