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
    switch (ServiceRequestSelectorController.getSrNum()) {
      case 1:
        final FXMLLoader loader1 =
            new FXMLLoader(App.class.getResource("views/ConferenceRoomRequest.fxml"));
        final BorderPane srPage1;
        try {
          srPage1 = loader1.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        // load in the form
        this.serviceBorderPane.setCenter(srPage1);
        break;
      case 2:
        final FXMLLoader loader2 =
            new FXMLLoader(App.class.getResource("views/MealDeliveryRequest.fxml"));
        final BorderPane srPage2;
        try {
          srPage2 = loader2.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        // load in the form
        this.serviceBorderPane.setCenter(srPage2);
        break;
      case 3:
        final FXMLLoader loader3 =
            new FXMLLoader(App.class.getResource("views/FlowerRequest.fxml"));
        final BorderPane srPage3;
        try {
          srPage3 = loader3.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        // load in the form
        this.serviceBorderPane.setCenter(srPage3);
        break;
      case 4:
        final FXMLLoader loader4 =
            new FXMLLoader(App.class.getResource("views/FurnitureDeliveryRequest.fxml"));
        final BorderPane srPage4;
        try {
          srPage4 = loader4.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        // load in the form
        this.serviceBorderPane.setCenter(srPage4);
        break;
      case 5:
        final FXMLLoader loader5 =
            new FXMLLoader(App.class.getResource("views/OfficeSuppliesRequest.fxml"));
        final BorderPane srPage5;
        try {
          srPage5 = loader5.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

        // load in the form
        this.serviceBorderPane.setCenter(srPage5);
        break;
    }
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
