package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"./src/test/resources/AllFeatures/PassResourcesDynamically4.feature"},
		glue = {"org/mir/stepDefination"},
		//tags = "@DeletePlace or @AddPlaceAPIGet",
				plugin = {
				        "pretty",
						"json:target/jsonReports/cucumber-report.json"
				},
		publish = true
		
		)
public class TestRunner {

}
