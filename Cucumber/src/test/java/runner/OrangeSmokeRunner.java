package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 tags = "@Test"
		,features = {"src/test/resources/featureFile/OrangeHRM.feature"}
		,glue = {"stepDefination"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
				   "json:target/cucumberjson/SmokeReport.json"}
		,monochrome = true
		,dryRun = false)

public class OrangeSmokeRunner {
	

}
