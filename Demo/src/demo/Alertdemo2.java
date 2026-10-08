package demo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertdemo2 {
	
	WebDriver driver;
	
	public void open() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	public void close() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
	}
	
	public void demoo() {
		driver.get("https://kitchen.applitools.com/ingredients/alert");
		
		driver.findElement(By.id("alert-button")).click();		
		Alert a = driver.switchTo().alert();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.accept();
		
		driver.findElement(By.id("confirm-button")).click();		
		Alert a1 = driver.switchTo().alert();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a1.dismiss();
		
		driver.findElement(By.id("prompt-button")).click();		
		Alert a2 = driver.switchTo().alert();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a2.sendKeys("Rushikesh");
		a2.accept();
		
		
		
		
	}
	public static void main(String[] args) {
		
		Alertdemo2 al = new Alertdemo2();
		al.open();
		al.demoo();
		al.close();
		
	}	

}
