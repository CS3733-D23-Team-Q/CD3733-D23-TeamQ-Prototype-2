package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.Alert;
import edu.wpi.cs3733.D23.teamQ.Confirm;
import edu.wpi.cs3733.D23.teamQ.SecondaryStage;
import edu.wpi.cs3733.D23.teamQ.db.Qdb;
import edu.wpi.cs3733.D23.teamQ.db.impl.QuestionDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import edu.wpi.cs3733.D23.teamQ.db.obj.Question;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class ForgotPasswordController extends SecondaryStage implements IController {

  CreateAccountController CAController = new CreateAccountController();
  Qdb qdb = Qdb.getInstance();
  Alert alert = new Alert();
  Confirm confirm = new Confirm();
  @FXML ChoiceBox<String> questionChoice1;
  @FXML ChoiceBox<String> questionChoice2;
  @FXML TextField usernameField;
  @FXML Label usernameAlert;
  @FXML ImageView usernameAlertImage;
  @FXML TextField answer1Field;
  @FXML TextField answer2Field;
  @FXML PasswordField NPField;
  @FXML Label NPAlert;
  @FXML ImageView NPAlertImage;
  @FXML PasswordField CPField;
  @FXML Label CPAlert;
  @FXML ImageView CPAlertImage;
  @FXML Button CPButton;

  public static void display() throws IOException {
    display(Screen.FORGOT_PASSWORD);
  }

  @FXML
  public void initialize() {

    List<Question> questions = qdb.questionTable.getAllRows();
    for (int i = 0; i < questions.size(); i++) {
      String question = questions.get(i).getQuestion();
      questionChoice1.getItems().add(question);
    }
    for (int i = 0; i < questions.size(); i++) {
      String question = questions.get(i).getQuestion();
      questionChoice2.getItems().add(question);
    }
  }

  public void newPasswordReact(
      String username, String newPassword, String repassword, String answer1, String answer2)
      throws IOException, SQLException {
    Account a = qdb.accountTable.retrieveRow(username);
    String oldPassword = a.getPassword();
    if (oldPassword.equals(newPassword)) {
      alert.setLabelAlert(
          "Please enter a different password from the old one", NPAlert, NPAlertImage);
    } else {
      alert.clearLabelAlert(NPAlert, NPAlertImage);
      passwordReact(username, newPassword, repassword, answer1, answer2);
    }
  }

  public void passwordReact(
      String username, String newPassword, String repassword, String answer1, String answer2)
      throws IOException, SQLException {
    switch (CAController.validPassword(newPassword)) {
      case 0:
        alert.setLabelAlert("Please enter a password", NPAlert, NPAlertImage);
        break;
      case 1:
        alert.clearLabelAlert(NPAlert, NPAlertImage);
        repasswordReact(username, newPassword, repassword, answer1, answer2);
        break;
      case 2:
        alert.setLabelAlert(
            "Please enter a password within the range 7-15 with at least one uppercase letter and one special character",
            NPAlert,
            NPAlertImage);
        break;
    }
  }

  public void repasswordReact(
      String username, String newPassword, String repassword, String answer1, String answer2)
      throws IOException, SQLException {
    if (newPassword.equals(repassword)) {
      alert.clearLabelAlert(CPAlert, CPAlertImage);
      securityQAReact(username, newPassword, repassword, answer1, answer2);
    } else {
      alert.setLabelAlert("Password doesn't match", CPAlert, CPAlertImage);
    }
  }

  public void securityQAReact(
      String username, String newPassword, String repassword, String answer1, String answer2)
      throws IOException, SQLException {
    String question1 = questionChoice1.getValue();
    String question2 = questionChoice2.getValue();
    QuestionDAOImpl questionTable1 = (QuestionDAOImpl) qdb.questionTable;
    int question1id = questionTable1.retrieveRow(question1).getId();
    int question2id = questionTable1.retrieveRow(question2).getId();
    Account a = qdb.accountTable.retrieveRow(username);
    int actualq1 = a.getSecurityQuestion1();
    int actualq2 = a.getSecurityQuestion2();
    String actuala1 = a.getSecurityAnswer1();
    String actuala2 = a.getSecurityAnswer2();
    if (question1id == actualq1
        && question2id == actualq2
        && answer1.equals(actuala1)
        && answer2.equals(actuala2)) {
      answer1Field.setStyle(null);
      answer2Field.setStyle(null);
      a.setPassword(newPassword);
      qdb.accountTable.updateRow(username, a);
      Navigation.navigate(Screen.LOGIN);
      super.stage.setScene(
          confirm.getScene(super.stage, "Confirmation", "Password reset successful!"));
      super.stage.centerOnScreen();
    } else {
      answer1Field.setStyle("-fx-text-box-border: #AA3A47;");
      answer2Field.setStyle("-fx-text-box-border: #AA3A47;");
      alert.alertBox("Failed to reset password", "One or more answers are wrong.");
    }
  }

  public void CPButtonClicked() throws IOException, SQLException {
    String username = usernameField.getText();
    String newPassword = NPField.getText();
    String repassword = CPField.getText();
    String answer1 = answer1Field.getText();
    String answer2 = answer2Field.getText();
    QuestionDAOImpl questionTable1 = (QuestionDAOImpl) qdb.questionTable;
    if (questionTable1.getIndex(username) != -1) {
      alert.clearLabelAlert(usernameAlert, usernameAlertImage);
      newPasswordReact(username, newPassword, repassword, answer1, answer2);
    } else {
      alert.setLabelAlert("Username doesn't exist", usernameAlert, usernameAlertImage);
    }
  }
}
