package edu.wpi.cs3733.D23.teamQ.ServiceRequestData;

public class ServiceRequestData {
  public enum ProgressStatus{notStarted, processing, done};
  public static final String notStarted = "Not started";
  public static final String processing = "Processing";
  public static final String done = "Done";
  private String progress;
  private String requester;
  private String assignee;
  private String roomNumber;
  private String specialInstructions;

  public ServiceRequestData(String progress, String requester, String assignee, String roomNumber, String specialInstructions) {
    this.progress = progress;
    this.requester = requester;
    this.assignee = assignee;
    this.roomNumber = roomNumber;
    this.specialInstructions = specialInstructions;
  }
}
