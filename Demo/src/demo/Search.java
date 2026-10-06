package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
	
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
	
	public void search() {
		driver.get("https://www.google.com/?zx=1791257929061");
		driver.findElement(By.name("q")).sendKeys("Prime minister of India");
		driver.findElement(By.name("btnK")).click();
	}

	public static void main(String[] args) {
		
		Search s = new Search();
		s.open();
		s.search();
		s.close();
		

	}

}
