package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MainPage {
    protected WebDriver driver;
    String pageUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    String userName = "Roman";
    String password = "Jdi1234";
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
    @FindBy(linkText = "HOME")
    private WebElement homeMenuTab;
    @FindBy(linkText = "CONTACT FORM")
    private WebElement contactFormMenuTab;
    @FindBy(linkText = "SERVICE")
    private WebElement serviceMenuTab;
    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalColorsMenuTab;
    @FindBy(className = "benefit-icon")
    private List<WebElement> images;
    @FindBy(className = "benefit-txt")
    private List<WebElement> textsUnderImages;
    @FindBy(name = "main-title")
    private WebElement mainHeader1;
    @FindBy(name = "jdi-text")
    private WebElement mainHeader2;
    @FindBy(tagName = "iframe")
    private List<WebElement> iframes;
    @FindBy(id = "epam-logo")
    private WebElement epamLogo;
    @FindBy(css = "h3.text-center a")
    private WebElement githubLink;
    @FindBy(name = "navigation-sidebar")
    private WebElement leftSection;
    @FindBy(className = "footer-content")
    private WebElement footer;
    @FindBy(css = "ul.dropdown-menu li")
    private List<WebElement> serviceDropdownMenu;
    @FindBy(css = "li[class='menu-title']")
    private WebElement serviceLeftMenuTab;
    @FindBy(css = "li[index='3'] ul.sub li")
    private List<WebElement> serviceLeftDropdownMenu;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsPageMenuOption;

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

    public Boolean isHomeMenuTabDisplayed() {
        return homeMenuTab.isDisplayed();
    }

    public Boolean isContactFormMenuTabDisplayed() {
        return contactFormMenuTab.isDisplayed();
    }

    public Boolean isServiceMenuTabDisplayed() {
        return serviceMenuTab.isDisplayed();
    }

    public Boolean isMetalColorsMenuTabDisplayed() {
        return metalColorsMenuTab.isDisplayed();
    }

    public String getHomeMenuTabText() {
        return homeMenuTab.getText();
    }

    public String getContactFormMenuTabText() {
        return contactFormMenuTab.getText();
    }

    public String getServiceMenuTabText() {
        return serviceMenuTab.getText();
    }

    public String getMetalColorsMenuTabText() {
        return metalColorsMenuTab.getText();
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTextsUnderImages() {
        return textsUnderImages;
    }

    public String getMainHeader1Text() {
        return mainHeader1.getText();
    }

    public String getMainHeader2Text() {
        return mainHeader2.getText();
    }

    public int getIframesAmount() {
        return iframes.size();
    }

    public Boolean isEpamLogoDisplayed() {
        return epamLogo.isDisplayed();
    }

    public String getGithubLinkText() {
        return githubLink.getText();
    }

    public String getGithubLinkUrl() {
        return githubLink.getAttribute("href");
    }

    public Boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }

    public Boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    public void clickServiceMenuTab() {
        serviceMenuTab.click();
    }

    public int getServiceDropdownMenuElementsAmount() {
        return serviceDropdownMenu.size();
    }

    public void clickServiceLeftMenuTab() {
        serviceLeftMenuTab.click();
    }

    public int getServiceLeftDropdownMenuElementsAmount() {
        return serviceLeftDropdownMenu.size();
    }

    public ServicePage clickServicePageMenuOption() {
        differentElementsPageMenuOption.click();
        return new ServicePage(driver);
    }


}
