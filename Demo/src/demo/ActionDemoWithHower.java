package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionDemoWithHower extends Utility {

	public void action() {
		
		driver.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_1tmvcmz30t_e&adgrpid=1329311168025487&hvadid=83082288539142&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=149333&hvtargid=kwd-83082829756950:loc-90&hydadcr=5650_2518711&mcid=6233a7c588f136ff9af0c63d9f6745bc&msclkid=ceb84fa0e33f162b509b256cb86f02a5");
		Actions ac = new Actions(driver);
		
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/a"));
		WebElement subElement = driver.findElement(By.xpath("//*[@id=\"nav_prefetch_yourorders\"]/span"));
		
		ac.moveToElement(element).click(subElement).build().perform();
		
		pause(5000);
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		
		ActionDemoWithHower a = new ActionDemoWithHower();
		a.open();
		a.action();
		a.close();
		
	}

}
