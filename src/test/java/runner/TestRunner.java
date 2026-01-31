package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/rerun.txt",
        },
        tags = "@a1",
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}