package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    protected WebDriver driver;

    String pageUrl = "https://jdi-testing.github.io/jdi-light/index.html";

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openMainPage() {
        driver.navigate().to(pageUrl);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
