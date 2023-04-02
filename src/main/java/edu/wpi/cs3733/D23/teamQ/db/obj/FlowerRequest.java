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
      String requester,
      String progress,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String note,
      String typeOfFlower,
      String bouquetSize) {
    super(requestID, requester, progress, assignee, roomNumber, specialInstructions);
    this.requestID = requestID;
    this.note = note;
    this.typeOfFlower = typeOfFlower;
    this.bouquetSize = bouquetSize;
  }

  public int getRequestID() {
    return requestID;
  }

  public String getNote() {
    return note;
  }

  public String getTypeOfFlower() {
    return typeOfFlower;
  }

  public String getBouquetSize() {
    return bouquetSize;
  }
}
