package edu.wpi.cs3733.D23.teamQ.controllers;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.aStar;

import edu.wpi.cs3733.D23.teamQ.Pathfinding.star;
import edu.wpi.cs3733.D23.teamQ.db.Qdb;
import edu.wpi.cs3733.D23.teamQ.db.obj.Node;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.sql.SQLException;
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
  public void submitButtonClicked() throws SQLException {
    Qdb qdb = Qdb.getInstance();
    Node start = qdb.nodeTable.retrieveRow(Integer.parseInt(startNodeField.getText()));
    Node end = qdb.nodeTable.retrieveRow(Integer.parseInt(endNodeField.getText()));
    String textPath = star.returnPath(aStar(start, end));
    System.out.println(textPath);
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
