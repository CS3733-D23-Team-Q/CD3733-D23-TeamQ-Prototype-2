package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.Location;

import java.util.List;

public interface LocationDao {
    public List<Location> getAllLocations();
    public Location retrieveRow(String nodeID);
    public boolean updateRow(String nodeID, Location l);
    public boolean deleteRow(String nodeID);
    public boolean addRow(Location l);
}
