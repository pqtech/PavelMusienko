package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class GeneralTests {

    String driverPath = "C:/dev/chromedriver/chromedriver.exe";
    private WebDriver driver;
    String pageUrl = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageUrl);
    }

    @Test
    public void simpleTest() {
        System.out.println("1st Test here");
        assertEquals(driver.getTitle(), "Home Page");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After Class");
        driver.quit();
    }

}
