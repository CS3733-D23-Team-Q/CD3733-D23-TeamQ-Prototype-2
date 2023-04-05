package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.impl.PersonDaoImpl;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfilePageController {
    PersonDaoImpl dao = new PersonDaoImpl();
    @FXML private Button Edit_Profile;

    @FXML private Label Email_Display;

    @FXML private Label First_Name_Display;

    @FXML private Label ID_Number_Display;

    @FXML private Label Last_Name_Display;

    @FXML private Label Phone_Number_Display;

    @FXML private Label Title_Display;

    @FXML private Label Username_Display;

    @FXML
    private void initialize() {
        // DO ONE FOR PROFILE IMAGE AS WELL NEXT TIME
        String username = LoginController.getLoginUsername();

        String email = LoginController.getLoginEmail();
        this.Title_Display.setText(dao.getPersonWithUsername(username).getTitle());


        this.ID_Number_Display.setText(String.valueOf(dao.getPersonWithUsername(username).getIDNum()));
        this.First_Name_Display.setText(dao.getPersonWithUsername(username).getFirstName());
        this.Last_Name_Display.setText(dao.getPersonWithUsername(username).getLastName());
        this.Email_Display.setText(email);
        this.Title_Display.setText(dao.getPersonWithUsername(username).getTitle());
        this.Phone_Number_Display.setText(String.valueOf(dao.getPersonWithUsername(username).getPhoneNumber()));
        this.Username_Display.setText(username);

        this.Edit_Profile.setOnMouseClicked(event -> Navigation.navigate(Screen.PROFILE_PAGE));
    }
}

