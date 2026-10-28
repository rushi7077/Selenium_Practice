package xmlDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class multipleLogin {
	
	WebDriver driver;
	ArrayList<String> u = new ArrayList<>();
	ArrayList<String> p = new ArrayList<>();
	
	String ER = "https://www.saucedemo.com/inventory.html";
	SoftAssert s= new SoftAssert();
	
	@BeforeClass
	public void ReadData() throws IOException {
		
		FileInputStream f = new FileInputStream("D:\\SeleniumExcel\\LoginData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(f);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        int rowcount = sheet.getLastRowNum();

        for (int i = 1; i <rowcount; i++) {
            XSSFRow row = sheet.getRow(i);

            String s = row.getCell(0).getStringCellValue();
            String ss = row.getCell(1).getStringCellValue();

            u.add(s);
            p.add(ss);
        }
	}
	
	@BeforeMethod
	public void open() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
				
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		
		for(int i=0;i<u.size();i++) {
			
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");		
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
			
			String AR = driver.getCurrentUrl();
			Thread.sleep(3000);
			//Assert.assertEquals(AR, ER);
			
			if(AR.contains("inventory")) {
				
				s.assertTrue(true,"User get login - "+u.get(i));
				
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.id("logout_sidebar_link")).click();
				
			}
			else {
				s.assertTrue(false,"User not get login - "+u.get(i));
				driver.navigate().refresh();
			}
			
		}
		s.assertAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
