package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.Menu.MainMenuView;
import org.fasttrackit.workshop.Preferences.PreferencesWindow;

public class PreferencesSteps extends TestBase {

    public static final String newPass = "eu.p";
    private PreferencesWindow preferencesWindow = new PreferencesWindow();

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button()  {
        preferencesWindow.open();
    }

    @And("^I input current password$")
    public void I_input_current_password()  {
        preferencesWindow.typeCurrentPassword(LoginSteps.VALID_PASS);
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferencesWindow.typeNewPassword(newPass);
    }

    @And("^I confirm the new password$")
    public void I_confirm_the_new_password() {
        preferencesWindow.typeConfirmPass(newPass);
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button()  {
        preferencesWindow.clickSaveButton();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String message)  {
        preferencesWindow.seeMessage(message);
        LoginSteps.VALID_PASS = newPass;
    }

    @And("^I close Preferences window$")
    public void I_close_Preferences_window()  {
        preferencesWindow.close();
    }

    @And("^I logout$")
    public void I_logout() {
        preferencesWindow.logout();
    }
}
