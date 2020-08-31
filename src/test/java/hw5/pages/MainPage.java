package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainPage {
    protected WebDriver driver;
    String pageUrl = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(className = "profile-photo")
    private WebElement profilePic;
    @FindBy(id = "name")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement userPasswordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userNameLabel;
    @FindBy(linkText = "SERVICE")
    private WebElement serviceMenuTab;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsPageMenuOption;
    @FindBy(xpath = "//a[contains(text(),'User Table')]")
    private WebElement userTableMenuOption;

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

    public void loginUser() throws IOException {
        InputStream input = new FileInputStream("src/test/resources/user.properties");
        Properties prop = new Properties();
        prop.load(input);

        profilePic.click();
        userNameField.sendKeys(prop.getProperty("user.name"));
        userPasswordField.sendKeys(prop.getProperty("user.password"));
        loginButton.click();
    }

    public String getPageUserName() {
        return userNameLabel.getText();
    }

    public void clickServiceMenuTab() {
        serviceMenuTab.click();
    }

    public ServicePage clickServicePageMenuOption() {
        differentElementsPageMenuOption.click();
        return new ServicePage(driver);
    }

    public UserTablePage clickUserTableMenuOption() {
        userTableMenuOption.click();
        return new UserTablePage(driver);
    }
}
