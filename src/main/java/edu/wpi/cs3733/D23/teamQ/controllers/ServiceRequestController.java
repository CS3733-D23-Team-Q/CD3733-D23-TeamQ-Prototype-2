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
  //  @FXML private MFXTextField Assignee;
  //  @FXML private MFXTextField RoomNumber;
  //  @FXML private MFXTextField SpecialInstructions;

  @FXML private MFXButton resetButton;
  @FXML private MFXButton backButton;
  @FXML private MFXButton submitButton;

  @FXML
  public void initialize() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    switch (ServiceRequestSelectorController.getSrNum()) {
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
    //    this.ClearButton.setOnMouseClicked(
    //        event -> {
    //          Assignee.clear();
    //          RoomNumber.clear();
    //          SpecialInstructions.clear();
    //        });
    this.resetButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
    this.backButton.setOnMouseClicked(
        event -> Navigation.navigate(Screen.SERVICE_REQUEST_SELECTOR));
    this.submitButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
