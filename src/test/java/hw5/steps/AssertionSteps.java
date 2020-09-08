package hw5.steps;

import hw5.context.TestContext;
import hw5.pages.MainPage;
import hw5.pages.ServicePage;
import hw5.pages.UserTablePage;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps {

    MainPage mainPage = new MainPage(TestContext.getInstance().getDriver());
    ServicePage servicePage = new ServicePage(TestContext.getInstance().getDriver());
    UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().getDriver());

    @Then("Browser title is equal to {string}")
    public void browser_title_is_equal_to(String mainPageTitle) {
        assertEquals(mainPage.getPageTitle(), mainPageTitle);
    }

    @Then("Correct username {string} is shown on the Main Page")
    public void correct_username_is_shown_on_the_Main_Page(String userName) {
        assertEquals(mainPage.getPageUserName(), userName);
    }

    @Then("Correct Water checkbox log is shown in the logs area")
    public void correct_water_checkbox_log_is_shown_in_the_logs_area() {
        assertTrue(servicePage.logContainsCheckboxWater());
    }

    @Then("Correct Wind checkbox log is shown in the logs area")
    public void correct_wind_checkbox_log_is_shown_in_the_logs_area() {
        assertTrue(servicePage.logContainsCheckboxWind());
    }

    @Then("Correct \"Selen\" radio button log is shown in the logs area")
    public void correct_radio_button_log_is_shown_in_the_logs_area() {
        assertTrue(servicePage.logContainsRadiobuttonSelen());
    }

    @Then("Correct dropdown menu log for \"Yellow\" color is shown in the logs area")
    public void correct_dropdown_menu_log_for_color_is_shown_in_the_logs_area() {
        assertTrue(servicePage.logContainsSelectedColor());
    }

    @Then("{string} page should be opened")
    public void page_should_be_opened(String userTablePageTitle) {
        assertEquals(userTablePage.getPageTitle(), userTablePageTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void number_Type_Dropdowns_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer dropdownsCount) {
        assertEquals((Integer) userTablePage.getDropDownList().size(), dropdownsCount);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernames_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer usernamesCount) {
        assertEquals((Integer) userTablePage.getUserNameList().size(), usernamesCount);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void description_texts_under_images_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer descriptionsCount) {
        assertEquals((Integer) userTablePage.getDescriptionList().size(), descriptionsCount);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxes_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer checkboxesCount) {
        assertEquals((Integer) userTablePage.getCheckboxList().size(), checkboxesCount);
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> expectedData = dataTable.asLists();
        assertEquals(userTablePage.getActualData(), expectedData);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> expectedData = dataTable.asLists();
        assertEquals(userTablePage.getDropDownItemsRomanList(), expectedData);
    }

    @Then("One log row has {string} text in log section")
    public void one_log_row_has_text_in_log_section(String logText) {
        assertTrue(userTablePage.logContainsCheckboxForSergey(logText));
    }

}
