package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

<<<<<<< HEAD
public class MealDeliveryRequestController extends ServiceRequestController implements IController {
=======
public class MealDeliveryRequestController {
>>>>>>> cbd5865f238f4b1381f35986eba203e470687788
  @FXML private MFXButton navigateFromMealButton;

  public void initialize() {
    this.navigateFromMealButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
