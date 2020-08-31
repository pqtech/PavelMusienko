package hw5.steps;

import hw5.context.TestContext;
import hw5.pages.MainPage;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class ModelSteps {

    MainPage mainPage = new MainPage(TestContext.getInstance().getDriver());

    @Given("I open Main page of JDI Github site")
    public void i_open_Main_page_of_JDI_Github_site() {
        mainPage.openMainPage();
    }

    @Given("I login as user Roman Iovlev")
    public void i_login_as_user_Roman_Iovlev() throws IOException {
        mainPage.loginUser();
    }

    @Given("I click on \"Service\" in Header on the Main Page")
    public void i_click_on_Service_in_Header_on_the_Main_Page() {
        mainPage.clickServiceMenuTab();
    }

    @Given("I select \"Different Elements\" in dropdown menu on the Main page")
    public void i_select_in_dropdown_menu_on_the_Main_page() {
        mainPage.clickServicePageMenuOption();
    }
}
