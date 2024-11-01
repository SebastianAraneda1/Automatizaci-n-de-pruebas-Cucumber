package Ejecutador;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/Feature/EscenarioLogin.feature"},
    glue = {"DefinicionPasos"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class Runner {
}
