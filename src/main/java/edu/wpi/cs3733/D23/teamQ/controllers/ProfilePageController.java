package edu.wpi.cs3733.D23.teamQ.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProfilePageController {
  @FXML private MFXButton ProfilePage_ChangePic_Button;

  @FXML private MFXButton ProfilePage_Done_Button;

  @FXML private MFXTextField ProfilePage_Email_TextField;

  @FXML private MFXTextField ProfilePage_FirstName_TextField;

  @FXML private MFXTextField ProfilePage_IDNumber_TextField;

  @FXML private MFXTextField ProfilePage_LastName_TextField;

  @FXML private MFXTextField ProfilePage_PhoneNumber_TextField;

  @FXML private MFXTextField ProfilePage_Title_TextField;

  @FXML private MFXTextField ProfilePage_Username_TextField;
  @FXML private ImageView ProfilePage_Profile_Image;

  private FileChooser fileChooser;
  private File filePath;

  @FXML
  private void initialize() {
    //            this.FlowerRequest_CancelButton.setOnMouseClicked(   MAKE THIS SO THAT WHEN DONE
    // IS CLICKED SHOWS WHAT WAS CHANGED IN THE PROFILE PAGE
    //                    event -> {
    //                        Navigation.navigate(Screen.HOME);
    //                    });
  }

  public void changeProfileImage(ActionEvent event) {
    Stage stage =
        (Stage)
            ((Node) event.getSource()).getScene().getWindow(); // find a different way to do this
    fileChooser = new FileChooser();
    fileChooser.setTitle("Open image");
    this.filePath = fileChooser.showOpenDialog(stage);
  }
}
