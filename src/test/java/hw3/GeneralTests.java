package hw3;

import hw3.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static hw3.steps.MainPageSteps.*;

public class GeneralTests {

    protected WebDriver driver;
    protected MainPage mainPage;
    String driverPath = "C:/dev/chromedriver/chromedriver.exe";


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1. Open test site by URL
        mainPage = new MainPage(driver);
        mainPage.openMainPage();

    }

    @Test(priority = 1)
    public void mainPageTitleBeforeLoginTest() {
        // 2. Assert Browser title
        checkMainPageTitle(mainPage);
    }

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
