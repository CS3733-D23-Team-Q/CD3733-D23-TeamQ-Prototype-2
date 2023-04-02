package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.AlertBox;
import edu.wpi.cs3733.D23.teamQ.App;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateAccountController {
  static Stage secondaryStage;
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

  public static void display() throws IOException {
    secondaryStage = new Stage();
    secondaryStage.initModality(Modality.APPLICATION_MODAL);
    secondaryStage.setTitle("Create Account");

    final FXMLLoader loader = new FXMLLoader(App.class.getResource("views/CreateAccount.fxml"));
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

  public int validEmail(String email) {
    int result = 0;
    Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
    if (email.length() < 1) {
      result = 0;
    } else if (pattern.matcher(email).matches()) {
      result = 1;
    } else {
      result = 2;
    }
    return result;
  }

  public int validUsername(String uname) {
    int result = 0;
    Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
    if (uname.length() < 1) {
      result = 0;
    } else if (pattern.matcher(uname).matches()) {
      result = 1;
    } else {
      if (uname.length() < 3 || uname.length() > 15) {
        result = 2;
      } else {
        result = 3;
      }
    }
    return result;
  }

  public int validPassword(String password) {
    int result = 0;
    Pattern pattern =
        Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=]).{7,15}$");
    if (password.length() < 1) {
      result = 0;
    } else if (pattern.matcher(password).matches()) {
      result = 1;
    } else {
      result = 2;
    }
    return result;
  }

  public void usernameReact(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    switch (validUsername(username)) {
      case 0:
        usernameField.setStyle("-fx-text-box-border: red;");
        alert.display("Failed to create an account", "Please enter a username.");
        break;
      case 1:
        usernameField.setStyle(null);
        emailReact(username, email, password, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        usernameField.setStyle("-fx-text-box-border: red;");
        alert.display(
            "Failed to create an account", "Please enter a username within the range 3-15.");
        break;
      case 3:
        usernameField.setStyle("-fx-text-box-border: red;");
        alert.display(
            "Failed to create an account",
            "Invalid username. (special characters allowed: _ and - only)");
        break;
    }
  }

  public void emailReact(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    switch (validEmail(email)) {
      case 0:
        emailField.setStyle("-fx-text-box-border: red;");
        alert.display("Failed to create an account", "Please enter a email.");
        break;
      case 1:
        emailField.setStyle(null);
        passwordReact(
            username, email, password, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        emailField.setStyle("-fx-text-box-border: red;");
        alert.display("Failed to create an account", "Invalid email.");
        break;
    }
  }

  public void passwordReact(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    switch (validPassword(password)) {
      case 0:
        passwordField.setStyle("-fx-text-box-border: red;");
        alert.display("Failed to create an account", "Please enter a password.");
        break;
      case 1:
        passwordField.setStyle(null);
        repasswordReact(
            username, email, password, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        passwordField.setStyle("-fx-text-box-border: red;");
        alert.display(
            "Failed to create an account",
            "Please enter a password within the range 7-15 with at least one uppercase letter and one special character.");
        break;
    }
  }

  public void repasswordReact(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    if (password.equals(repassword)) {
      repasswordField.setStyle(null);
      securityQReact1(
          username, email, password, repassword, question1, question2, answer1, answer2);
    } else {
      repasswordField.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to create an account", "Password doesn't match.");
    }
  }

  public void securityQReact1(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    if (questionChoice1.getSelectionModel().isEmpty()) {
      alert.display("Failed to create an account", "Password select a question.");
    } else {
      securityAReact1(
          username, email, password, repassword, question1, question2, answer1, answer2);
    }
  }

  public void securityAReact1(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    if (answer1.length() < 1) {
      answer1Field.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to create an account", "Please enter a answer.");
    } else {
      answer1Field.setStyle(null);
      securityQReact2(
          username, email, password, repassword, question1, question2, answer1, answer2);
    }
  }

  public void securityQReact2(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    if (questionChoice2.getSelectionModel().isEmpty()) {
      alert.display("Failed to create an account", "Please select a question.");
    } else if (question2.equals(question1)) {
      alert.display("Failed to create an account", "Please choose a different question.");
    } else {
      securityAReact2(
          username, email, password, repassword, question1, question2, answer1, answer2);
    }
  }

  public void securityAReact2(
      String username,
      String email,
      String password,
      String repassword,
      String question1,
      String question2,
      String answer1,
      String answer2)
      throws IOException {
    if (answer2.length() < 1) {
      answer2Field.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to create an account", "Please enter a answer.");
    } else {
      answer2Field.setStyle(null);
      dao.addUser(
          username,
          password,
          email,
          dao.getQuestionId(question1),
          dao.getQuestionId(question2),
          answer1,
          answer2);
      secondaryStage.setScene(
          alert.getScene(secondaryStage, "Confirmation", "Account created successful!"));
      secondaryStage.centerOnScreen();
    }
  }

  @FXML
  public void SUButtonClicked() throws IOException {
    String username = usernameField.getText();
    String email = emailField.getText();
    String password = passwordField.getText();
    String repassword = repasswordField.getText();
    String question1 = questionChoice1.getValue();
    String question2 = questionChoice2.getValue();
    String answer1 = answer1Field.getText();
    String answer2 = answer2Field.getText();

    if (!dao.usernameExist(username)) {
      usernameField.setStyle(null);
      usernameReact(username, email, password, repassword, question1, question2, answer1, answer2);
    } else {
      usernameField.setStyle("-fx-text-box-border: red;");
      alert.display("Failed to create an account", "Username already exist. Try another one.");
    }
  }
}
