package org.fasttrackit.workshop.Preferences;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.workshop.Menu.MainMenuView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PreferencesWindow {

    private WebLocator window = new WebLocator().setId("preferences-win");

    private Button preferencesButton = new Button().setText("Preferences");

    private TextField currentPassword = new TextField(window).setLabel("Current Password");
    private TextField newPassword = new TextField(window).setLabel("New Password");
    private TextField confirmNewPassword = new TextField(window).setLabel("Repeat Password");
    private Button saveButton = new Button(window).setText("Save");
    private Button closeButton = new Button(window).setText("Close");           //toate elementele de mai sus se afla in fereastra
                                                                                //preferences == set.Container(window)
    private WebLocator statusMessage = new WebLocator(window).setClasses("status-msg");

    public static void main(String[] args) {
        PreferencesWindow preferencesWindow = new PreferencesWindow();
        System.out.println(preferencesWindow.window.getPath());  //adresa window-ului
        System.out.println(preferencesWindow.closeButton.getPath());  //adresa butonului
    }

    public void open() {
        MainMenuView.preferencesButton.assertClick();
        Utils.sleep(1000);  //because of fading window
    }

    public void typeCurrentPassword(String password) {
        currentPassword.setValue(password);
        Utils.sleep(1000);   //because of fading window
    }

    public void typeNewPassword(String password) {
        newPassword.setValue(password);
    }

    public void typeConfirmPass(String password) {
        confirmNewPassword.setValue(password);
    }

    public void clickSaveButton() {
        saveButton.assertClick();
    }

    public void seeMessage(String expectedMessage) {
        assertThat(statusMessage.getHtmlText(), is(expectedMessage));
    }

    public void close() {
        closeButton.assertClick();
        Utils.sleep(1000);  //because of fading window
    }

    public void logout() {
        MainMenuView.logout();
    }
}
