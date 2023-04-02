package edu.wpi.cs3733.D23.teamQ.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  SIGNAGE("views/Signage.fxml"),
  HELP("views/Help.fxml"),
  SERVICE_REQUEST_SELECTOR("views/ServiceRequestSelector.fxml"),
  CONFERENCE_ROOM_REQUEST("views/ConferenceRoomRequest.fxml"),
  FLOWER_REQUEST("views/FlowerRequest.fxml"),
  FLOWER_REQUEST_SUBMISSION("views.FlowerRequestSubmission.fxml"),
  MEAL_REQUEST("views/MealDeliveryRequest.fxml"),
  OFFICE_SUPPLIES_REQUEST("views/OfficeSuppliesRequest.fxml"),
  FURNITURE_REQUEST("views/FurnitureDeliveryRequest.fxml"),
  PATIENT_TRANSPORT_REQUEST("views/PatientTransportRequest.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
