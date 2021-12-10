package stepDefination;

import java.io.IOException;
import io.cucumber.java.Before;
import pages.BasePage;
import io.cucumber.java.After;
public class Helper extends BasePage {

	String path = System.getProperty("user.dir");

	@Before
	public void InitialSetUp() throws IOException, InterruptedException {
		System.out.println("************* STARTING NEW TEST **************");
		System.out.println("INFO: Initial setup for new Test");
		System.out.println("INFO: Initial setup Done");	
	}

	@After
	public void closeSetup() throws IOException {
		System.out.println("INFO: Inside CloseSetup");
		driver.quit();
		System.out.println("INFO: CloseSetup Done");
		System.out.println("*************END TEST ************");
		
	}

}