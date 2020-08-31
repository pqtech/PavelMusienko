package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserTablePage {

    protected WebDriver driver;

    @FindBy(tagName = "select")
    private List<WebElement> dropDownList;
    @FindBy(css = "#user-table a")
    private List<WebElement> userNameList;
    @FindBy(css = "#user-table span")
    private List<WebElement> descriptionList;
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxList;
    @FindBy(xpath = "//tr[2]//option")
    private List<WebElement> dropDownItemsRoman;
    @FindBy(id = "ivan")
    private WebElement checkboxForIvan;
    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logsList;

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getDropDownList() {
        return dropDownList;
    }

    public List<WebElement> getUserNameList() {
        return userNameList;
    }

    public List<WebElement> getDescriptionList() {
        return descriptionList;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public List<List<String>> getActualData() {
        List<List<String>> actualData = new ArrayList<>();
        actualData.add(Arrays.asList("Number", "User", "Description"));
        List<WebElement> userNameList = new ArrayList<WebElement>(getUserNameList());
        List<WebElement> descriptionList = new ArrayList<WebElement>(getDescriptionList());

        for (int i = 1; i < descriptionList.size() + 1; i++) {
            String userName = userNameList.get(i - 1).getText();
            String description = descriptionList.get(i - 1).getText().replaceAll("\n", " ");
            actualData.add(Arrays.asList(String.valueOf(i), userName, description));
        }
        return actualData;
    }

    public List<WebElement> getDropDownItemsRoman() {
        return dropDownItemsRoman;
    }

    public List<List<String>> getDropDownItemsRomanList() {
        List<List<String>> actualData = new ArrayList<>();
        actualData.add(Arrays.asList("Dropdown Values"));
        for (WebElement element : getDropDownItemsRoman()) {
            actualData.add(Arrays.asList(element.getText()));
        }
        return actualData;
    }

    public void clickCheckboxForIvan() {
        checkboxForIvan.click();
    }

    public Boolean logContainsCheckboxForSergey(String expected) {
        for (WebElement element : logsList) {
            if (element.getText().contains(expected)) {
                return true;
            }
        }
        return false;
    }
}
