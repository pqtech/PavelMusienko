package hw3.ex2;

import hw2.GeneralTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ServiceTabTests extends GeneralTests {

    @Test(priority = 3)
    public void serviceDropdownMenuTest() {
        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        driver.findElement(new By.ByLinkText("SERVICE")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("ul.dropdown-menu li"));
        assertEquals(elements.size(), 9);
    }

    @Test(priority = 4)
    public void serviceLeftDropdownMenuTest() {
        // 6. Click on Service subcategory in the left section and
        // check that drop down contains options
        driver.findElement(By.cssSelector("li[class='menu-title']")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("li[index='3'] ul.sub li"));
        assertEquals(elements.size(), 9);
    }

    @Test(priority = 5)
    public void openDifferentElementsPageTest() {
        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(new By.ByLinkText("SERVICE")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Different elements')]")).click();
    }

    @Test(priority = 6)
    public void elementsOnDifferentElementsPageTest() {
        // 8. Check interface on Different elements page, it contains all needed elements
        List<WebElement> checkboxesList = driver.findElements(By.className("label-checkbox"));
        assertEquals(checkboxesList.size(), 4);
        List<WebElement> radioList = driver.findElements(By.className("label-radio"));
        assertEquals(radioList.size(), 4);
        assertTrue(driver.findElement(By.className("colors")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("button[name='Default Button']"))
                .isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("input[value='Button']"))
                .isDisplayed());
    }

    @Test(priority = 7)
    public void rightSectionIsDisplayedTest() {
        // 9. Assert that there is Right Section
        assertTrue(driver.findElement(By.name("log-sidebar")).isDisplayed());
    }

    @Test(priority = 8)
    public void leftSectionIsDisplayedTest() {
        // 10. Assert that there is Left Section
        assertTrue(driver.findElement(By.className("sidebar-menu")).isDisplayed());
    }

    @Test(priority = 9)
    public void selectCheckboxesTest() {
        // 11. Select checkboxes
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]/input")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]/input")).click();
        assertTrue(driver.findElement(By.xpath("//label[@class='label-checkbox'][1]/input"))
                .isSelected());
        assertTrue(driver.findElement(By.xpath("//label[@class='label-checkbox'][3]/input"))
                .isSelected());
    }

    @Test(priority = 10)
    public void checkboxLogsTest() {
        // 12. Assert that for each checkbox there is an individual 
        // log row and value is corresponded to the status of checkbox.
        List<WebElement> logsList = driver.findElements(By
                .cssSelector("ul.panel-body-list.logs li"));
        assertTrue(logsList.get(0).getText().contains("Wind: condition changed to true"));
        assertTrue(logsList.get(1).getText().contains("Water: condition changed to true"));
    }

    @Test(priority = 11)
    public void selectRadioTest() {
        // 13. Select radio
        driver.findElement(By.xpath("//label[@class='label-radio'][4]/input")).click();
        assertTrue(driver.findElement(By.xpath("//label[@class='label-radio'][4]/input"))
                .isDisplayed());
    }

    @Test(priority = 12)
    public void radioLogsTest() {
        // 14. Assert that for radiobutton there is a log row and
        // value is corresponded to the status of radiobutton. 
        List<WebElement> logsList = driver.findElements(By
                .cssSelector("ul.panel-body-list.logs li"));
        assertTrue(logsList.get(0).getText().contains("metal: value changed to Selen"));
    }

    @Test(priority = 13)
    public void selectDropdownTest() {
        // 15. Select in dropdown
        Select colors = new Select(driver.findElement(By.cssSelector("div.colors select")));
        colors.selectByVisibleText("Yellow");
    }

    @Test(priority = 14)
    public void dropdownLogsTest() {
        // 16. Assert that for dropdown there is a log row and
        // value is corresponded to the selected value.  
        List<WebElement> logsList = driver.findElements(By
                .cssSelector("ul.panel-body-list.logs li"));
        assertTrue(logsList.get(0).getText().contains("Colors: value changed to Yellow"));
    }

    @Test(priority = 15)
    public void unselectCheckboxesTest() {
        // 17. Unselect and assert checkboxes
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]/input")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]/input")).click();
        assertFalse(driver.findElement(By.xpath("//label[@class='label-checkbox'][1]/input"))
                .isSelected());
        assertFalse(driver.findElement(By.xpath("//label[@class='label-checkbox'][3]/input"))
                .isSelected());
    }

    @Test(priority = 16)
    public void checkboxUnselectLogsTest() {
        // 18. Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox. 
        List<WebElement> logsList = driver.findElements(By
                .cssSelector("ul.panel-body-list.logs li"));
        assertTrue(logsList.get(0).getText().contains("Wind: condition changed to false"));
        assertTrue(logsList.get(1).getText().contains("Water: condition changed to false"));
    }
}
