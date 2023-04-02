package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerRequest extends ServiceRequest {
  private String flowerType;
  private int numberOfBouquets;

  public FlowerRequest(
          int requestID,
          int progress,
          String requester,
          String assignee,
          String roomNumber,
          String specialInstructions,
          String flowerType,
          int numberOfBouquets) {
    super(requestID, progress, requester, assignee, roomNumber, specialInstructions);
    this.flowerType = flowerType;
    this.numberOfBouquets = numberOfBouquets;
  }
}
