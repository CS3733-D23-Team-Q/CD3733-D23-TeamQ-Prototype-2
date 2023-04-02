package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class ConferenceRoomRequestData extends ServiceRequestData {
  public ConferenceRoomRequestData(
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions) {
    super(progress, requester, assignee, roomNumber, specialInstructions);
  }
}
