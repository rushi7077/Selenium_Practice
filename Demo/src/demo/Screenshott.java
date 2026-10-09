
package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshott {

    WebDriver driver;

    public void open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(50));
    }

    public void screenshot() throws IOException {
        driver.get("https://gate2027.iitm.ac.in/");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File from = ts.getScreenshotAs(OutputType.FILE);
        File to = new File("Gate.png");

        FileHandler.copy(from, to);

        System.out.println("Screenshot saved successfully!");
    }

    public void close() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        driver.quit();
    }


    public static void main(String[] args) throws IOException {
        Screenshott s = new Screenshott();

        s.open();
        s.screenshot();
        s.close();
    }
}
