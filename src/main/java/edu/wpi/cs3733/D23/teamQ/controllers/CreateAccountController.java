package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.AlertBox;
import edu.wpi.cs3733.D23.teamQ.App;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import io.github.palexdev.materialfx.controls.*;
import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
  @FXML Label usernameAlert;
  @FXML ImageView usernameAlertImage;
  @FXML PasswordField passwordField;
  @FXML Label passwordAlert;
  @FXML ImageView passwordAlertImage;
  @FXML PasswordField repasswordField;
  @FXML Label CPAlert;
  @FXML ImageView CPAlertImage;
  @FXML TextField emailField;
  @FXML Label emailAlert;
  @FXML ImageView emailAlertImage;
  @FXML TextField answer1Field;
  @FXML Label a1Alert;
  @FXML ImageView a1AlertImage;
  @FXML TextField answer2Field;
  @FXML Label a2Alert;
  @FXML ImageView a2AlertImage;

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
        usernameAlert.setText("Please enter a username");
        usernameAlert.setStyle("-fx-text-fill: #AA3A47;");
        usernameAlertImage.setOpacity(1);
        break;
      case 1:
        usernameAlert.setText("");
        usernameAlert.setStyle(null);
        usernameAlertImage.setOpacity(0);
        emailReact(username, email, password, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        usernameAlert.setText("Please enter a username within the range 3-15");
        usernameAlert.setStyle("-fx-text-fill: #AA3A47;");
        usernameAlertImage.setOpacity(1);
        break;
      case 3:
        usernameAlert.setText("Invalid username. (special characters allowed: _ and - only)");
        usernameAlert.setStyle("-fx-text-fill: #AA3A47;");
        usernameAlertImage.setOpacity(1);
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
        emailAlert.setText("Please enter a email");
        emailAlert.setStyle("-fx-text-fill: #AA3A47;");
        emailAlertImage.setOpacity(1);
        break;
      case 1:
        emailAlert.setText("");
        emailAlert.setStyle(null);
        emailAlertImage.setOpacity(0);
        passwordReact(
            username, email, password, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        emailAlert.setText("Invalid email address");
        emailAlert.setStyle("-fx-text-fill: #AA3A47;");
        emailAlertImage.setOpacity(1);
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
        passwordAlert.setText("Please enter a password");
        passwordAlert.setStyle("-fx-text-fill: #AA3A47;");
        passwordAlertImage.setOpacity(1);
        break;
      case 1:
        // passwordField.setStyle(null);
        passwordAlert.setText("");
        passwordAlert.setStyle(null);
        passwordAlertImage.setOpacity(0);
        repasswordReact(
            username, email, password, repassword, question1, question2, answer1, answer2);
        break;
      case 2:
        passwordAlert.setText(
            "Please enter a password within the range 7-15 with at least one uppercase letter and one special character");
        passwordAlert.setStyle("-fx-text-fill: #AA3A47;");
        passwordAlertImage.setOpacity(1);
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
      CPAlert.setText("");
      CPAlert.setStyle(null);
      CPAlertImage.setOpacity(0);
      securityQReact1(
          username, email, password, repassword, question1, question2, answer1, answer2);
    } else {
      CPAlert.setText("Password doesn't match");
      CPAlert.setStyle("-fx-text-fill: #AA3A47;");
      CPAlertImage.setOpacity(1);
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
      alert.display("Failed to create an account", "Please select a question.");
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
      a1Alert.setText("Please enter a answer");
      a1Alert.setStyle("-fx-text-fill: #AA3A47;");
      a1AlertImage.setOpacity(1);
    } else {
      a1Alert.setText("");
      a1Alert.setStyle(null);
      a1AlertImage.setOpacity(0);
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
      a2Alert.setText("Please enter a answer");
      a2Alert.setStyle("-fx-text-fill: #AA3A47;");
      a2AlertImage.setOpacity(1);
    } else {
      a2Alert.setText("");
      a2Alert.setStyle(null);
      a2AlertImage.setOpacity(0);
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
      usernameAlert.setText("");
      usernameAlert.setStyle(null);
      usernameAlertImage.setOpacity(0);
      usernameReact(username, email, password, repassword, question1, question2, answer1, answer2);
    } else {
      usernameAlert.setText("Username already exist, try another one");
      usernameAlert.setStyle("-fx-text-fill: #AA3A47;");
      usernameAlertImage.setOpacity(1);
    }
  }
}
