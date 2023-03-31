package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.Edge;

import java.util.List;

public interface EdgeDao {
    public List<Edge> getAllEdges();
    public Edge retrieveRow(String edgeID);
    public boolean updateRow(String edgeID,Edge e);
    public boolean deleteRow(String edgeID);
    public boolean addRow(Edge e);
}
