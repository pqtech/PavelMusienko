package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static hw4.steps.MainPageSteps.*;

public class FailTest extends GeneralTests {

    @Feature(value = "Site testing")
    @Stories(value = {@Story(value = "Main page functionality"),
            @Story(value = "Service page functionality")})
    @Test(priority = 1)
    @Override
    public void mainPageTitleBeforeLoginTest() {
        // 2. Assert Browser title
        checkMainPageTitle(mainPage);
        Assert.fail("Something went wrong...");
    }

}
