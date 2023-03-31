package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.EdgeDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Edge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EdgeDaoImpl implements EdgeDao {
    private List<Edge> edges;

    EdgeDaoImpl(LinkedList<Edge> edges) {
        this.edges = edges;
    }
    /**
     * returns a edge given a edgeID
     *
     * @param edgeID of node being retrieved
     * @return a edge with the given edgeID
     */
    public Edge retrieveRow(String edgeID) {
        int index = this.getIndex(edgeID);
        return edges.get(index);
    }
    /**
     * updates edge in linked list with a new edge
     *
     * @param edgeID edgeID of edge being replaced
     * @param newEdge new edge being inserted
     * @return true if successful
     */
    public boolean updateRow(String edgeID, Edge newEdge) {
        int index = this.getIndex(edgeID);
        edges.set(index, newEdge);
        return true;
    }
    /**
     * deletes edges from list of edges
     *
     * @param edgeID of node being deleted
     * @return true if successfully deleted
     */
    public boolean deleteRow(String edgeID) {
        int index = this.getIndex(edgeID);
        edges.remove(index);
        return true;
    }
    /**
     * adds a edge to the linked list
     *
     * @param e edge being added
     * @return true if successful
     */
    public boolean addRow(Edge e) {
        return edges.add(e);
    }
    /**
     * gets index of given edgeID in the list of edges
     *
     * @param edgeID edgeID being checked
     * @return value of index
     */
    private int getIndex(String edgeID) {
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (e.getEdgeID().equals(edgeID)) {
                return i;
            }
        }
        throw new RuntimeException("No edge found with ID " + edgeID);
    }

    /**
     * function that gets all edges in the list
     *
     * @return all edges in list
     */
    public List<Edge> getAllEdges(){
        return edges;
    }

    /**
     * function that exports edge table into given csv file
     *
     * @param filename csv file to export to
     * @return true if successfully exported, false otherwise
     */
    public boolean toCSV(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            FileWriter myWriter = new FileWriter(filename);
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                myWriter.write(
                        e.getEdgeID()
                                + ','
                                + e.getStartNode().getNodeID()
                                + ','
                                + e.getEndNode().getNodeID()
                                + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

}
