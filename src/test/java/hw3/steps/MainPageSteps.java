package hw3.steps;

import hw3.pages.MainPage;
import hw3.pages.ServicePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageSteps {
    public static void checkMainPageTitle(MainPage mainPage) {
        assertEquals(mainPage.getPageTitle(), "Home Page");
    }

    public static void performLogin(MainPage mainPage) throws IOException {
        mainPage.loginUser();
    }

    public static void checkPageUserName(MainPage mainPage) {
        assertEquals(mainPage.getPageUserName(), "ROMAN IOVLEV");
    }

    public static void checkHeaderSection(MainPage mainPage) {
        assertTrue(mainPage.isHomeMenuTabDisplayed());
        assertTrue(mainPage.isContactFormMenuTabDisplayed());
        assertTrue(mainPage.isServiceMenuTabDisplayed());
        assertTrue(mainPage.isMetalColorsMenuTabDisplayed());
        assertEquals(mainPage.getHomeMenuTabText(), "HOME");
        assertEquals(mainPage.getContactFormMenuTabText(), "CONTACT FORM");
        assertEquals(mainPage.getServiceMenuTabText(), "SERVICE");
        assertEquals(mainPage.getMetalColorsMenuTabText(), "METALS & COLORS");
    }

    public static void checkImages(MainPage mainPage) {
        assertEquals(mainPage.getImages().size(), 4);
        for (WebElement element : mainPage.getImages()) {
            assertTrue(element.isDisplayed());
        }
    }

    public static void checkTextsUnderImages(MainPage mainPage) {
        String text1 = "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project";
        assertEquals(mainPage.getTextsUnderImages().get(0).getText(), text1);
        String text2 = "To be flexible and\n"
                + "customizable";
        assertEquals(mainPage.getTextsUnderImages().get(1).getText(), text2);
        String text3 = "To be multiplatform";
        assertEquals(mainPage.getTextsUnderImages().get(2).getText(), text3);
        String text4 = "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…";
        assertEquals(mainPage.getTextsUnderImages().get(3).getText(), text4);
    }

    public static void checkMainHeaders(MainPage mainPage) {
        String mainHeaderText1 = "EPAM FRAMEWORK WISHES…";
        String mainHeaderText2 = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
                + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
                + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI "
                + "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN "
                + "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(mainPage.getMainHeader1Text(), mainHeaderText1);
        assertEquals(mainPage.getMainHeader2Text(), mainHeaderText2);
    }

    public static void checkIfFrameExists(MainPage mainPage) {
        assertTrue(mainPage.getIframesAmount() > 0);
    }

    public static void checkEpamLogo(MainPage mainPage) {
        assertTrue(mainPage.isEpamLogoDisplayed());
    }

    public static void checkGithubLinkText(MainPage mainPage) {
        assertEquals(mainPage.getGithubLinkText(), "JDI GITHUB");
    }

    public static void checkGithubLinkUrl(MainPage mainPage) {
        assertEquals(mainPage.getGithubLinkUrl(), "https://github.com/epam/JDI");
    }

    public static void checkLeftSection(MainPage mainPage) {
        assertTrue(mainPage.isLeftSectionDisplayed());
    }

    public static void checkFooter(MainPage mainPage) {
        assertTrue(mainPage.isFooterDisplayed());
    }

    public static void checkIfDropdownMenuContainsElements(MainPage mainPage) {
        mainPage.clickServiceMenuTab();
        assertEquals(mainPage.getServiceDropdownMenuElementsAmount(), 9);
    }

    public static void checkIfLeftDropdownMenuContainsElements(MainPage mainPage) {
        mainPage.clickServiceLeftMenuTab();
        assertEquals(mainPage.getServiceLeftDropdownMenuElementsAmount(), 9);
    }

    public static ServicePage openServicePage(MainPage mainPage) {
        mainPage.clickServiceMenuTab();
        return mainPage.clickServicePageMenuOption();
    }

}