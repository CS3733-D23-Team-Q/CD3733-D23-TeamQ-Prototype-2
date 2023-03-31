package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class FlowerRequestData extends ServiceRequestData {

  String note;
  String typeOfFlower;
  String bouquetSize;

  /**
   * Default constructor for FlowerRequestData
   *
   * @param requester The name of the Requester
   * @param roomNumber The room number to deliver to
   * @param specialInstructions Any special instructions for delivery
   * @param note a note included with the request
   * @param typeOfFlower the type of flower requested
   * @param bouquetSize bouquet size requested
   */
  public FlowerRequestData(
      String requester,
      String roomNumber,
      String specialInstructions,
      String note,
      String typeOfFlower,
      String bouquetSize) {
    super(requester, roomNumber, specialInstructions);
    this.note = note;
    this.typeOfFlower = typeOfFlower;
    this.bouquetSize = bouquetSize;
  }

  /**
   * Function to take the inputs and put them to string
   *
   * @return String that includes all inputs from the conference room request
   */
  @Override
  public String toString() {
    return super.toString()
        + "\nNote: "
        + note
        + "\nType of flower: "
        + typeOfFlower
        + "\nBouquet Size: "
        + bouquetSize;
  }
}
