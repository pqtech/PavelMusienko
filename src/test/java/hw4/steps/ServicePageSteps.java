package hw4.steps;

import hw4.pages.ServicePage;
import io.qameta.allure.Step;

import static org.testng.Assert.*;

public class ServicePageSteps {


    @Step(value = "Checking checkboxes amount")
    public static void checkCheckboxesAmount(ServicePage servicePage) {
        assertEquals(servicePage.getCheckboxesAmount(), 4);
    }

    @Step(value = "Checking radio buttons amount")
    public static void checkRadiosAmount(ServicePage servicePage) {
        assertEquals(servicePage.getRadiosAmount(), 4);
    }

    @Step(value = "Checking if dropdown menu is displayed")
    public static void checkDropDownMenu(ServicePage servicePage) {
        assertTrue(servicePage.isDropDownDisplayed());
    }


    @Step(value = "Checking if buttons are displayed")
    public static void checkButtons(ServicePage servicePage) {
        assertTrue(servicePage.isButton1Displayed());
        assertTrue(servicePage.isButton2Displayed());
    }

    @Step(value = "Checking if log sidebar is displayed")
    public static void checkLogSidebar(ServicePage servicePage) {
        assertTrue(servicePage.isLogSidebarDisplayed());
    }

    @Step(value = "Checking left sidebar menu")
    public static void checkLeftSidebarMenu(ServicePage servicePage) {
        assertTrue(servicePage.isLeftSidebarMenuDisplayed());
    }

    @Step(value = "Checking setting checkbox 1")
    public static void checkCheckbox1Set(ServicePage servicePage) {
        servicePage.clickCheckbox1();
        assertTrue(servicePage.isCheckbox1Selected());
    }

    @Step(value = "Checking setting checkbox 3")
    public static void checkCheckbox3Set(ServicePage servicePage) {
        servicePage.clickCheckbox3();
        assertTrue(servicePage.isCheckbox3Selected());
    }

    @Step(value = "Checking checkbox logs")
    public static void checkCheckboxesLogsSet(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("Wind: condition changed to true"));
        assertTrue(servicePage.getLogsList().get(1).getText()
                .contains("Water: condition changed to true"));
    }

    @Step(value = "Checking setting radiobutton 4")
    public static void checkRadioButton4Set(ServicePage servicePage) {
        servicePage.clickRadioButton4();
        assertTrue(servicePage.isRadioButton4Selected());
    }

    @Step(value = "Checking radiobutton logs")
    public static void checkRadioButton4Logs(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("metal: value changed to Selen"));
    }


    @Step(value = "Checking colors dropdown menu logs")
    public static void checkColorsLogs(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("Colors: value changed to Yellow"));
    }

    @Step(value = "Checking unsetting checkbox 1")
    public static void checkCheckbox1Unset(ServicePage servicePage) {
        servicePage.clickCheckbox1();
        assertFalse(servicePage.isCheckbox1Selected());
    }

    @Step(value = "Checking unsetting checkbox 3")
    public static void checkCheckbox3Unset(ServicePage servicePage) {
        servicePage.clickCheckbox3();
        assertFalse(servicePage.isCheckbox3Selected());
    }


    @Step(value = "Checking unsetting checkbox logs")
    public static void checkCheckboxesLogsUnset(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("Wind: condition changed to false"));
        assertTrue(servicePage.getLogsList().get(1).getText()
                .contains("Water: condition changed to false"));
    }


}
