package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class FlowerRequestDisplayController {
  @FXML Button resetButton;
  @FXML Button backButton;
  @FXML Button submitButton;

  @FXML Label roomNumberField;

  @FXML Label flowerChoiceField;

  @FXML Label numberBouquetField;

  @FXML Label flowerNoteField;

  @FXML Label specialInstructionsField;

  @FXML Label assigneeField;

  @FXML MenuItem homeItem;
  @FXML MenuItem exitItem;
  ListServiceRequestController listServiceRequestController = new ListServiceRequestController();

  public FlowerRequestDisplayController() throws SQLException {}

  @FXML
  public void initialize() {
    // roomNumberField.setText(listServiceRequestController.getFlowerRequest().getRoomNumber());
    // flowerNoteField.setText(listServiceRequestController.getFlowerRequest().getNote());
    // flowerChoiceField.setText(listServiceRequestController.getFlowerRequest().getFlowerType());
    // numberBouquetField.setText(String.valueOf(listServiceRequestController.getFlowerRequest().getNumberOfBouquets()));
    // assigneeField.setText(listServiceRequestController.getConferenceRequest().getAssignee());
    // specialInstructionsField.setText(listServiceRequestController.getConferenceRequest().getSpecialInstructions());
  }

  @FXML
  public void resetButtonClicked() {}

  @FXML
  public void backButtonClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void submitButtonClicked() {}

  @FXML
  public void homeItemClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void exitItemClicked() {
    Platform.exit();
  }
}
