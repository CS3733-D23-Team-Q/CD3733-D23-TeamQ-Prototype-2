package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class FlowerRequestData extends ServiceRequestData {
  private String flowerType;
  private int numberOfBouquets;

  public FlowerRequestData(
      int progress,
      String requester,
      String assignee,
      String roomNumber,
      String specialInstructions,
      String flowerType,
      int numberOfBouquets) {
    super(progress, requester, assignee, roomNumber, specialInstructions);
    this.flowerType = flowerType;
    this.numberOfBouquets = numberOfBouquets;
  }

  public String toString() {
    return super.toString()
        + "\nFlower Type: "
        + flowerType
        + "\nNumber of Bouquets: "
        + numberOfBouquets;
  }
}
