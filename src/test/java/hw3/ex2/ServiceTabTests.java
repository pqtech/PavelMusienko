package hw3.ex2;

import hw3.GeneralTests;
import hw3.pages.ServicePage;
import org.testng.annotations.Test;

import static hw3.steps.MainPageSteps.*;
import static hw3.steps.ServicePageSteps.*;

public class ServiceTabTests extends GeneralTests {

    protected ServicePage servicePage;

    @Test(priority = 3)
    public void serviceDropdownMenuTest() {
        // 5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        checkIfDropdownMenuContainsElements(mainPage);
    }

    @Test(priority = 4)
    public void serviceLeftDropdownMenuTest() {
        // 6. Click on Service subcategory in the left section and
        // check that drop down contains options
        checkIfLeftDropdownMenuContainsElements(mainPage);
    }

    @Test(priority = 5)
    public void openDifferentElementsPageTest() {
        // 7. Open through the header menu Service -> Different Elements Page
        servicePage = openServicePage(mainPage);
    }

    @Test(priority = 6)
    public void elementsOnDifferentElementsPageTest() {
        // 8. Check interface on Different elements page, it contains all needed elements
        checkCheckboxesAmount(servicePage);
        checkRadiosAmount(servicePage);
        checkDropDownMenu(servicePage);
        checkButtons(servicePage);
    }

    @Test(priority = 7)
    public void rightSectionIsDisplayedTest() {
        // 9. Assert that there is Right Section
        checkLogSidebar(servicePage);
    }

    @Test(priority = 8)
    public void leftSectionIsDisplayedTest() {
        // 10. Assert that there is Left Section
        checkLeftSidebarMenu(servicePage);
    }

    @Test(priority = 9)
    public void selectCheckboxesTest() {
        // 11. Select checkboxes
        checkCheckbox1Set(servicePage);
        checkCheckbox3Set(servicePage);
    }

    @Test(priority = 10)
    public void checkboxLogsTest() {
        // 12. Assert that for each checkbox there is an individual 
        // log row and value is corresponded to the status of checkbox.
        checkCheckboxesLogsSet(servicePage);
    }

    @Test(priority = 11)
    public void selectRadioTest() {
        // 13. Select radio
        checkRadioButton4Set(servicePage);
    }

    @Test(priority = 12)
    public void radioLogsTest() {
        // 14. Assert that for radiobutton there is a log row and
        // value is corresponded to the status of radiobutton. 
        checkRadioButton4Logs(servicePage);
    }

    @Test(priority = 13)
    public void selectDropdownTest() {
        // 15. Select in dropdown
        servicePage.selectYellowInDropDownMenu();
    }

    @Test(priority = 14)
    public void dropdownLogsTest() {
        // 16. Assert that for dropdown there is a log row and
        // value is corresponded to the selected value.  
        checkColorsLogs(servicePage);
    }

    @Test(priority = 15)
    public void unselectCheckboxesTest() {
        // 17. Unselect and assert checkboxes
        checkCheckbox1Unset(servicePage);
        checkCheckbox3Unset(servicePage);
    }

    @Test(priority = 16)
    public void checkboxUnselectLogsTest() {
        // 18. Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox. 
        checkCheckboxesLogsUnset(servicePage);
    }
}
