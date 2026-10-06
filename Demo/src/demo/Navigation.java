package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

    WebDriver driver;

    public void open() {
        driver = new ChromeDriver();
    }

    public void demo() {

        driver.get("https://www.facebook.com/");

        driver.navigate().to("https://www.google.com/");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
    }

    public void close() {
        driver.close();
    }

    public static void main(String[] args) {

        Navigation n = new Navigation();

        n.open();
        n.demo();
        n.close();

    }
}