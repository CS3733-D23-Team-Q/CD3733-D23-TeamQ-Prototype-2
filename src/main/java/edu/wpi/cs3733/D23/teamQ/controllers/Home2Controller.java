package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Home2Controller extends HomeController {
  @FXML Button previousButton;
  @FXML Button MEButton;
  @FXML Button PFButton;

  @FXML
  public void initialize() {}

  @FXML
  public void previousButtonClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void MEButtonClicked() {
    Navigation.navigate(Screen.MAP_EDITOR);
  }

  @FXML
  public void PFButtonClicked() {
    // Navigation.navigate("Screen.PATHFINDING");
  }
}
