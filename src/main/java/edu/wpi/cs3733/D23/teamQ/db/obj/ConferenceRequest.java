package edu.wpi.cs3733.D23.teamQ.db.obj;

public class ConferenceRequest extends ServiceRequest {
    private int requestID;
    private String time;
    private boolean cleanRoom;
    private String foodChoice;


    public ConferenceRequest(int requestID, String username, String enumeration, String staffMember, String roomNumber, String instructions, String time, boolean cleanRoom, String foodChoice) {
        super(requestID, username, enumeration, staffMember, roomNumber, instructions);
        this.requestID = requestID;
        this.time = time;
        this.cleanRoom = cleanRoom;
        this.foodChoice = foodChoice;
    }



}
