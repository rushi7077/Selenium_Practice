package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionWithDblClick extends Utility{
	
	public void action() {
		
		driver.get("https://artoftesting.com/samplesiteforselenium");
		Actions ac = new Actions(driver);
		
		//WebElement dblClick = driver.findElement(By.id("doubleBtn"));
		WebElement drag = driver.findElement(By.id("myImage"));
		WebElement drop = driver.findElement(By.id("targetDiv"));
		
		//ac.doubleClick(dblClick).build().perform();
		
		pause(5000);
		
		ac.dragAndDrop(drag, drop).build().perform();
		
		
		
		
	}

	public static void main(String[] args) {
		
		ActionWithDblClick a = new ActionWithDblClick();
		a.open();
		a.action();
		a.close();
		
	}

}
