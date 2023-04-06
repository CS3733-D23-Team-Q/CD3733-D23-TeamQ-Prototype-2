package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class SignageController {
  @FXML private Button BackHomeBTN;

  @FXML private MenuItem exitItem;

  @FXML private MenuItem homeItem;

  @FXML private GridPane signageRoot;

  @FXML
  public void initialize() {
    Platform.runLater(
        () -> {
          this.signageRoot
              .getScene()
              .addEventHandler(
                  KeyEvent.KEY_TYPED,
                  new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                      if (event.getCharacter().equals("\u001b")) {
                        signageRoot.getScene().removeEventHandler(KeyEvent.KEY_TYPED, this);
                        Navigation.navigate(Screen.HOME);
                      }
                    }
                  });
        });

    BackHomeBTN.setOnMouseClicked((event -> Navigation.navigate(Screen.HOME)));
  }

  public void homeItemClicked(javafx.event.ActionEvent actionEvent) {
    Navigation.navigate(Screen.HOME);
  }

  public void exitItemClicked(javafx.event.ActionEvent actionEvent) {
    Platform.exit();
  }
}
