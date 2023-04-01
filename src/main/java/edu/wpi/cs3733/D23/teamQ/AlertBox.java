package edu.wpi.cs3733.D23.teamQ;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
  @FXML private static HBox rootPane;

  public static void display(String title, String message) throws IOException {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    Label label = new Label();
    label.setText(message);
    label.setStyle("-fx-text-fill: Red;");
    Button okButton = new Button("Ok");
    okButton.setOnAction(e -> window.close());
    VBox layout = new VBox(5);
    layout.getChildren().addAll(label, okButton);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout, 250, 200);
    window.setScene(scene);
    window.show();
  }
}
