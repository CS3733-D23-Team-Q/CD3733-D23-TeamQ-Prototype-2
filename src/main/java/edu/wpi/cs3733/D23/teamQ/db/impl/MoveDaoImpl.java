package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Move;
import java.util.List;

public class MoveDaoImpl implements GenDao<Move, Integer> {
    private List<Move> moves;

    /**
     * returns a move given a nodeID
     *
     * @param nodeID of move being retrieved
     * @return a move with the given nodeID
     */
    public Move retrieveRow(Integer nodeID) {
        int index = this.getIndex(nodeID);
        return moves.get(index);
    }

    /**
     * updates move in list with a new move
     *
     * @param nodeID nodeID of Move being replaced
     * @param newMove new location being inserted
     * @return true if successful
     */
    public boolean updateRow(Integer nodeID, Move newMove) {
        int index = this.getIndex(nodeID);
        moves.set(index, newMove);
        return true;
    }

    /**
     * deletes move from list of moves
     *
     * @param nodeID of move being deleted
     * @return true if successfully deleted
     */
    public boolean deleteRow(Integer nodeID) {
        int index = this.getIndex(nodeID);
        moves.remove(index);
        return true;
    }

    /**
     * adds a move to the list
     *
     * @param m move being added
     * @return true if successful
     */
    public boolean addRow(Move m) {
        return moves.add(m);
    }

    /**
     * gets index of given nodeID in the list of moves
     *
     * @param nodeID nodeID being checked
     * @return value of index
     */
    private int getIndex(Integer nodeID) {
        for (int i = 0; i < moves.size(); i++) {
            Move m = moves.get(i);
            if (m.getNode().getNodeID().equals(nodeID)) {
                return i;
            }
        }
        throw new RuntimeException("No move found with ID " + nodeID);
    }

    /**
     * function that gets all moves in the list
     *
     * @return all moves in list
     */
    public List<Move> getAllRows(){
        return moves;
    }
}
