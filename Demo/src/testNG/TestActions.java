package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestActions {

    WebDriver driver;

    String username;
    String password;
    int rowNum = 1;

    @BeforeTest
    public void open() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @BeforeMethod
    public void readExcelData() throws IOException {

        FileInputStream fis = new FileInputStream("D:\\SeleniumExcel/LoginData.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(rowNum);

        username = row.getCell(0).getStringCellValue();
        password = row.getCell(1).getStringCellValue();

        rowNum++;

        workbook.close();
        fis.close();
    }

    @Test(priority = 1)
    public void login1() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

    }

    @Test(priority = 2)
    public void login2() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
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