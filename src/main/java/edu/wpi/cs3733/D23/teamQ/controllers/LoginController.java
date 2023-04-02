package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {
  @FXML TextField usernameField;
  @FXML TextField passwordField;
  @FXML Button loginButton;
  @FXML Button FPButton;

  @FXML Button CAButton;

  @FXML Label IncorrectPasswordLabel;

  public void initialize() {}

  @FXML
  public void passwordFieldEntered(KeyEvent e) {
    if (e.getCode().equals(KeyCode.ENTER)) {
      loginButtonClicked();
    }
  }

  /**
   * Whenever the Enter key is pressed inside the username textfield, change the focus to the
   * password textfield.
   *
   * @param e A key pressed event received from the username textfield.
   */
  @FXML
  public void usernameFieldEntered(KeyEvent e) {
    if (e.getCode().equals(KeyCode.ENTER)) {
      passwordField.requestFocus();
      loginButtonClicked();
    }
  }

  @FXML
  public void loginButtonClicked() {
    if ((usernameField.getText().toLowerCase().equals("will"))
        && passwordField.getText().equals("Password")) Navigation.navigate(Screen.HOME);
    else IncorrectPasswordLabel.setOpacity(1);
  }

  @FXML
  public void FPButtonClicked() {
    System.out.println("Pops up a screen for resetting password.");
  }

  @FXML
  public void CreatAccountButtonClicked() {
    System.out.println("Create Account");
  }
}
