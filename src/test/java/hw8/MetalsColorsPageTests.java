package hw8;

import com.epam.jdi.light.elements.init.PageFactory;
import hw8.beans.MetalsColorsData;
import hw8.entities.User;
import hw8.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static org.testng.Assert.assertEquals;

public class MetalsColorsPageTests {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
        JdiSite.open();
        JdiSite.login(User.ROMAN);
        HomePage.userName.is().text(User.ROMAN.getFullName());
    }

    @AfterSuite
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataset")
    public void MetalsColorsPageTest(MetalsColorsData testData) {

        JdiSite.homePage.openMetalsColorsPage();
        JdiSite.metalsColorsPage.performActions(testData);
        assertEquals(JdiSite.metalsColorsPage.getResults(), testData.getExpectedResults());
    }
}
