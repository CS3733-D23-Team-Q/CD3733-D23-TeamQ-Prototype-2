package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class FlowerRequestController extends ServiceRequestController {
  @FXML private MFXTextField roomNumberField;
  @FXML private MFXTextField noteField;
  @FXML private MFXTextField specialInstructionsField;
  @FXML private ChoiceBox flowerChoiceField;
  ObservableList<String> TypeOfFlowers =
      FXCollections.observableArrayList("Roses", "Daisies", "Tulips", "Sunflowers", "Lilies");
  @FXML private ChoiceBox bouquetChoiceField;
  ObservableList<String> NumOfBouquets = FXCollections.observableArrayList("1", "2", "3", "4", "5");

  @FXML private MFXButton resetButton;
  @FXML private MFXButton backButton;
  @FXML private MFXButton submitButton;
  /**
   * Initializes the Flower Request Choice Box's Switches screens to the Home page when Cancel
   * Button is pressed Clears fields when Clears Filters is pressed Switches screens to Flower
   * Request Submission page when Submit Button is pressed Gets values from the Flower Request Data
   */
  @FXML
  public void initialize() {
    this.flowerChoiceField.setValue("Select Flower");
    this.flowerChoiceField.setItems(TypeOfFlowers);
    this.bouquetChoiceField.setValue("Number of Bouquets");
    this.bouquetChoiceField.setItems(NumOfBouquets);
    this.resetButton.setOnMouseClicked(
        event -> {
          roomNumberField.clear();
          noteField.clear();
          specialInstructionsField.clear();
          flowerChoiceField.setValue("Select Flower");
          bouquetChoiceField.setValue("Number of Bouquets");
        });
    this.backButton.setOnMouseClicked(
        event -> Navigation.navigate(Screen.SERVICE_REQUEST_SELECTOR));
    this.submitButton.setOnMouseClicked(
        event -> {
          FlowerRequest newFR =
              new FlowerRequest(
                  0,
                  0,
                  "temp user",
                  "temp assignee",
                  roomNumberField.getText(),
                  specialInstructionsField.getText(),
                  (String) flowerChoiceField.getValue(),
                  (int) bouquetChoiceField.getValue());
          System.out.println(newFR);
          Navigation.navigate(Screen.FLOWER_REQUEST_SUBMISSION);
        });
  }
}
