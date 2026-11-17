
package pomDemo;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Demo1 extends Utility {

    Repository repo = new Repository();

    @BeforeTest
    public void open() {

        open("firefox");
        open_url("https://www.saucedemo.com/");

    }

    @Test(priority = 1)
    public void login1() {

        WebElement name = driver.findElement(repo.name);
        name.sendKeys("standard_user");

        WebElement password = driver.findElement(repo.password);
        password.sendKeys("secret_sauce");

        WebElement button = driver.findElement(repo.loginButton);
        button.click();

    }

    @Test(priority = 2)
    public void login2() {

        WebElement name = driver.findElement(repo.name);
        name.sendKeys("performance_glitch_user");

        WebElement password = driver.findElement(repo.password);
        password.sendKeys("secret_sauce");

        WebElement button = driver.findElement(repo.loginButton);
        button.click();

    }
    @AfterMethod
    public void logout() {
    	
    	pause(3000);

        if (driver.getCurrentUrl().contains("inventory")) {

            driver.findElement(repo.menu).click();

            driver.findElement(repo.logoutButton).click();

        }
    }


}
