package hw8.pages.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw8.entities.User;

public class LoginForm extends Form<User> {

    @Css("#name")
    public TextField login;

    @Css("#password")
    public TextField password;

    @Css("#login-button")
    public Button submit;

}
