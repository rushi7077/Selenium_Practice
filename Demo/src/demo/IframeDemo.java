package demo;

import org.openqa.selenium.By;

public class IframeDemo extends Utility{
	
	public void demo ()throws Exception {
		driver.get("https://kitchen.applitools.com/ingredients/iframe");
		
		driver.switchTo().frame("the-kitchen-table");
		
		
		
		String s = driver.findElement(By.linkText("The Kitchen")).getText();
		
		System.out.println(s);
		
		driver.findElement(By.linkText("The Kitchen")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		IframeDemo i = new IframeDemo();
		
		i.open();
		i.demo();
		i.close();
		
	}

}
