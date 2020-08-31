package hw5.steps;

import hw5.context.TestContext;
import hw5.pages.MainPage;
import hw5.pages.ServicePage;
import hw5.pages.UserTablePage;
import io.cucumber.java.en.When;

public class ActionSteps {

    MainPage mainPage = new MainPage(TestContext.getInstance().getDriver());
    ServicePage servicePage = new ServicePage(TestContext.getInstance().getDriver());
    UserTablePage userTablePage = new UserTablePage(TestContext.getInstance().getDriver());

    @When("I click on Water checkbox on the Different Elements page")
    public void i_click_on_water_checkbox_on_the_Different_Elements_page() {
        servicePage.clickCheckboxWater();
    }

    @When("I click on Wind checkbox on the Different Elements page")
    public void i_click_on_wind_checkbox_on_the_Different_Elements_page() {
        servicePage.clickCheckboxWind();
    }

    @When("I click on \"Selen\" radio button on the Different Elements page")
    public void i_click_on_radio_button_on_the_Different_Elements_page() {
        servicePage.clickRadioButtonSelen();
    }

    @When("I select \"Yellow\" in the color dropdown menu on the Different Elements page")
    public void i_select_in_the_color_dropdown_menu_on_the_Different_Elements_page() {
        servicePage.selectYellowInDropDownMenu();
    }

    @When("I click on \"Service\" button in Header")
    public void i_click_on_button_in_Header() {
        mainPage.clickServiceMenuTab();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void i_click_on_button_in_Service_dropdown() {
        mainPage.clickUserTableMenuOption();
    }

    @When("I select vip checkbox for Sergey Ivan")
    public void i_select_vip_checkbox_for_Sergey_Ivan() {
        userTablePage.clickCheckboxForIvan();
    }
}
