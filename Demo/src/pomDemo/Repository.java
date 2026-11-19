package pomDemo;

import org.openqa.selenium.By;

public class Repository {

	By emailobj=By.xpath("//input[@name='user-name']");
	By passobj=By.xpath("//input[@name='password']");
	By btnobj=By.xpath("//input[@name='login-button']");
	By mnubtn=By.id("react-burger-menu-btn");
	By logoutbtn=By.id("logout_sidebar_link");
	
	
	By fbun=By.name("email");
	By fbpw=By.name("pass");
	By fbbtn=By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div[2]/form/div/div[1]/div/div[3]/div/div/div");
	
}
