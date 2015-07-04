package org.fasttrackit.workshop.Menu;

import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;

public class MainMenuView {
    public static WebLink logoutLink = new WebLink().setText("Logout");
    public static Button preferencesButton = new Button().setText("Preferences");

   public static void logout() {
       logoutLink.assertClick();
   }
}
