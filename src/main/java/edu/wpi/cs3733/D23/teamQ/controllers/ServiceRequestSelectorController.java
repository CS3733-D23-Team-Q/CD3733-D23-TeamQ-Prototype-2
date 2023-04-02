package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class ServiceRequestSelectorController {
  @FXML private MFXButton goToCCRButton;
  @FXML private MFXButton goToMDButton;
  @FXML private MFXButton goToFrDButton;
  @FXML private MFXButton goToFeDButton;
  @FXML private MFXButton goToOSPButton;
  @FXML private MFXButton homeButton;

  public void initialize() {
    this.goToCCRButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.CONFERENCE_ROOM_REQUEST);
        });
    this.goToMDButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.MEAL_REQUEST);
        });
    this.goToFrDButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.FLOWER_REQUEST);
        });
    this.goToFeDButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.FURNITURE_REQUEST);
        });
    this.goToOSPButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.OFFICE_SUPPLIES_REQUEST);
        });
    this.homeButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.HOME);
        });
  }
}
