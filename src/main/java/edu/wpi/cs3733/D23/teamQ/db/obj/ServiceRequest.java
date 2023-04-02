package edu.wpi.cs3733.D23.teamQ.db.obj;

public class ServiceRequest {
  private int requestID;
  private String username;
  private String enumeration;
  private String staffMember;
  private String roomNumber;
  private String instructions;

  public ServiceRequest(
      int requestID,
      String username,
      String enumeration,
      String staffMember,
      String roomNumber,
      String instructions) {
    this.requestID = requestID;
    this.username = username;
    this.enumeration = enumeration;
    this.staffMember = staffMember;
    this.roomNumber = roomNumber;
    this.instructions = instructions;
  }
}
