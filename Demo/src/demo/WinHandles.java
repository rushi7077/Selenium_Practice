package demo;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WinHandles {
	public static void main(String[] args) throws Exception{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getWindowHandle());
		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_8m0512m97v_e&adgrpid=1317216540160148&hvadid=82326373665925&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=148911&hvtargid=kwd-82326918609608:loc-90&hydadcr=5623_2518755&mcid=f13fcffd1964377ea436bb8da9e6f147&msclkid=e83c768d6d69118b46f91c5cf1618609");
		
		
		System.out.println(driver.getTitle());
		
		Set<String> set = driver.getWindowHandles();
		System.out.println(set);
		
		ArrayList<String> ar = new ArrayList<>(set);
		
		Thread.sleep(2000);
		driver.switchTo().window(ar.get(0));
		
	}
}
