
package extendReport;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Demo {

    WebDriver driver;

    ArrayList<String> u = new ArrayList<>();
    ArrayList<String> p = new ArrayList<>();

    String ER = "https://www.saucedemo.com/inventory.html";

    SoftAssert s = new SoftAssert();

    @BeforeClass
    public void ReadData() throws IOException {
        FileInputStream f = new FileInputStream("D:\\SeleniumExcel\\LoginData.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(f);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        int rowcount = sheet.getLastRowNum();

        for (int i = 1; i < rowcount; i++) {
            XSSFRow row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            u.add(username);
            p.add(password);
        }

        wb.close();
        f.close();
    }

    @BeforeMethod
    public void open() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void loginTest() {

        for (int i = 0; i < u.size(); i++) {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(u.get(i));
            driver.findElement(By.id("password")).sendKeys(p.get(i));
            driver.findElement(By.id("login-button")).click();
            String AR = driver.getCurrentUrl();

            if (AR.equals(ER)) {
                System.out.println("Login Successful: " + u.get(i));
                s.assertEquals(AR, ER, "Login successful for " + u.get(i));
                driver.findElement(By.id("react-burger-menu-btn")).click();
                driver.findElement(By.id("logout_sidebar_link")).click();
                System.out.println("Logout Successful: " + u.get(i));

            }
            else {

                System.out.println("Login Failed: " + u.get(i));
                if (u.get(i).equals("locked_out_user")) {
                    s.assertTrue(true, "Locked user correctly blocked");
                }
                else {
                    s.assertEquals(AR, ER, "Login failed for " + u.get(i));
                }
            }
        }

        s.assertAll();

    }
}
