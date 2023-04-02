package edu.wpi.cs3733.D23.teamQ.db.obj;

public class ServiceRequest {
    private int requestID;
    private String requester;
    private String progress;
    private String assignee;
    private String roomNumber;
    private String specialInstructions;

    public ServiceRequest(int requestID, String requester, String progress, String assignee, String roomNumber, String specialInstructions) {
        this.requestID = requestID;
        this.requester = requester;
        this.progress = progress;
        this.assignee = assignee;
        this.roomNumber = roomNumber;
        this.specialInstructions = specialInstructions;
    }

    public int getRequestID() {
        return requestID;
    }

    public String getRequester() {
        return requester;
    }

    public String getProgress() {
        return progress;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }
}
