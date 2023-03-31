package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import edu.wpi.cs3733.D23.teamQ.servicerequestdata.FlowerRequestData;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class FlowerRequestController {
  @FXML private MFXTextField FlowerRequest_RoomNumber;
  @FXML private MFXTextField FlowerRequest_NoteOnFlower;
  @FXML private MFXTextField FlowerRequest_SpecialInstructions;

  @FXML private MFXButton FlowerRequest_CancelButton;
  @FXML private MFXButton FlowerRequest_ClearFieldsButton;
  @FXML private MFXButton FlowerRequest_SubmitButton;
  @FXML private ChoiceBox FlowerRequest_FlowerChoiceBox;
  ObservableList<String> TypeOfFlowers =
      FXCollections.observableArrayList("Roses", "Daisies", "Tulips", "Sunflowers", "Lilies");
  @FXML private ChoiceBox FlowerRequest_BouquetChoiceBox;
  ObservableList<String> NumOfBouquets = FXCollections.observableArrayList("1", "2", "3", "4", "5");

  /**
   * Initializes the Flower Request Choice Box's Switches screens to the Home page when Cancel
   * Button is pressed Clears fields when Clears Filters is pressed Switches screens to Flower
   * Request Submission page when Submit Button is pressed Gets values from the Flower Request Data
   */
  @FXML
  private void initialize() {
    this.FlowerRequest_FlowerChoiceBox.setValue("Select Flower");
    this.FlowerRequest_FlowerChoiceBox.setItems(TypeOfFlowers);
    this.FlowerRequest_BouquetChoiceBox.setValue("Number of Bouquets");
    this.FlowerRequest_BouquetChoiceBox.setItems(NumOfBouquets);
    this.FlowerRequest_CancelButton.setOnMouseClicked(
        event -> {
          Navigation.navigate(Screen.HOME);
        });
    this.FlowerRequest_ClearFieldsButton.setOnMouseClicked(
        event -> {
          this.FlowerRequest_FlowerChoiceBox.setValue("Select Flower");
          this.FlowerRequest_BouquetChoiceBox.setValue("Number of Bouquets");
          FlowerRequest_RoomNumber.clear();
          FlowerRequest_NoteOnFlower.clear();
          FlowerRequest_SpecialInstructions.clear();
        });
    this.FlowerRequest_SubmitButton.setOnMouseClicked(
        event -> {
          FlowerRequestData newFR =
              new FlowerRequestData(
                  "Temp user",
                  FlowerRequest_RoomNumber.getText(),
                  FlowerRequest_SpecialInstructions.getText(),
                  FlowerRequest_NoteOnFlower.getText(),
                  (String) FlowerRequest_FlowerChoiceBox.getValue(),
                  (String) FlowerRequest_BouquetChoiceBox.getValue());
          System.out.println(newFR.toString());
          Navigation.navigate(Screen.FLOWER_REQUEST_SUBMISSION);
        });
  }
}
