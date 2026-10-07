package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo2 {
	
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
		driver.get("https://parabank.parasoft.com/parabank/about.htm");
		driver.findElement(By.xpath("//input[starts-with(@name,'username')]")).sendKeys("Rushikesh");
		driver.findElement(By.xpath("//input[starts-with(@name,'password')]")).sendKeys("49684dsa");
		driver.findElement(By.xpath("(//input[starts-with(@class,button)])[3]")).click();
	}
	
	public static void main(String[] args){
		
		Xpathdemo2 x = new Xpathdemo2();
		x.open();
		x.login();
		x.close();
	
}
}
