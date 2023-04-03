package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.impl.ConferenceDaoSingleton;
import edu.wpi.cs3733.D23.teamQ.db.impl.FlowerDaoSingleton;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ConferenceRoomRequestController {
  ObservableList<String> foodOptionsList =
      FXCollections.observableArrayList(
          "Brunch spread", "Dinner spread", "Snack spread", "No food");
  @FXML private MFXTextField roomNumberField;
  @FXML private MFXTextField dateTimeField;
  @FXML private ChoiceBox foodField;
  @FXML private MFXTextField specialInstructionsField;

  @FXML private MFXButton resetButton;
  @FXML private MFXButton backButton;
  @FXML private MFXButton submitButton;

  @FXML
  public void initialize() {
    this.foodField.setValue("Select Food Option");
    this.foodField.setItems(foodOptionsList);
    this.resetButton.setOnMouseClicked(
        event -> {
          roomNumberField.clear();
          dateTimeField.clear();
          specialInstructionsField.clear();
          foodField.setValue("No food");
        });
    this.backButton.setOnMouseClicked(
        event -> Navigation.navigate(Screen.SERVICE_REQUEST_SELECTOR));
    this.submitButton.setOnMouseClicked(
        event -> {
          ConferenceRequest newCCR =
              new ConferenceRequest(
                  0,
                  "temp user",
                  "temp assignee",
                  roomNumberField.getText(),
                  specialInstructionsField.getText(),
                  dateTimeField.getText(),
                  (String) foodField.getValue());
          System.out.println(newCCR);
            ConferenceDaoSingleton.Connection.getDoaCCR().addRow(newCCR);
          Navigation.navigate(Screen.HOME);
        });
  }
}
