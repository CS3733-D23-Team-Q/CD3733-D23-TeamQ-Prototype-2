package edu.wpi.cs3733.D23.teamQ.navigation;

public enum Screen {
  ROOT("views/Root.fxml", "Root"),
  HOME("views/Home.fxml", "Home"),
  HOME2("views/Home2.fxml", "Home"),
  LOGIN("views/LoginPage.fxml", "Login"),
  CREATE_ACCOUNT("views/CreateAccount.fxml", "Create Account"),
  FORGOT_PASSWORD("views/ForgotPassword.fxml", "Reset Password"),

  SIGNAGE("views/Signage.fxml", "Signage"),
  HELP("views/Help.fxml", "Help"),
  SERVICE_REQUEST_HUB("views/ServiceRequestHub.fxml", "Selector"),
  CONFERENCE_ROOM_REQUEST("views/ConferenceRoomRequest.fxml", "Conference Room Request"),
  FLOWER_REQUEST("views/FlowerRequest.fxml", "Flower Request"),
  FLOWER_REQUEST_SUBMISSION("views.FlowerRequestSubmission.fxml", "Flower Request Submission"),
  MEAL_REQUEST("views/MealDeliveryRequest.fxml", "Meal Request"),
  OFFICE_SUPPLIES_REQUEST("views/OfficeSuppliesRequest.fxml", "Office Supplies Request"),
  FURNITURE_REQUEST("views/FurnitureDeliveryRequest.fxml", "Furniture Request"),
  PATIENT_TRANSPORT_REQUEST("views/PatientTransportRequest.fxml", "Patient Transport Request");

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
