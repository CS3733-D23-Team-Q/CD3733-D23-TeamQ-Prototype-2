package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.AlertBox;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.*;
import java.io.IOException;
import javafx.application.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class ForgotPasswordController {
  AccountDAOImpl dao = new AccountDAOImpl();
  AlertBox alert = new AlertBox();
  @FXML ChoiceBox questionChoice1;
  @FXML ChoiceBox questionChoice2;
  @FXML TextField usernameField;
  @FXML TextField answer1Field;
  @FXML TextField answer2Field;
  @FXML TextField NPField;
  @FXML TextField CPField;
  @FXML Button CPButton;

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

  public void CPButtonClicked() throws IOException {
    String username = usernameField.getText();
    String newPassword = NPField.getText();
    String repassword = CPField.getText();
    int question1 = dao.getQuestionId((String) questionChoice1.getValue());
    int question2 = dao.getQuestionId((String) questionChoice2.getValue());
    String answer1 = answer1Field.getText();
    String answer2 = answer2Field.getText();
    if (dao.usernameExist(username)) {
      Account a = dao.getAccountFromUsername(username);
      if (newPassword.equals(repassword)) {
        if (question1 == a.getSecurityQuestion1()
            && question2 == a.getSecurityQuestion2()
            && answer1.equals(a.getSecurityAnswer1())
            && answer2.equals(a.getSecurityAnswer2())) {
          dao.updatePassword(username, newPassword);
          Navigation.navigate(Screen.LOGIN);
          alert.display("Confirmation", "Password reset successful!");
        } else {
          answer1Field.setStyle("-fx-text-box-border: red;");
          answer2Field.setStyle("-fx-text-box-border: red;");
          alert.display("Failed to reset password", "One or more answers are wrong.");
        }
      } else {
        NPField.setStyle("-fx-text-box-border: red;");
        CPField.setStyle("-fx-text-box-border: red;");
        usernameField.setStyle(null);
        alert.display("Failed to reset password", "Password doesn't match.");
      }
    } else {
      usernameField.setStyle("-fx-text-box-border: red;");
      NPField.setStyle(null);
      CPField.setStyle(null);
      alert.display("Failed to reset password", "Username doesn't exist.");
    }
  }
}
