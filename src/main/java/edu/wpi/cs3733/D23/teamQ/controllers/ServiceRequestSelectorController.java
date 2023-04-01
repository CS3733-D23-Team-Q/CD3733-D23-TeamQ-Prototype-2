package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import lombok.Getter;

public class ServiceRequestSelectorController {
  @FXML private MFXButton goToCCRButton;
  @FXML private MFXButton goToMDButton;
  @FXML private MFXButton goToFrDButton;
  @FXML private MFXButton goToFeDButton;
  @FXML private MFXButton goToOSPButton;
  @FXML private MFXButton homeButton;
  @Getter private static int srNum = 0;

  public void initialize() {
    this.goToCCRButton.setOnMouseClicked(
        event -> {
          srNum = 1;
          Navigation.navigate(Screen.SERVICE_REQUEST);
        });
    this.goToMDButton.setOnMouseClicked(
        event -> {
          srNum = 2;
          Navigation.navigate(Screen.SERVICE_REQUEST);
        });
    this.goToFrDButton.setOnMouseClicked(
        event -> {
          srNum = 3;
          Navigation.navigate(Screen.SERVICE_REQUEST);
        });
    this.goToFeDButton.setOnMouseClicked(
        event -> {
          srNum = 4;
          Navigation.navigate(Screen.SERVICE_REQUEST);
        });
    this.goToOSPButton.setOnMouseClicked(
        event -> {
          srNum = 5;
          Navigation.navigate(Screen.SERVICE_REQUEST);
        });
    this.homeButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.HOME);
        });
  }
}
