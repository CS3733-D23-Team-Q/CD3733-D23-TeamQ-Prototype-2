package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class ServiceRequestData {
  private String requester;
  private String roomNumber;
  private String specialInstructions;

  /**
   * Default constructor for service request data
   *
   * @param requester the person making the request
   * @param roomNumber the room number for the request
   * @param specialInstructions any special instructions for the request
   */
  public ServiceRequestData(String requester, String roomNumber, String specialInstructions) {
    this.requester = requester;
    this.roomNumber = roomNumber;
    this.specialInstructions = specialInstructions;
  }

  /**
   * Function to take the inputs and put them to string
   *
   * @return String that includes all inputs from the conference room request
   */
  public String toString() {
    return "Requester: "
        + requester
        + "\nRoom Number: "
        + roomNumber
        + "\nSpecial Instructions: "
        + specialInstructions;
  }
}
