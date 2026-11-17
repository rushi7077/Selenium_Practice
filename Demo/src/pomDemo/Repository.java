package pomDemo;

import org.openqa.selenium.By;

public class Repository {
	
	By name = By.xpath("//*[@id=\"user-name\"]");
	By password = By.xpath("//*[@id=\"password\"]");
	By loginButton = By.xpath("//*[@id=\"login-button\"]");
	
	By menu = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
	By logoutButton =By.xpath("//*[@id=\"logout_sidebar_link\"]");

}
