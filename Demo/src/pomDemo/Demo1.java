package pomDemo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 extends Utility
{	
	Repository rep=new Repository();
	String un,pw;
	ArrayList<String>unal,pwal;
	
	//@Test(priority = 1)
	public void login() {
		
		sendData(rep.emailobj, "standard_user");
		sendData(rep.passobj, "secret_sauce");
		doClick(rep.btnobj);
	}
	@BeforeMethod
	public void readData() {
		unal=read_excel("D:\\\\SeleniumExcel\\\\Book1.xlsx","Sheet1",0);		
		pwal=read_excel("D:\\\\SeleniumExcel\\\\Book1.xlsx","Sheet1",1);		
	}
	@Test(priority = 2)
	public void login1() {
		
		for(int i=0;i<unal.size();i++) {
			sendData(rep.btnobj,unal.get(i));
			sendData(rep.passobj,pwal.get(i));
			doClick(rep.btnobj);
			pause(2000);
			doClick(rep.mnubtn);
			doClick(rep.logoutbtn);
			
		}
		
	}
	//@AfterMethod
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
}
