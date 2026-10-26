
package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestActions {

    WebDriver driver;

    ArrayList<String> un = new ArrayList<>();
    ArrayList<String> pw = new ArrayList<>();


    @BeforeTest
    public void open() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @BeforeTest
    public void read_data() throws Exception {

        FileInputStream fi = new FileInputStream("D:\\SeleniumExcel\\LoginData.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        int rowcount = sheet.getLastRowNum();

        for (int i = 1; i <= rowcount; i++) {
            XSSFRow row = sheet.getRow(i);

            String s = row.getCell(0).getStringCellValue();
            String ss = row.getCell(1).getStringCellValue();

            un.add(s);
            pw.add(ss);
        }

        wb.close();
        fi.close();
    }

    @Test(priority = 1)
    public void login1() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(un.get(0));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pw.get(0));
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

    }

    @Test(priority = 2)
    public void login2() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(un.get(1));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pw.get(1));
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

    }

    @AfterMethod
    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
