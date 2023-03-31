package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.Move;

import java.util.List;

public interface MoveDao {
    public List<Move> getAllMoves();
    public Move retrieveRow(String nodeID);
    public boolean updateRow(String nodeID, Move m);
    public boolean deleteRow(String nodeID);
    public boolean addRow(Move m);
}
