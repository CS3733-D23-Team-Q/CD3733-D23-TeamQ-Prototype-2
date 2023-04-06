package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignageController implements IController {

  @FXML private Button BackHomeBTN;

  /** initialize the BackHomeBTN, Navigate to the home page when the button is clicked. */
  @FXML
  public void initialize() {
    BackHomeBTN.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
