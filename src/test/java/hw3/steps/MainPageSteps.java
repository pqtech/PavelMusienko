package hw3.steps;

import hw3.pages.MainPage;

import static org.testng.Assert.assertEquals;

public class MainPageSteps {
    public static void checkMainPageTitle(MainPage mainPage) {
        assertEquals(mainPage.getPageTitle(), "Home Page");
    }
}
