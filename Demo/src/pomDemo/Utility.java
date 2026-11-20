package pomDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utility {

	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest logger;
	String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS").format(new Date());
	
	@BeforeSuite
	public void initReport() {
		htmlReporter = new ExtentHtmlReporter("D:\\\\SeleniumExcel\\\\Extend_Reports\\\\latestReport\"+timeStamp+\".html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}
	@AfterSuite
	public void endReport() {
		report.flush();
	}
	
	
	public void start_report(String testname) {
		logger = report.createTest(testname);
	}
	
	public void markStatus(String status, String msg) {
	    if (status.equalsIgnoreCase("pass")) {
	        logger.log(Status.PASS, msg);
	    } else if (status.equalsIgnoreCase("fail")) {
	        logger.log(Status.FAIL, msg);
	    } else if (status.equalsIgnoreCase("info")) {
	        logger.log(Status.INFO, msg);
	    } else if (status.equalsIgnoreCase("fatal")) {
	        logger.log(Status.FATAL, msg);
	    }
	}
	
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
	
	public ArrayList<String> read_excel(String path, String sheetname , int cellnum){
		
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
			XSSFSheet sheet = wb.getSheet(sheetname);
			
			int rows = sheet.getLastRowNum();
			for(int i=1 ; i<rows ; i++) {
				XSSFRow row = sheet.getRow(i);
				al.add(row.getCell(cellnum).getStringCellValue());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
		
	}
}