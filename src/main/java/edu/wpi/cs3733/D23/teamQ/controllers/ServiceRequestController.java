package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ServiceRequestController implements IController {
  @FXML private BorderPane serviceBorderPane;

  @FXML private MFXButton resetButton;
  @FXML private MFXButton backButton;
  @FXML private MFXButton submitButton;

  @FXML
  public void initialize() throws IOException {
    this.resetButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
    this.backButton.setOnMouseClicked(event -> System.out.println("back"));
    this.backButton.setOnMouseClicked(event -> System.out.println("submit"));
  }
}
