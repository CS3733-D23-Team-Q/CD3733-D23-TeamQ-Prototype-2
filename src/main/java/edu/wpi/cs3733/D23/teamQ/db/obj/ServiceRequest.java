package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequest {

  private int requestID;
  private int progress;
  private String requester;
  private String assignee;
  private String roomNumber;
  private String specialInstructions;

  public ServiceRequest(
      int requestID,
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions) {
    this.requestID = requestID;
    this.progress = progress;
    this.requester = requester;
    this.assignee = assignee;
    this.roomNumber = roomNumber;
    this.specialInstructions = specialInstructions;
  }
}
