package hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
