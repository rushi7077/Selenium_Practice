package pomDemo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 extends Utility
{	
	Repository rep=new Repository();
	ArrayList<String>unal, pwal;
	
//	@Test(priority = 1)
	public void login() {
		
		sendData(rep.emailobj, "standard_user");
		sendData(rep.passobj, "secret_sauce");
		doClick(rep.btnobj);
	}
	@Test(priority = 1)
	public void login1() {

	    start_report("Login Verification");

	    for (int i = 0; i < unal.size(); i++) {

	        String username = unal.get(i);
	        String password = pwal.get(i);

	        try {

	            // Enter username and password
	            sendData(rep.emailobj, username);
	            sendData(rep.passobj, password);

	            markStatus("info", "Credentials entered for: " + username);

	            // Click login button
	            doClick(rep.btnobj);

	            // Verify login
	            if (driver.getCurrentUrl().contains("inventory")) {

	                markStatus("pass", "Login successful: " + username);

	                // Logout
	                doClick(rep.mnubtn);
	                doClick(rep.logoutbtn);

	                markStatus("pass", "Logout successful: " + username);

	            } else {

	                markStatus("fail", "Login unsuccessful: " + username);

	                driver.navigate().refresh();
	            }

	        } catch (Exception e) {

	            markStatus("fail", "Error for user: " + username
	                    + " | " + e.getMessage());

	            driver.navigate().refresh();
	        }
	    }
	}
//	@AfterMethod
	public void logout() throws InterruptedException {
		//pause(3000);
		doClick(rep.mnubtn);
		doClick(rep.logoutbtn);
	}
	
	@BeforeTest
	public void open() {
		open_browser("firefox");
		open_url("https://www.saucedemo.com/");
	}	
	@BeforeClass
	public void readData() {
		unal =  read_excel("D:\\SeleniumExcel\\oginData.xlsx\\","sheet1",0);
		pwal =  read_excel("D:\\SeleniumExcel\\oginData.xlsx\\","sheet1",1);
		System.out.println(unal);
		System.out.println(pwal);

	}	
}