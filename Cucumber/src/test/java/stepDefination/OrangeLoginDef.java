package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.OrangeLoginPage;

public class OrangeLoginDef extends BasePage{
	
	@Given("User is on Orange HRM Login page")
	public void user_is_on_orange_hrm_login_page() throws InterruptedException {
		initialConfig();
		openUrl();
	}

	@When("User enters UserName and Password")
	public void user_enters_user_name_and_password() throws InterruptedException {
		OrangeLoginPage.setUserName();
		Thread.sleep(2000);
		OrangeLoginPage.setPassword();
		Thread.sleep(2000);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		OrangeLoginPage.clickLoginButton();
	}

	@Then("User navigates to home page")
	public void user_navigates_to_home_page() {
		OrangeLoginPage.getWelcomeName();
	}

}
