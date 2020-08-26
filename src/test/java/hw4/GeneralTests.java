package hw4;

import hw4.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static hw4.steps.MainPageSteps.*;

public abstract class GeneralTests {

    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1. Open test site by URL
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        context.setAttribute("driver", driver);
    }

    @Feature(value = "Site testing")
    @Stories(value = {@Story(value = "Main page functionality"),
            @Story(value = "Service page functionality")})
    @Test(priority = 1)
    public void mainPageTitleBeforeLoginTest() {
        // 2. Assert Browser title
        checkMainPageTitle(mainPage);
    }

    @Feature(value = "Site testing")
    @Stories(value = {@Story(value = "Main page functionality"),
            @Story(value = "Service page functionality")})
    @Test(priority = 2)
    public void mainPageLoginTest() throws IOException {
        // 3. Perform login
        performLogin(mainPage);

        // 4. Assert User name in the left-top side of screen that user is loggined
        checkPageUserName(mainPage);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
