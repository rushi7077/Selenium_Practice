package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kitchen.applitools.com/ingredients/iframe");
		
		driver.switchTo().frame("the-kitchen-table");
		
		List<WebElement> li = driver.findElements(By.tagName("tr"));
		
		System.out.println(li);
		System.out.println("Number of rows :"+li.size());
		
		for(WebElement we:li) {
			System.out.println(we.getText());
		}
		

		
	}
	
	
}
