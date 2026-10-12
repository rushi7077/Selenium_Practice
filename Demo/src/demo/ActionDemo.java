package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo extends Utility{
	
	public void action() {
		driver.get("https://www.facebook.com/");
		
		Actions ac = new Actions(driver);
		
		//ac.contextClick().build().perform();
		
		WebElement email = driver.findElement(By.name("email"));
		ac.contextClick(email).build().perform();
		
	}
	
	public static void main(String[] args) {
		
		ActionDemo a = new ActionDemo();
		
		a.open();
		a.action();
		a.close();
		
	}

}
