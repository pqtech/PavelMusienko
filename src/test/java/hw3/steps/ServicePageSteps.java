package hw3.steps;

import hw3.pages.ServicePage;

import static org.testng.Assert.*;

public class ServicePageSteps {

    public static void checkCheckboxesAmount(ServicePage servicePage) {
        assertEquals(servicePage.getCheckboxesAmount(), 4);
    }

    public static void checkRadiosAmount(ServicePage servicePage) {
        assertEquals(servicePage.getRadiosAmount(), 4);
    }

    public static void checkDropDownMenu(ServicePage servicePage) {
        assertTrue(servicePage.isDropDownDisplayed());
    }

    public static void checkButtons(ServicePage servicePage) {
        assertTrue(servicePage.isButton1Displayed());
        assertTrue(servicePage.isButton2Displayed());
    }

    public static void checkLogSidebar(ServicePage servicePage) {
        assertTrue(servicePage.isLogSidebarDisplayed());
    }

    public static void checkLeftSidebarMenu(ServicePage servicePage) {
        assertTrue(servicePage.isLeftSidebarMenuDisplayed());
    }

    public static void checkCheckbox1Set(ServicePage servicePage) {
        servicePage.clickCheckbox1();
        assertTrue(servicePage.isCheckbox1Selected());
    }

    public static void checkCheckbox3Set(ServicePage servicePage) {
        servicePage.clickCheckbox3();
        assertTrue(servicePage.isCheckbox3Selected());
    }

    public static void checkCheckboxesLogsSet(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("Wind: condition changed to true"));
        assertTrue(servicePage.getLogsList().get(1).getText()
                .contains("Water: condition changed to true"));
    }

    public static void checkRadioButton4Set(ServicePage servicePage) {
        servicePage.clickRadioButton4();
        assertTrue(servicePage.isRadioButton4Selected());
    }

    public static void checkRadioButton4Logs(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("metal: value changed to Selen"));
    }

    public static void checkColorsLogs(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("Colors: value changed to Yellow"));
    }

    public static void checkCheckbox1Unset(ServicePage servicePage) {
        servicePage.clickCheckbox1();
        assertFalse(servicePage.isCheckbox1Selected());
    }

    public static void checkCheckbox3Unset(ServicePage servicePage) {
        servicePage.clickCheckbox3();
        assertFalse(servicePage.isCheckbox3Selected());
    }

    public static void checkCheckboxesLogsUnset(ServicePage servicePage) {
        assertTrue(servicePage.getLogsList().get(0).getText()
                .contains("Wind: condition changed to false"));
        assertTrue(servicePage.getLogsList().get(1).getText()
                .contains("Water: condition changed to false"));
    }


}
