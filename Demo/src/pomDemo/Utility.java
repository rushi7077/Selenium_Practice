package pomDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	WebDriver driver;
	
	public void open(String name) {		
		if(name.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		pause(3000);
		driver.close();
	}
	
	public void open_url(String name) {
		driver.get(name);
	}
	
	 public void screenShot(String name) throws IOException {

	        TakesScreenshot ts = (TakesScreenshot) driver;

	        File from = ts.getScreenshotAs(OutputType.FILE);
	        File to = new File(name+".png");

	        FileHandler.copy(from, to);

	        System.out.println("Screenshot saved successfully!");
	    }
}
