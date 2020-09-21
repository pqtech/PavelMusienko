package hw8.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw8.entities.User;
import hw8.pages.forms.LoginForm;

public class HomePage extends WebPage {

    public static LoginForm loginForm;

    @Css("#user-icon")
    public static Icon userIcon;

    @FindBy(id = "user-name")
    public static Label userName;

    @FindBy(linkText = "Metals & Colors")
    private Button metalsColorsPageButton;

    public static void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void openMetalsColorsPage() {
        metalsColorsPageButton.click();
    }
}
