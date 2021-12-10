package stepDefination;

import java.io.IOException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;

public class AdminDef {
	
	@When("User clicks on {string} tab")
	public void user_clicks_on_tab(String string) throws InterruptedException {
		AdminPage.clickAdminTab(string);
		Thread.sleep(1000);
	}

	@Then("Total number of users should display")
	public void total_number_of_users_should_display() {
		AdminPage.getTotalUsers();
	}
	
	@When("User enters the Username to search")
	public void user_enters_the_username_to_search() {
		AdminPage.setSearchUserName();
	}
	
	@When("User selects the user role")
	public void user_selects_the_user_role() throws InterruptedException {
		AdminPage.selectUserRole();
	}
	
	@When("User selects the status as {string}")
	public void user_selects_the_status_as(String string) throws InterruptedException {
		AdminPage.selectStatus();
	}
	
	@Then("User clicks on Search button")
	public void user_clicks_on_search_button() {
		AdminPage.clickSearchButton();
	}
	
	@When("User clicks on add button")
	public void user_clicks_on_add_button() {
		AdminPage.clickOnAddButton();
	}

	@When("User enters the employee name, UserName, Password and ConfirmPassword")
	public void user_enters_the_employee_name_user_name_password_and_confirm_password() throws IOException, InterruptedException {
		AdminPage.setUserDetails();
	}

	@Then("User clicks on save button")
	public void user_clicks_on_save_button() {
	   
	}

}
