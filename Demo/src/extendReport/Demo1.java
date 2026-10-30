package extendReport;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Demo1 {
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest logger;
	String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
	
	@BeforeTest
	public void open() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@BeforeSuite
	public void initReport() {
		htmlReporter = new ExtentHtmlReporter("D:\\SeleniumExcel\\Extend_Reports\\latestReport"+timeStamp+".html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void endReport() {
		reports.flush();
	}
	
	@Test
	public void test() {
		logger=reports.createTest("Login Test");
		logger.log(Status.INFO, "Browser is opened");
		driver.get("https://www.saucedemo.com/");
		logger.log(Status.INFO, "Swag lab is opened");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		logger.log(Status.INFO, "Username is entered");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
		logger.log(Status.INFO, "password is entered");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		logger.log(Status.INFO, "Login button is clicked");
		
		if(driver.getCurrentUrl().contains("inventory"))
		{
			logger.log(Status.PASS, "User is logged in");
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.id("logout_sidebar_link")).click();
		}
		else {
			logger.log(Status.FAIL, "User not found");
			driver.navigate().refresh();
		}
	}
}
