package edu.wpi.cs3733.D23.teamQ.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import io.github.palexdev.materialfx.utils.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

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

//  public void changeProfileImage(ActionEvent event) {
//    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // find a different way to do this
//
//    fileChooser = new FileChooser();
//    fileChooser.setTitle("Open image");
//
//    String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
//    File userDirectory = new File(userDirectoryString);
//
//    if(!userDirectory.canRead())
//      userDirectory = new File("c:/");
//
//    fileChooser.setInitialDirectory(userDirectory);
//    this.filePath = fileChooser.showOpenDialog(stage);
//
//    try {
//      BufferedImage bufferedImage = ImageIO.read(filePath);
//      Image image = SwingFXUtils.toFXImage(bufferedImage,null);
//      ProfilePage_Profile_Image.setImage(image);
//      photo.setImage(ProfilePage_Profile_Image.getImage());
//    } catch (IOException e)
//    {
//      System.err.println(e.getMessage());
//    }
//
//  }
}
