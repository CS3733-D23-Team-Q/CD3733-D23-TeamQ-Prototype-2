package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class ServiceRequestData {
  public enum ProgressStatus {
    notStarted,
    processing,
    done
  };

  public static final String notStarted = "Not started";
  public static final String processing = "Processing";
  public static final String done = "Done";
  private String progress;
  private String requester;
  private String assignee;
  private String roomNumber;
  private String specialInstructions;

  public ServiceRequestData(
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions) {
    if (progress == 0) this.progress = notStarted;
    else if (progress == 1) this.progress = processing;
    else if (progress == 2) this.progress = done;
    this.requester = requester;
    this.assignee = assignee;
    this.roomNumber = roomNumber;
    this.specialInstructions = specialInstructions;
  }

  public String toString() {
    return "Progress: "
        + progress
        + "\nRequester: "
        + requester
        + "\nAssignee: "
        + assignee
        + "\nRoom Number: "
        + roomNumber
        + "\nSpecial Instructions: "
        + specialInstructions;
  }
}
