package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerRequest extends ServiceRequest {
  private int requestID;
  private String note;
  private String typeOfFlower;
  private String bouquetSize;

  public FlowerRequest(
      int requestID,
      String username,
      String enumeration,
      String staffMember,
      String roomNumber,
      String instructions,
      String note,
      String typeOfFlower,
      String bouquetSize) {
    super(requestID, username, enumeration, staffMember, roomNumber, instructions);
    this.requestID = requestID;
    this.note = note;
    this.typeOfFlower = typeOfFlower;
    this.bouquetSize = bouquetSize;
  }
}
