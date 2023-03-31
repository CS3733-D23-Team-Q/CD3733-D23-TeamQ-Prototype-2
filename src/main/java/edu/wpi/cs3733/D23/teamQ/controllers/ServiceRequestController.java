package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.ServiceRequestData.ServiceRequestData;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckTreeItem;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class ServiceRequestController {
  @FXML private MFXTextField Assignee;
  @FXML private MFXTextField RoomNumber;
  @FXML private MFXTextField SpecialInstructions;

  @FXML private MFXButton ResetButton;
  @FXML private MFXButton ClearButton;
  @FXML private MFXButton SubmitButton;

  @FXML
  public void initialize() {
    this.ClearButton.setOnMouseClicked(
            event -> {
              Assignee.clear();
              RoomNumber.clear();
              SpecialInstructions.clear();
            });
    this.ResetButton.setOnMouseClicked(
            event -> Navigation.navigate(Screen.HOME));
    this.SubmitButton.setOnMouseClicked( event -> {
            ServiceRequestData newSR = new ServiceRequestData(Assignee.getText(), RoomNumber.getText(), SpecialInstructions.getText());
            Navigation.navigate(Screen.HOME);
    });
  }
}
