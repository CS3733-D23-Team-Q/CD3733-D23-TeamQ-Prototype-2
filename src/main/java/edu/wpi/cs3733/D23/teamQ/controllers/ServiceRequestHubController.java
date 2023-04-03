package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import java.awt.*;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class ServiceRequestHubController {
  @FXML private Button goToCCRButton;
  @FXML private Button goToMDButton;
  @FXML private Button goToFRDButton;
  @FXML private Button goToFEDButton;
  @FXML private Button goToOSPButton;
  @FXML private Button goToPTButton;
  @FXML private Button homeButton;
  @FXML MenuItem exit;
  @FXML MenuItem home;

  @FXML
  public void initialize() {}

  @FXML
  public void exitMenuClicked() {
    Platform.exit();
  }

  @FXML
  public void CCRButton() {
    Navigation.navigate(Screen.CONFERENCE_ROOM_REQUEST);
  }

  @FXML
  public void MDButton() {
    Navigation.navigate(Screen.MEAL_REQUEST);
  }

  @FXML
  public void FRDButton() {
    Navigation.navigate(Screen.FLOWER_REQUEST);
  }

  @FXML
  public void FEDButton() {
    Navigation.navigate(Screen.FURNITURE_REQUEST);
  }

  @FXML
  public void OSPButton() {
    Navigation.navigate(Screen.OFFICE_SUPPLIES_REQUEST);
  }

  @FXML
  public void PTButton() {
    Navigation.navigate(Screen.PATIENT_TRANSPORT_REQUEST);
  }

  @FXML
  public void home() {
    Navigation.navigate(Screen.HOME);
  }
}
