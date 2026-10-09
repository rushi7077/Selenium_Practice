package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	WebDriver driver;
	
	 public void open() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts()
	              .implicitlyWait(Duration.ofSeconds(50));
	    }

	    public void screenshot(String name) {
	        

	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File from = ts.getScreenshotAs(OutputType.FILE);
	        File to = new File(name+".png");
	        try {
				FileHandler.copy(from, to);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    public void close() {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }

	        driver.quit();
	    }
	    
	    public void pause(int time) {
	    	try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
