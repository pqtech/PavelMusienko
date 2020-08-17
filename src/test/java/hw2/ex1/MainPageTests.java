package hw2.ex1;

import hw2.GeneralTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageTests extends GeneralTests {

    protected String mainWindowHandle;

    @Test(priority = 3)
    public void mainPageTitleAfterLoginTest() {
        // 5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test(priority = 4)
    public void headerSectionTest() {
        // 6. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        WebElement homeMenuTab = driver.findElement(new By.ByLinkText("HOME"));
        assertTrue(homeMenuTab.isDisplayed());
        WebElement contactFormMenuTab = driver.findElement(new By.ByLinkText("CONTACT FORM"));
        assertTrue(contactFormMenuTab.isDisplayed());
        WebElement serviceMenuTab = driver.findElement(new By.ByLinkText("SERVICE"));
        assertTrue(serviceMenuTab.isDisplayed());
        WebElement metalColorsMenuTab = driver.findElement(new By.ByLinkText("METALS & COLORS"));
        assertTrue(metalColorsMenuTab.isDisplayed());
        assertEquals(homeMenuTab.getText(), "HOME");
        assertEquals(contactFormMenuTab.getText(), "CONTACT FORM");
        assertEquals(serviceMenuTab.getText(), "SERVICE");
        assertEquals(metalColorsMenuTab.getText(), "METALS & COLORS");
    }

    @Test(priority = 5)
    public void imagesTest() {
        // 7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> elements = driver.findElements(By.className("benefit-icon"));
        assertEquals(elements.size(), 4);
        for (WebElement element : elements) {
            assertTrue(element.isDisplayed());
        }
    }

    @Test(priority = 6)
    public void textUnderImagesTest() {
        // 8. Assert that there are 4 texts on the Index Page under
        // icons and they have proper text
        List<WebElement> elements = driver.findElements(By.className("benefit-txt"));
        String text1 = "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project";
        assertEquals(elements.get(0).getText(), text1);

        String text2 = "To be flexible and\n"
                + "customizable";
        assertEquals(elements.get(1).getText(), text2);

        String text3 = "To be multiplatform";
        assertEquals(elements.get(2).getText(), text3);

        String text4 = "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…";
        assertEquals(elements.get(3).getText(), text4);
    }

    @Test(priority = 7)
    public void mainHeadersTextTest() {
        // 9. Assert a text of the main headers
        String mainHeaderText1 = "EPAM FRAMEWORK WISHES…";
        String mainHeaderText2 = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
                + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
                + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI "
                + "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN "
                + "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        WebElement mainHeader1 = driver.findElement(By.name("main-title"));
        WebElement mainHeader2 = driver.findElement(By.name("jdi-text"));
        assertEquals(mainHeader1.getText(), mainHeaderText1);
        assertEquals(mainHeader2.getText(), mainHeaderText2);
    }

    @Test(priority = 8)
    public void iframeExistsTest() {
        // 10. Assert that there is the iframe in the center of page
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        assertTrue(elements.size() > 0);
    }

    @Test(priority = 9)
    public void iframeEpamLogoTest() {
        // 11. Switch to the iframe and check that there is
        // Epam logo in the left top conner of iframe
        mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame("second_frame");
        assertTrue(driver.findElement(By.id("epam-logo")).isDisplayed());
    }

    @Test(priority = 10)
    public void switchToOriginalWindowTest() {
        // 12. Switch to original window back
        driver.switchTo().window(mainWindowHandle);
    }

    @Test(priority = 11)
    public void githubLinkTextTest() {
        // 13. Assert a text of the sub header
        WebElement githubLink = driver.findElement(By.cssSelector("h3.text-center a"));
        assertEquals(githubLink.getText(), "JDI GITHUB");
    }

    @Test(priority = 12)
    public void githubLinkUrlTest() {
        // 14. Assert that JDI GITHUB is a link and has a proper URL
        WebElement githubLink = driver.findElement(By.cssSelector("h3.text-center a"));
        assertEquals(githubLink.getAttribute("href"),
                "https://github.com/epam/JDI");
    }

    @Test(priority = 13)
    public void leftSectionIsDisplayedTest() {
        // 15. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSection.isDisplayed());
    }

    @Test(priority = 14)
    public void footerIsDisplayedTest() {
        // 16. Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-content"));
        assertTrue(footer.isDisplayed());
    }
}
