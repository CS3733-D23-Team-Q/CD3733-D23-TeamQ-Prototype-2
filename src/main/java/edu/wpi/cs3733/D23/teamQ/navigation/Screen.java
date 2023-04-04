package edu.wpi.cs3733.D23.teamQ.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  SIGNAGE("views/Signage.fxml"),
  SERVICE_REQUEST("views/ServiceRequest.fxml"),
  CONFERENCE_ROOM_REQUEST("views/MapEditor.fxml"),
  HELP("views/Help.fxml"),
  FLOWER_REQUEST("views/FlowerRequest.fxml"),
  FLOWER_REQUEST_SUBMISSION("views/FlowerRequestSubmission.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
