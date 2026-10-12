package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionWithDblClick extends Utility{
	
	public void action() {
		
		driver.get("https://vinothqaacademy.com/mouse-event/");
		Actions ac = new Actions(driver);
		
		WebElement dblClick = driver.findElement(By.id("doubleBtn"));
		WebElement drag = driver.findElement(By.id("dragItem"));
		WebElement drop = driver.findElement(By.id("dropZone"));
		
		ac.doubleClick(dblClick).build().perform();
		
		
	}

	public static void main(String[] args) {
		
		ActionWithDblClick a = new ActionWithDblClick();
		a.open();
		a.action();
		a.close();
		
	}

}
