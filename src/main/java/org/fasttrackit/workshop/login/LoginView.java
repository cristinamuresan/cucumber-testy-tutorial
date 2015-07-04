package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator email = new WebLocator().setId("email");

    private WebLocator loginButton = new WebLocator().setId("loginButton");

    private WebLocator password = new WebLocator().setId("password");

    private WebLocator error = new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterCredentials(String emailValue, String passValue) {
        System.out.println("emailul este: " + emailValue);
        email.sendKeys(emailValue);
        System.out.println("parola este: " + passValue);
        password.sendKeys(passValue);
    }

    public void errorMessage(String expectedMessage) {
        assertThat(error.getHtmlText(), is(expectedMessage));
    }
}
