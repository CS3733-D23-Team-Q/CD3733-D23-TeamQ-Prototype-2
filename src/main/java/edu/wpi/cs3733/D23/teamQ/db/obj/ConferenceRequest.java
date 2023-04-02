package edu.wpi.cs3733.D23.teamQ.db.obj;

public class ConferenceRequest extends ServiceRequest {
  private String foodChoice;

  public ConferenceRequest(
          int requestID,
          int progress,
          String requester,
          String assignee,
          String roomNumber,
          String specialInstructions,
          String foodChoice) {
    super(requestID, progress, requester, assignee, roomNumber, specialInstructions);
    this.foodChoice = foodChoice;
  }
}
