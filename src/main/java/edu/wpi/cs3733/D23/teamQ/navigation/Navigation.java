package edu.wpi.cs3733.D23.teamQ.navigation;

import edu.wpi.cs3733.D23.teamQ.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigation {

  public static void navigate(final edu.wpi.cs3733.D23.teamQ.navigation.Screen screen) {
    final String filename = screen.getFilename();

    try {
      final var resource = App.class.getResource(filename);
      final FXMLLoader loader = new FXMLLoader(resource);

      Stage primaryStage = App.getPrimaryStage();
      final Scene scene = new Scene(loader.load());
      scene
          .getStylesheets()
          .add(
              Navigation.class
                  .getResource("/edu/wpi/cs3733/D23/teamQ/views/styles/Home.css")
                  .toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.centerOnScreen();
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
    }
  }
}
