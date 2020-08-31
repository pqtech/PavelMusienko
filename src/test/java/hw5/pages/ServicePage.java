package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ServicePage {

    protected WebDriver driver;

    @FindBy(xpath = "//label[@class='label-checkbox'][1]/input")
    private WebElement checkboxWater;
    @FindBy(xpath = "//label[@class='label-checkbox'][3]/input")
    private WebElement checkboxWind;
    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logsList;
    @FindBy(xpath = "//label[@class='label-radio'][4]/input")
    private WebElement radioButtonSelen;
    @FindBy(css = "div.colors select")
    private WebElement colorsDropDownMenu;

    public ServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickCheckboxWater() {
        checkboxWater.click();
    }

    public void clickCheckboxWind() {
        checkboxWind.click();
    }

    public Boolean logContainsCheckboxWater() {
        for (WebElement element : logsList) {
            if (element.getText().contains("Water: condition changed to true")) {
                return true;
            }
        }
        return false;
    }

    public Boolean logContainsCheckboxWind() {
        for (WebElement element : logsList) {
            if (element.getText().contains("Wind: condition changed to true")) {
                return true;
            }
        }
        return false;
    }

    public Boolean logContainsRadiobuttonSelen() {
        for (WebElement element : logsList) {
            if (element.getText().contains("metal: value changed to Selen")) {
                return true;
            }
        }
        return false;
    }

    public Boolean logContainsSelectedColor() {
        for (WebElement element : logsList) {
            if (element.getText().contains("Colors: value changed to Yellow")) {
                return true;
            }
        }
        return false;
    }

    public void clickRadioButtonSelen() {
        radioButtonSelen.click();
    }

    public void selectYellowInDropDownMenu() {
        Select colors = new Select(colorsDropDownMenu);
        colors.selectByVisibleText("Yellow");
    }
}
