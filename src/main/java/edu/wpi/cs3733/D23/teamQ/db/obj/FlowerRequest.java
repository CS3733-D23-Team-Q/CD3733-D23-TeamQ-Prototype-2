package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerRequest extends ServiceRequest {
  private String note;
  private String flowerType;
  private int numberOfBouquets;

  /**
   * constructor to create a FlowerRequest object
   * @param requestID
   * @param requester
   * @param progress
   * @param assignee
   * @param roomNumber
   * @param specialInstructions
   * @param note
   * @param flowerType
   * @param numberOfBouquets
   */
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
    super(requestID, requester, progress, assignee, roomNumber, specialInstructions);
    this.note = note;
    this.flowerType = flowerType;
    this.numberOfBouquets = numberOfBouquets;
  }

  public FlowerRequest(
      String requester,
      int progress,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String note,
      String flowerType,
      int numberOfBouquets) {
    super(0, requester, progress, assignee, roomNumber, specialInstructions);
    this.note = note;
    this.flowerType = flowerType;
    this.numberOfBouquets = numberOfBouquets;
  }
}
