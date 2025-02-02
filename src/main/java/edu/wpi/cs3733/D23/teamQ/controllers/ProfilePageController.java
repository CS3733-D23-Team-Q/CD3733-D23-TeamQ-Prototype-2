package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.Qdb;
import edu.wpi.cs3733.D23.teamQ.db.impl.PersonDaoImpl;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfilePageController {

  Qdb qdb = Qdb.getInstance();

  @FXML private Button Edit_Profile;

  @FXML private Label Email_Display;

  @FXML private Label First_Name_Display;

  @FXML private Label ID_Number_Display;

  @FXML private Label Last_Name_Display;

  @FXML private Label Phone_Number_Display;

  @FXML private Label Title_Display;

  @FXML private Label Username_Display;
  @FXML private Button ProfilePage_Home_Button;

  @FXML
  private void initialize() {
    // DO ONE FOR PROFILE IMAGE AS WELL NEXT TIME
    String username = LoginController.getLoginUsername();

    String email = LoginController.getLoginEmail();

    PersonDaoImpl person = (PersonDaoImpl) qdb.personTable;

    this.ID_Number_Display.setText(
        String.valueOf(person.getPersonWithUsername(username).getIDNum()));
    if (person.getPersonWithUsername(username).getFirstName() == null) {
      this.First_Name_Display.setText("empty");
    } else {
      this.First_Name_Display.setText(person.getPersonWithUsername(username).getFirstName());
    }
    if (person.getPersonWithUsername(username).getLastName() == null) {
      this.Last_Name_Display.setText("empty");
    } else {
      this.Last_Name_Display.setText(person.getPersonWithUsername(username).getLastName());
    }
    this.Email_Display.setText(email);
    if (person.getPersonWithUsername(username).getTitle() == null) {
      this.Title_Display.setText("empty");
    } else {
      this.Title_Display.setText(person.getPersonWithUsername(username).getTitle());
    }
    if (person.getPersonWithUsername(username).getPhoneNumber() == 0) {
      this.Phone_Number_Display.setText("empty");
    } else {
      this.Phone_Number_Display.setText(
          String.valueOf(person.getPersonWithUsername(username).getPhoneNumber()));
    }

    this.Username_Display.setText(username);

    this.Edit_Profile.setOnMouseClicked(event -> Navigation.navigate(Screen.EDIT_PROFILE));
    this.ProfilePage_Home_Button.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
