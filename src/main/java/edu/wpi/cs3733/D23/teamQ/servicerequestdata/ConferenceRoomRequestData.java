package edu.wpi.cs3733.D23.teamQ.servicerequestdata;

public class ConferenceRoomRequestData extends ServiceRequestData {
  String time;
  boolean cleanRoom;
  String foodChoice;

  /**
   * Default constructor for ConferenceRoomRequestData
   *
   * @param requester The name of the Requester
   * @param roomNumber The room number to deliver to
   * @param specialInstructions Any special instructions for delivery
   * @param time time of delivery
   * @param cleanRoom boolean, true if room needs to be cleaned
   * @param foodChoice The selected food for the conference room
   */
  public ConferenceRoomRequestData(
      String requester,
      String roomNumber,
      String specialInstructions,
      String time,
      boolean cleanRoom,
      String foodChoice) {
    super(requester, roomNumber, specialInstructions);
    this.time = time;
    this.cleanRoom = cleanRoom;
    this.foodChoice = foodChoice;
  }

  /**
   * Function to take the inputs and put them to string
   *
   * @return String that includes all inputs from the conference room request
   */
  public String toString() {
    return super.toString()
        + "\nTime: "
        + time
        + "\nClean Room: "
        + cleanRoom
        + "\nFood Choice: "
        + foodChoice;
  }
}
