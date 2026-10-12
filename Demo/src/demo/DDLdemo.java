package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DDLdemo  extends Utility{
	
	public void ddl() {
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'name')]")).sendKeys("Rushikesh Baravkar");
		pause(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Rediffmail')]")).sendKeys("rushibaravkar1012");
		pause(2000);
		driver.findElement(By.xpath("//input[@value='Check availability']")).click();
		
		WebElement w = driver.findElement(By.xpath("//select[contains(@name,'Day')]"));
		Select s = new Select(w);
		s.selectByVisibleText("05");
		pause(2000);
		
		WebElement w1 = driver.findElement(By.xpath("//select[contains(@name,'Month')]"));
		Select s1 = new Select(w1);
		s1.selectByVisibleText("NOV");
		pause(2000);
		
		WebElement w2 = driver.findElement(By.xpath("//select[contains(@name,'Year')]"));
		Select s2 = new Select(w2);
		s2.selectByVisibleText("2003");
		pause(2000);
		

	}
	
	public static void main(String[] args) {
		DDLdemo d = new DDLdemo();
		d.open();
		d.ddl();
		d.close();
		
	}

}
