package edu.wpi.cs3733.D23.teamQ.ServiceRequestData;

public class ServiceRequestData {
  private String requester;
  private String assignee;
  private String roomNumber;
  private String specialInstructions;

  public ServiceRequestData(
      String requester, String assignee, String roomNumber, String specialInstructions) {
    this.requester = requester;
    this.assignee = assignee;
    this.roomNumber = roomNumber;
    this.specialInstructions = specialInstructions;
  }
}
