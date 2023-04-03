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
      String requester,
      int progress,
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
}
