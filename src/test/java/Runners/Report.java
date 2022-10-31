package Runners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

public class Report extends AbstractTestNGCucumberTests {


    @CucumberOptions(
            tags = " ",
            features = {"src/test/java/FeaturesFiles"},
            glue = {"StepDefinitions"}

    )

    @Listeners({ExtentITestListenerClassAdapter.class})
    public class ExtentReports extends AbstractTestNGCucumberTests {

    }
}
