package SwagLab_TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Rankanp\\IdeaProjects\\Cucumber\\Swag Labs features\\DemoTest.feature" , glue = "SwagLabs_StepDefinitions"

        , dryRun = false , monochrome = true , plugin = {"pretty" ,"html:test-output"})
public class TestRunner {
}
