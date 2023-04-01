package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.AlertBox;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateAccountController {

  AccountDAOImpl dao = new AccountDAOImpl();
  AlertBox alert = new AlertBox();
  @FXML ChoiceBox<String> questionChoice1 = new ChoiceBox<>();
  @FXML ChoiceBox<String> questionChoice2 = new ChoiceBox<>();
  @FXML TextField usernameField;
  @FXML TextField passwordField;
  @FXML TextField repasswordField;
  @FXML TextField emailField;
  @FXML TextField answer1Field;
  @FXML TextField answer2Field;
  @FXML Button SUButton;

  @FXML
  public void initialize() {
    questionChoice1.getItems().add("What is your date of birth?");
    questionChoice1.getItems().add("What is your favorite color?");
    questionChoice1.getItems().add("What is your first pet's name?");
    questionChoice1.getItems().add("Where is your home town?");
    questionChoice1.getItems().add("What college did you attend?");
    questionChoice2.getItems().add("What is your date of birth?");
    questionChoice2.getItems().add("What is your favorite color?");
    questionChoice2.getItems().add("What is your first pet's name?");
    questionChoice2.getItems().add("Where is your home town?");
    questionChoice2.getItems().add("What college did you attend?");
  }

  @FXML
  public void SUButtonClicked() throws IOException {
    String username = usernameField.getText();
    String password = passwordField.getText();
    String repassword = repasswordField.getText();
    String email = emailField.getText();
    String question1 = questionChoice1.getValue();
    String question2 = questionChoice2.getValue();
    String answer1 = answer1Field.getText();
    String answer2 = answer2Field.getText();

    if (!dao.usernameExist(username)) {
      if (password.equals(repassword)) {
        dao.addUser(
            username,
            password,
            email,
            dao.getQuestionId(question1),
            dao.getQuestionId(question2),
            answer1,
            answer2);
        Navigation.navigate(Screen.LOGIN);
        alert.display("Confirmation", "Account created successful!");
      } else {
        passwordField.setStyle("-fx-text-box-border: red;");
        repasswordField.setStyle("-fx-text-box-border: red;");
        usernameField.setStyle(null);
        alert.display("Failed to create an account", "Password doesn't match.");
      }
    } else {
      usernameField.setStyle("-fx-text-box-border: red;");
      passwordField.setStyle(null);
      alert.display("Failed to create an account", "Username already exist. Try another one.");
    }
  }
}
