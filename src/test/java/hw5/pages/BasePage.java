package hw5.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public String getPageTitle() {
        return driver.getTitle();
    }
}
