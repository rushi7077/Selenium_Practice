package demo;

import org.openqa.selenium.By;

public class IframeDemo extends Utility{
	
	public void demo() {
		driver.get("https://kitchen.applitools.com/ingredients/iframe");
		
		driver.findElement(By.linkText("The Kitchen")).click();
	}
	
	public static void main(String[] args) {
		
		IframeDemo i = new IframeDemo();
		
		i.open();
		i.demo();
		i.close();
		
	}

}
