package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerRequest extends ServiceRequest {
  private String note;
  private String flowerType;
  private int numberOfBouquets;

  public FlowerRequest(
      int requestID,
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String note,
      String flowerType,
      int numberOfBouquets) {
    super(requestID, progress, requester, assignee, roomNumber, specialInstructions);
    this.note = note;
    this.flowerType = flowerType;
    this.numberOfBouquets = numberOfBouquets;
  }
  public FlowerRequest(
          int progress,
          String requester,
          String assignee,
          String roomNumber,
          String specialInstructions,
          String note,
          String flowerType,
          int numberOfBouquets) {
    super(0, progress, requester, assignee, roomNumber, specialInstructions);
    this.note = note;
    this.flowerType = flowerType;
    this.numberOfBouquets = numberOfBouquets;
  }
}
