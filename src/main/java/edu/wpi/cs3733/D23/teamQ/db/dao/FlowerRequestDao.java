package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;

import java.util.List;

public interface FlowerRequestDao {
    public List<FlowerRequest> getAllFlowerRequests();
    public FlowerRequest retrieveRow(String requestID);
    public boolean updateRow(String requestID, FlowerRequest fr);
    public boolean deleteRow(String requestID);
    public boolean addRow(FlowerRequest fr);
}
