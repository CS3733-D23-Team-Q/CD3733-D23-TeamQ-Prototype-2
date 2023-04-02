package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.AlertBox;
import edu.wpi.cs3733.D23.teamQ.App;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ForgotPasswordController {
  static Stage secondaryStage;
  AccountDAOImpl dao = new AccountDAOImpl();
  CreateAccountController cac = new CreateAccountController();
  AlertBox alert = new AlertBox();
  @FXML ChoiceBox questionChoice1;
  @FXML ChoiceBox questionChoice2;
  @FXML TextField usernameField;
  @FXML TextField answer1Field;
  @FXML TextField answer2Field;
  @FXML TextField NPField;
  @FXML TextField CPField;
  @FXML Button CPButton;

  public static void display() throws IOException {
    secondaryStage = new Stage();
    secondaryStage.initModality(Modality.APPLICATION_MODAL);
    secondaryStage.setTitle("Forgot Password");

    final FXMLLoader loader = new FXMLLoader(App.class.getResource("views/ForgotPassword.fxml"));
    final VBox root = loader.load();

    final Scene scene = new Scene(root);

    scene
        .getStylesheets()
        .add(
            Navigation.class
                .getResource("/edu/wpi/cs3733/D23/teamQ/views/styles/Home.css")
                .toExternalForm());

    secondaryStage.setScene(scene);
    secondaryStage.show();
  }

  @FXML
  public void initialize() {
    questionChoice1.getItems().add(dao.getQuestions().get(0));
    questionChoice1.getItems().add(dao.getQuestions().get(1));
    questionChoice1.getItems().add(dao.getQuestions().get(2));
    questionChoice1.getItems().add(dao.getQuestions().get(3));
    questionChoice1.getItems().add(dao.getQuestions().get(4));
    questionChoice2.getItems().add(dao.getQuestions().get(0));
    questionChoice2.getItems().add(dao.getQuestions().get(1));
    questionChoice2.getItems().add(dao.getQuestions().get(2));
    questionChoice2.getItems().add(dao.getQuestions().get(3));
    questionChoice2.getItems().add(dao.getQuestions().get(4));
  }

  public void newPasswordReact(
      String username,
      String newPassword,
      String repassword,
      int question1,
      int question2,
      String answer1,
      String answer2)
      throws IOException {
    Account a = dao.getAccountFromUsername(username);
    String oldPassword = a.getPassword();
    if (newPassword.length() < 1) {
      NPField.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to reset password", "Please enter a password.");
    } else if (oldPassword.equals(newPassword)) {
      NPField.setStyle("-fx-text-box-border: red;");
      alert.display(
          "Failed to reset password", "Please enter a different password from the old one.");
    } else {
      NPField.setStyle(null);
      passwordReact(username, newPassword, repassword, question1, question2, answer1, answer2);
    }
  }

  public void passwordReact(
      String username,
      String newPassword,
      String repassword,
      int question1,
      int question2,
      String answer1,
      String answer2)
      throws IOException {
    switch (cac.validPassword(newPassword)) {
      case 0:
        NPField.setStyle("-fx-text-box-border: red;");
        alert.display("Failed to create an account", "Please enter a password.");
        break;
      case 1:
        NPField.setStyle(null);
        repasswordReact(username, newPassword, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        NPField.setStyle("-fx-text-box-border: red;");
        alert.display(
            "Failed to create an account",
            "Please enter a password within the range 7-15 with at least one uppercase letter and one special character.");
        break;
    }
  }

  public void repasswordReact(
      String username,
      String newPassword,
      String repassword,
      int question1,
      int question2,
      String answer1,
      String answer2)
      throws IOException {
    if (newPassword.equals(repassword)) {
      CPField.setStyle(null);
      securityQAReact(username, newPassword, repassword, question1, question2, answer1, answer2);
    } else {
      CPField.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to reset password", "Password doesn't match.");
    }
  }

  public void securityQAReact(
      String username,
      String newPassword,
      String repassword,
      int question1,
      int question2,
      String answer1,
      String answer2)
      throws IOException {
    Account a = dao.getAccountFromUsername(username);
    int actualq1 = a.getSecurityQuestion1();
    int actualq2 = a.getSecurityQuestion2();
    String actuala1 = a.getSecurityAnswer1();
    String actuala2 = a.getSecurityAnswer2();
    if (question1 == actualq1
        && question2 == actualq2
        && answer1.equals(actuala1)
        && answer2.equals(actuala2)) {
      answer1Field.setStyle(null);
      answer2Field.setStyle(null);
      dao.updatePassword(username, newPassword);
      Navigation.navigate(Screen.LOGIN);
      secondaryStage.setScene(
          alert.getScene(secondaryStage, "Confirmation", "Password reset successful!"));
      secondaryStage.centerOnScreen();
    } else {
      answer1Field.setStyle("-fx-text-box-border: red;");
      answer2Field.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to reset password", "One or more answers are wrong.");
    }
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
      usernameField.setStyle(null);
      newPasswordReact(username, newPassword, repassword, question1, question2, answer1, answer2);
    } else {
      usernameField.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to reset password", "Username doesn't exist.");
    }
  }
}
