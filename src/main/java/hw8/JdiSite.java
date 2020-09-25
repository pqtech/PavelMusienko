package hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw8.entities.User;
import hw8.pages.HomePage;
import hw8.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        HomePage.login(user);
    }
}
