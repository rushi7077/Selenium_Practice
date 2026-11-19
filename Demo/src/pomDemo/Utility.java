package pomDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class Utility {

	WebDriver driver;
	
	public void open_browser(String name) {
		if(name.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterTest
	public void close_browser() {
		pause(5000);
		driver.close();
	}
	
	public void open_url(String name) {
		driver.get(name);
	}
	
	public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void screenshot(String name) 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;	
		File f1=ts.getScreenshotAs(OutputType.FILE);
		File f2=new File(name+".png");
		try {
			FileHandler.copy(f1, f2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doClick(By obj) {
		driver.findElement(obj).click();
	}
	
	public void sendData(By obj,String text) {
		driver.findElement(obj).sendKeys(text);
	}
	
	public ArrayList<String> read_excel(String path, String sheetName,int cellnum){
		ArrayList<String>al=new ArrayList<String>();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis); 
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int row = sheet.getLastRowNum();
			
			for(int i=1;i<=row;i++) {
				XSSFRow r = sheet.getRow(i);
				al.add(r.getCell(cellnum).getStringCellValue()) ;
				
				}
			
		} catch (Exception e) {
			
		}
		return al;
	}
}

