package demo;

import org.openqa.selenium.By;

public class IframeDemo extends Utility{
	
	public void demo() {
		driver.get("https://kitchen.applitools.com/ingredients/iframe");
		
		String s = driver.findElement(By.linkText("The Kitchen")).getText();
		
		System.out.println(s);
		
		driver.findElement(By.linkText("The Kitchen")).click();
	}
	
	public static void main(String[] args) {
		
		IframeDemo i = new IframeDemo();
		
		i.open();
		i.demo();
		i.close();
		
	}

}
