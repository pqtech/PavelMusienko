package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ServicePage {

    protected WebDriver driver;
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxesList;
    @FindBy(className = "label-radio")
    private List<WebElement> radioList;
    @FindBy(className = "colors")
    private WebElement dropDownMenu;
    @FindBy(css = "button[name='Default Button']")
    private WebElement button1;
    @FindBy(css = "input[value='Button']")
    private WebElement button2;
    @FindBy(name = "log-sidebar")
    private WebElement logSidebar;
    @FindBy(className = "sidebar-menu")
    private WebElement leftSidebarMenu;
    @FindBy(xpath = "//label[@class='label-checkbox'][1]/input")
    private WebElement checkbox1;
    @FindBy(xpath = "//label[@class='label-checkbox'][3]/input")
    private WebElement checkbox3;
    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logsList;
    @FindBy(xpath = "//label[@class='label-radio'][4]/input")
    private WebElement radioButton4;
    @FindBy(css = "div.colors select")
    private WebElement colorsDropDownMenu;

    public ServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getCheckboxesAmount() {
        return checkboxesList.size();
    }

    public int getRadiosAmount() {
        return radioList.size();
    }

    public Boolean isDropDownDisplayed() {
        return dropDownMenu.isDisplayed();
    }

    public Boolean isButton1Displayed() {
        return button1.isDisplayed();
    }

    public Boolean isButton2Displayed() {
        return button2.isDisplayed();
    }

    public Boolean isLogSidebarDisplayed() {
        return logSidebar.isDisplayed();
    }

    public Boolean isLeftSidebarMenuDisplayed() {
        return leftSidebarMenu.isDisplayed();
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public void clickCheckbox3() {
        checkbox3.click();
    }

    public Boolean isCheckbox1Selected() {
        return checkbox1.isSelected();
    }

    public Boolean isCheckbox3Selected() {
        return checkbox3.isSelected();
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public void clickRadioButton4() {
        radioButton4.click();
    }

    public Boolean isRadioButton4Selected() {
        return radioButton4.isSelected();
    }

    public void selectYellowInDropDownMenu() {
        Select colors = new Select(colorsDropDownMenu);
        colors.selectByVisibleText("Yellow");
    }

}
