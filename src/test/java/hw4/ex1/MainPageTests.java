package hw4.ex1;

import hw4.GeneralTests;
import org.testng.annotations.Test;

import static hw4.steps.MainPageSteps.*;

public class MainPageTests extends GeneralTests {

    protected String mainWindowHandle;

    @Test(priority = 3)
    public void mainPageTitleAfterLoginTest() {
        // 5. Assert Browser title
        checkMainPageTitle(mainPage);
    }

    @Test(priority = 4)
    public void headerSectionTest() {
        // 6. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        checkHeaderSection(mainPage);
    }

    @Test(priority = 5)
    public void imagesTest() {
        // 7. Assert that there are 4 images on the Index Page and they are displayed
        checkImages(mainPage);
    }

    @Test(priority = 6)
    public void textUnderImagesTest() {
        // 8. Assert that there are 4 texts on the Index Page under
        // icons and they have proper text
        checkTextsUnderImages(mainPage);

    }

    @Test(priority = 7)
    public void mainHeadersTextTest() {
        // 9. Assert a text of the main headers
        checkMainHeaders(mainPage);
    }

    @Test(priority = 8)
    public void iframeExistsTest() {
        // 10. Assert that there is the iframe in the center of page
        checkIfFrameExists(mainPage);
    }

    @Test(priority = 9)
    public void iframeEpamLogoTest() {
        // 11. Switch to the iframe and check that there is
        // Epam logo in the left top conner of iframe
        mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame("second_frame");
        checkEpamLogo(mainPage);
    }

    @Test(priority = 10)
    public void switchToOriginalWindowTest() {
        // 12. Switch to original window back
        driver.switchTo().window(mainWindowHandle);
    }

    @Test(priority = 11)
    public void githubLinkTextTest() {
        // 13. Assert a text of the sub header
        checkGithubLinkText(mainPage);
    }

    @Test(priority = 12)
    public void githubLinkUrlTest() {
        // 14. Assert that JDI GITHUB is a link and has a proper URL
        checkGithubLinkUrl(mainPage);
    }

    @Test(priority = 13)
    public void leftSectionIsDisplayedTest() {
        // 15. Assert that there is Left Section
        checkLeftSection(mainPage);
    }

    @Test(priority = 14)
    public void footerIsDisplayedTest() {
        // 16. Assert that there is Footer
        checkFooter(mainPage);
    }
}
