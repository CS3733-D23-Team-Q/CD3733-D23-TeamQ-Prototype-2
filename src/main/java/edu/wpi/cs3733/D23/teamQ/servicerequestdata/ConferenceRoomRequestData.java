package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class ConferenceRoomRequestData extends ServiceRequestData {
  private String foodChoice;

  public ConferenceRoomRequestData(
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String foodChoice) {
    super(progress, requester, assignee, roomNumber, specialInstructions);
    this.foodChoice = foodChoice;
  }

  public String toString() {
    return super.toString() + "\nFood choice: " + foodChoice;
  }
}
