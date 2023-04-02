package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequest {
  public enum ProgressStatus {
    notStarted,
    processing,
    done
  };

  private int requestID;
  public static final String notStarted = "Not started";
  public static final String processing = "Processing";
  public static final String done = "Done";
  private String progress;
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
    if (progress == 0) this.progress = notStarted;
    else if (progress == 1) this.progress = processing;
    else if (progress == 2) this.progress = done;
    this.requester = requester;
    this.assignee = assignee;
    this.roomNumber = roomNumber;
    this.specialInstructions = specialInstructions;
  }
}
