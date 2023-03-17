package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = { "steps" }, plugin = {
		"html:target/cucumber-html-report.html", "pretty", "json:target/cucumber.json" })
public class TestRunner {

}
