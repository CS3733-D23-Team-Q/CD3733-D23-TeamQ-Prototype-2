package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.AlertBox;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {
  AlertBox alert = new AlertBox();
  @FXML TextField usernameField;
  @FXML TextField passwordField;
  @FXML Button loginButton;
  @FXML Button FPButton;

  @FXML Button CAButton;

  @FXML
  public void initialize() {}

  @FXML
  public void passwordFieldEntered(KeyEvent e) {
    if (e.getCode().equals(KeyCode.ENTER)) {
      System.out.println("Navigate to a logged in screen or pops up a failed to login screen.");
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
    }
  }

  public boolean isEmail(String uname) {
    boolean email = false;
    Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
    if (pattern.matcher(uname).matches()) {
      email = true;
    }
    return email;
  }

  @FXML
  public void loginButtonClicked() throws IOException {
    String username = usernameField.getText();
    String password = passwordField.getText();
    AccountDAOImpl dao = new AccountDAOImpl();
    if (dao.usernameExist(username)) {
      Account a = dao.getAccountFromUsername(username);
      if (a.getPassword().equals(password)) {
        Navigation.navigate(Screen.HOME);
      } else {
        passwordField.setStyle("-fx-text-box-border: red;");
        alert.display("Failed to login", "Wrong password.");
      }
    } else if (dao.emailExist(username)) {
      List<Account> as = dao.getAccountFromEmail(username);
      for (Account a : as) {
        if (a.getPassword().equals(password)) {
          Navigation.navigate(Screen.HOME);
        } else {
          passwordField.setStyle("-fx-text-box-border: red;");
          alert.display("Failed to login", "Wrong password.");
        }
      }
    } else {
      passwordField.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to login", "Username doesn't exist.");
    }
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
