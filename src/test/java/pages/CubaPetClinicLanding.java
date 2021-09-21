package pages;

import com.codeborne.selenide.SelenideElement;
import config.Environment;
import helpers.PageUtilities;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CubaPetClinicLanding {

    public CubaPetClinicLanding() {

    }
    private final Logger logger = LoggerFactory.getLogger(CubaPetClinicLanding.class);
    private Environment env = new Environment();

    private final SelenideElement usernameField = $(byId("gwt-uid-4"));
    private final SelenideElement passWordField = $(byName("passwordField"));
    private final SelenideElement rememberMeButton = $(byId("gwt-uid-2"));
    private final SelenideElement title = $(byClassName("v-label-c-app-title"));

    private final SelenideElement loginButton = $(byClassName("c-login-button"));

    @Step("Performing a google search")
    public void logIn(String webUrl, String username, String password){
        open(webUrl);
        enterCredentials(username, password);

    }

    private void enterCredentials(String username,String password) {
        PageUtilities.clearFieldAndSetValue(usernameField,username);
        PageUtilities.clearFieldAndSetValue(passWordField,password);
        loginButton.click();
    }
}
