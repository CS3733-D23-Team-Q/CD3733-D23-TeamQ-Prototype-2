package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;
import edu.wpi.cs3733.D23.teamQ.db.obj.ServiceRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlowerRequestDaoImpl implements GenDao<FlowerRequest, Integer> {
    private List<FlowerRequest> flowerRequests;


    /**
     * returns a flowerRequest given a requestID
     *
     * @param requestID of conferenceRequest being retrieved
     * @return a conferenceRequest with the given nodeID
     */
    public FlowerRequest retrieveRow(Integer requestID) {
        int index = this.getIndex(requestID);
        return flowerRequests.get(index);
    }

    /**
     * updates flowerRequest in list with a new flowerRequest
     *
     * @param requestID requestID of conferenceRequest being replaced
     * @param newRequest new conferenceRequest being inserted
     * @return true if successful
     */
    public boolean updateRow(Integer requestID, FlowerRequest newRequest) {
        int index = this.getIndex(requestID);
        flowerRequests.set(index, newRequest);
        return true;
    }

    /**
     * deletes flowerRequest from list of flowerRequests
     *
     * @param requestID of flowerRequest being deleted
     * @return true if successfully deleted
     */
    public boolean deleteRow(Integer requestID) {
        int index = this.getIndex(requestID);
        flowerRequests.remove(index);
        return true;
    }

    /**
     * adds a flowerRequest to the list
     *
     * @param x flowerRequest being added
     * @return true if successful
     */
    public boolean addRow(FlowerRequest x) {
        return flowerRequests.add(x);
    }

    @Override
    public boolean populate() {
        return false;
    }

    /**
     * gets index of given request in the list of requests
     *
     * @param requestID requestID being checked
     * @return value of index
     */
    private int getIndex(Integer requestID) {
        for (int i = 0; i < flowerRequests.size(); i++) {
            FlowerRequest x = flowerRequests.get(i);
            if (x.getRequestID() == requestID) {
                return i;
            }
        }
        throw new RuntimeException("No move found with ID " + requestID);
    }

    /**
     * function that gets all flower requests in the list
     *
     * @return all flower requests in list
     */
    public List<FlowerRequest> getAllRows(){
        return flowerRequests;
    }

    public void addFlowerRequest(FlowerRequest request) {
        try(Connection conn = GenDao.connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO flowerRequest(requestID, requester, progress, assignee, specialInstructions, note, typeOfFlower, bouquetSize, roomNum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, request.getRequestID());
            stmt.setString(2, request.getRequester());
            stmt.setString(3, request.getProgress());
            stmt.setString(4, request.getAssignee());
            stmt.setString(5, request.getSpecialInstructions());
            stmt.setString(6, request.getNote());
            stmt.setString(7, request.getTypeOfFlower());
            stmt.setString(8, request.getBouquetSize());
            stmt.setString(9, request.getRoomNumber());
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FlowerRequest> listFlowerRequests(String assignerUsername) {
        List<FlowerRequest> requests = new ArrayList<>();
        try(Connection conn = GenDao.connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM flowerRequest WHERE requester = ?")) {
            stmt.setString(1, assignerUsername);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                int requestID = rs.getInt("requestID");
                String requester = rs.getString("requester");
                String progress = rs.getString("progress");
                String assignee = rs.getString("assignee");
                String specialInstructions = rs.getString("specialInstructions");
                String note = rs.getString("note");
                String typeOfFlower = rs.getString("typeOfFlower");
                String bouquetSize = rs.getString("bouquetSize");
                String roomNum = rs.getString("roomNum");
                FlowerRequest request = new FlowerRequest(requestID, requester, progress, assignee, specialInstructions, note, typeOfFlower, bouquetSize, roomNum);
                requests.add(request);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }
}






