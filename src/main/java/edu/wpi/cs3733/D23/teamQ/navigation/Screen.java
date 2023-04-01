package edu.wpi.cs3733.D23.teamQ.navigation;

public enum Screen {
  ROOT("views/Root.fxml", "Root"),
  HOME("views/Home.fxml", "Home"),

  SIGNAGE("views/Signage.fxml", "Signage"),
  SERVICE_REQUEST("views/ServiceRequest.fxml", "Service Request"),
  CONFERENCE_ROOM_REQUEST("views/ConferenceRoomRequest.fxml", "Conference Room Request"),
  HELP("views/Help.fxml", "Help"),
  FLOWER_REQUEST("views/FlowerRequest.fxml", "Flower Request"),
  LOGIN("views/login page.fxml", "Login"),
  FLOWER_REQUEST_SUBMISSION("views/FlowerRequestSubmission.fxml", "Flower Request Submission");

  private final String filename;
  private final String title;

  Screen(String filename, String title) {
    this.filename = filename;
    this.title = title;
  }

  public String getFilename() {
    return filename;
  }

  public String getTitle() {
    return title;
  }
}
