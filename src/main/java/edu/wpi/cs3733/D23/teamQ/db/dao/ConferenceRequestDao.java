package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;

import java.util.List;

public interface ConferenceRequestDao {
    public List<ConferenceRequest> getAllConferenceRequests();
    public ConferenceRequest retrieveRow(String requestID);
    public boolean updateRow(String requestID, ConferenceRequest cr);
    public boolean deleteRow(String requestID);
    public boolean addRow(ConferenceRequest cr);
}
