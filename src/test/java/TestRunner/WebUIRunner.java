package TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( tags = {"@trademe_page"},glue = {"stepdefs"}, features = {"src/test/resources/feature/webui"})

public class WebUIRunner {


}
