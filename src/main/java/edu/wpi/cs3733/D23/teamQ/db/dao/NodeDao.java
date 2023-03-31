package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.Node;

import java.util.List;

public interface NodeDao {
    public List<Node> getAllNodes();
    public Node retrieveRow(String nodeID);
    public boolean updateRow(String nodeID, Node n);
    public boolean deleteRow(String nodeID);
    public boolean addRow(Node n);
}
