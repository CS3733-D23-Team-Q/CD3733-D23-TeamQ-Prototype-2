package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class PathTextController {
  @FXML Button resetButton;
  @FXML Button backButton;
  @FXML Button submitButton;

  @FXML MenuItem homeItem;
  @FXML MenuItem exitItem;

  @FXML MFXTextField startNodeField;
  @FXML MFXTextField endNodeField;

  @FXML
  public void initialize() {}

  @FXML
  public void resetButtonClicked() {
    startNodeField.clear();
    endNodeField.clear();
  }

  @FXML
  public void backButtonClicked() {
    Navigation.navigate(Screen.HOME2);
  }

  @FXML
  public void submitButtonClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void homeItemClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void exitItemClicked() {
    Platform.exit();
  }
}
