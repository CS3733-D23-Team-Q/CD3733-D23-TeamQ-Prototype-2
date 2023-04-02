package edu.wpi.cs3733.D23.teamQ.db.obj;

public class ConferenceRequest extends ServiceRequest {
    private int requestID;
    private String time;
    private boolean cleanRoom;
    private String foodChoice;



    public ConferenceRequest(int requestID, String requester, String progress, String assignee, String roomNumber, String specialInstructions, String time, boolean cleanRoom, String foodChoice) {
        super(requestID, requester, progress, assignee, roomNumber, specialInstructions);
        this.requestID = requestID;
        this.time = time;
        this.cleanRoom = cleanRoom;
        this.foodChoice = foodChoice;
    }

    public String getTime() {
        return time;
    }

    public boolean isCleanRoom() {
        return cleanRoom;
    }

    public String getFoodChoice() {
        return foodChoice;
    }
}
