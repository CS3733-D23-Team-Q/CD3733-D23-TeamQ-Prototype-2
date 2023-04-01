package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import edu.wpi.cs3733.D23.teamQ.servicerequestdata.ConferenceRoomRequestData;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ConferenceRoomRequestController {
  ObservableList<String> foodOptionsList =
      FXCollections.observableArrayList(
          "Brunch spread", "Dinner spread", "Snack spread", "No food");
  @FXML private MFXButton ConferenceRoomRequest_ClearButton;
  @FXML private MFXButton ConferenceRoomRequest_CancelButton;
  @FXML private MFXButton ConferenceRoomRequest_SubmitButton;
  @FXML private MFXTextField ConferenceRoomRequest_LocationField;
  @FXML private MFXTextField ConferenceRoomRequest_ScheduleField;
  @FXML private MFXCheckbox ConferenceRoomRequest_CleaningField;
  private boolean cleanRoom = false;
  @FXML private ChoiceBox ConferenceRoomRequest_FoodField;
  @FXML private MFXTextField ConferenceRoomRequest_InstructionsField;

  /** Function to initalize all button on the conference room request page */
  @FXML
  private void initialize() {
    this.ConferenceRoomRequest_FoodField.setValue("No food");
    this.ConferenceRoomRequest_FoodField.setItems(foodOptionsList);
    this.ConferenceRoomRequest_ClearButton.setOnMouseClicked(
        event -> {
          ConferenceRoomRequest_LocationField.clear();
          ConferenceRoomRequest_ScheduleField.clear();
          ConferenceRoomRequest_InstructionsField.clear();
          ConferenceRoomRequest_FoodField.setValue("No food");
          ConferenceRoomRequest_CleaningField.setSelected(false);
          ConferenceRoomRequest_CleaningField.setIndeterminate(false);
          cleanRoom = false;
        });
    this.ConferenceRoomRequest_CancelButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.HOME);
        });
    this.ConferenceRoomRequest_SubmitButton.setOnMouseClicked(
        event -> {
          ConferenceRoomRequestData newCCR =
              new ConferenceRoomRequestData(
                  "Temp User",
                  ConferenceRoomRequest_LocationField.getText(),
                  ConferenceRoomRequest_InstructionsField.getText(),
                  ConferenceRoomRequest_ScheduleField.getText(),
                  cleanRoom,
                  (String) ConferenceRoomRequest_FoodField.getValue());
          System.out.println(newCCR);
          Navigation.navigate(Screen.HOME);
        });
    this.ConferenceRoomRequest_CleaningField.setOnMouseClicked(
        event -> {
          cleanRoom = !cleanRoom;
        });
  }
}
