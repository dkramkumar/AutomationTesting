package pages;

import org.openqa.selenium.By;

public class OrangeLoginPage extends BasePage {

	public final static By byUserName = findBy("//input[@id='txtUsername']");
	public final static By byPassword = findBy("//input[@id='txtPassword']");
	public final static By byLoginButton = findBy("//input[@id='btnLogin']");
	public final static By byWelcomeName = findBy("//a[@id='welcome']");

	public static void setUserName() {
		setText(byUserName, "UserName", "Admin");
	}

	public static void setPassword() {
		setText(byPassword, "Password", "admin123");
	}
	
	public static void clickLoginButton() {
		clickElement(byLoginButton, "Login Button");
	}
	
	public static void getWelcomeName() {
		getText(byWelcomeName, "Orange Home page");
	}
}
