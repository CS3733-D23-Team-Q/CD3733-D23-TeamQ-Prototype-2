package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.App;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ServiceRequestController {
  @FXML private BorderPane serviceBorderPane;

  @FXML private MFXButton resetButton;
  @FXML private MFXButton backButton;
  @FXML private MFXButton submitButton;

  private int srNum = 0;

  @FXML
  public void initialize() throws IOException {
    srNum = ServiceRequestSelectorController.getSrNum();
    FXMLLoader loader = new FXMLLoader();
    switch (srNum) {
      case 1:
        loader = new FXMLLoader(App.class.getResource("views/ConferenceRoomRequest.fxml"));
        break;
      case 2:
        loader = new FXMLLoader(App.class.getResource("views/MealDeliveryRequest.fxml"));
        break;
      case 3:
        loader = new FXMLLoader(App.class.getResource("views/FlowerRequest.fxml"));
        break;
      case 4:
        loader = new FXMLLoader(App.class.getResource("views/FurnitureDeliveryRequest.fxml"));
        break;
      case 5:
        loader = new FXMLLoader(App.class.getResource("views/OfficeSuppliesRequest.fxml"));
        break;
    }
    final BorderPane srPage;
    try {
      srPage = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // load in the form
    this.serviceBorderPane.setCenter(srPage);
    this.resetButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
    this.backButton.setOnMouseClicked(
        event -> {
          switch (srNum) {
            case 1:
              System.out.println("test");
              break;
            case 2:
              break;
            case 3:
              break;
            case 4:
              break;
            case 5:
              break;
          }
          Navigation.navigate(Screen.SERVICE_REQUEST_SELECTOR);
        });
    this.submitButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
