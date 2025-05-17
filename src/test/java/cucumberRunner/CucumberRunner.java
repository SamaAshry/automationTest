package cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/featureFile"}
        , glue = {"stepDefinition"}
        , tags = "@test"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}