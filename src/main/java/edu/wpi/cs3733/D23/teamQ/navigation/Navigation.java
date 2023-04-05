package edu.wpi.cs3733.D23.teamQ.navigation;

import edu.wpi.cs3733.D23.teamQ.App;
import edu.wpi.cs3733.D23.teamQ.controllers.IController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigation {

  public static void navigate(final Screen screen) {
    final String filename = screen.getFilename();
    final String title = screen.getTitle();

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
      primaryStage.setTitle(title);
      primaryStage.setMaximized(false);
      primaryStage.setMaximized(true);
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
    }
  }

  /*
  public static void navigate(final Screen screen, String username) {
    final String filename = screen.getFilename();
    final String title = screen.getTitle();

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
      primaryStage.setTitle(title);
      primaryStage.setMaximized(false);
      primaryStage.setMaximized(true);
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
    }
  }
   */

  public static IController getController(final Screen screen) throws IOException {
    final String filename = screen.getFilename();
    /*
    final String filename = screen.getFilename();
    IController root = null;

    try {
      final var resource = App.class.getResource(filename);
      final FXMLLoader loader = new FXMLLoader(resource);

      root = loader.load();

    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
    }
    return root;
     */
    final var loader = new FXMLLoader(App.class.getResource(filename));
    final Parent layout = loader.load();
    final IController controller = loader.getController();
    return controller;
  }
}
