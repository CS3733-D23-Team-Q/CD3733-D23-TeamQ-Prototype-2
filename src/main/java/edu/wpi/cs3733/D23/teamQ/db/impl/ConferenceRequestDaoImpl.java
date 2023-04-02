package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConferenceRequestDaoImpl implements GenDao<ConferenceRequest, Integer> {
    private List<ConferenceRequest> conferenceRequests;

    /**
     * returns a conferenceRequest given a requestID
     *
     * @param requestID of conferenceRequest being retrieved
     * @return a conferenceRequest with the given nodeID
     */
    public ConferenceRequest retrieveRow(Integer requestID) {
        int index = this.getIndex(requestID);
        return conferenceRequests.get(index);
    }

    /**
     * updates conferenceRequest in list with a new conferenceRequest
     *
     * @param requestID requestID of conferenceRequest being replaced
     * @param newRequest new conferenceRequest being inserted
     * @return true if successful
     */
    public boolean updateRow(Integer requestID, ConferenceRequest newRequest) {
        int index = this.getIndex(requestID);
        conferenceRequests.set(index, newRequest);
        return true;
    }

    /**
     * deletes conferenceRequest from list of conferenceRequests
     *
     * @param requestID of conferenceRequest being deleted
     * @return true if successfully deleted
     */
    public boolean deleteRow(Integer requestID) {
        int index = this.getIndex(requestID);
        conferenceRequests.remove(index);
        return true;
    }

    /**
     * adds a conferenceRequest to the list
     *
     * @param x conferenceRequest being added
     * @return true if successful
     */
    public boolean addRow(ConferenceRequest x) {
        return conferenceRequests.add(x);
    }

    /**
     * gets index of given request in the list of requests
     *
     * @param requestID requestID being checked
     * @return value of index
     */
    private int getIndex(Integer requestID) {
        for (int i = 0; i < conferenceRequests.size(); i++) {
            ConferenceRequest x = conferenceRequests.get(i);
        }
        throw new RuntimeException("No move found with ID " + requestID);
    }

    /**
     * function that gets all conference requests in the list
     *
     * @return all conference requests in list
     */
    public List<ConferenceRequest> getAllRows(){
        return conferenceRequests;
    }

    public void addConferenceRequest(ConferenceRequest request) {
        try(Connection conn = GenDao.connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO flowerRequest(requestID, requester, progress, assignee, specialInstructions, time, cleanRoom, foodChoice, roomNum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, request.getRequestID());
            stmt.setString(2, request.getRequester());
            stmt.setString(3, request.getProgress());
            stmt.setString(4, request.getAssignee());
            stmt.setString(5, request.getSpecialInstructions());
            stmt.setString(6, request.getTime());
            stmt.setBoolean(7, request.isCleanRoom());
            stmt.setString(8, request.getFoodChoice());
            stmt.setString(9, request.getRoomNumber());
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
