package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class ServiceRequestController {
  //  @FXML private MFXTextField Assignee;
  //  @FXML private MFXTextField RoomNumber;
  //  @FXML private MFXTextField SpecialInstructions;

  @FXML private MFXButton resetButton;
  @FXML private MFXButton backButton;
  @FXML private MFXButton submitButton;

  @FXML
  public void initialize() {
    //    this.ClearButton.setOnMouseClicked(
    //        event -> {
    //          Assignee.clear();
    //          RoomNumber.clear();
    //          SpecialInstructions.clear();
    //        });
    this.resetButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
    this.backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
    this.submitButton.setOnMouseClicked(
        event -> {
          //          ServiceRequestData newSR =
          //              new ServiceRequestData(
          //                  Assignee.getText(), RoomNumber.getText(),
          // SpecialInstructions.getText());
          Navigation.navigate(Screen.HOME);
        });
  }
}
