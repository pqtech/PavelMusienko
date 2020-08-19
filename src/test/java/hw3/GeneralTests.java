package hw3;

import hw3.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static hw3.steps.MainPageSteps.*;

import static org.testng.Assert.assertEquals;

public class GeneralTests {

    protected WebDriver driver;
    protected MainPage mainPage;
    String driverPath = "C:/dev/chromedriver/chromedriver.exe";
    String userName = "Roman";
    String password = "Jdi1234";
    String expectedUserName = "ROMAN IOVLEV";

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
    public void mainPageLoginTest() {
        // 3. Perform login
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        // 4. Assert User name in the left-top side of screen that user is loggined
        String actualUserName = driver.findElement(By.id("user-name")).getText();
        assertEquals(actualUserName, expectedUserName);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
