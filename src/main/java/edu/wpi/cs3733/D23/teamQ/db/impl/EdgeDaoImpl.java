package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EdgeDaoImpl implements GenDao<Edge, Integer> {
  private List<Edge> edges = new ArrayList<>();

  public EdgeDaoImpl() {}

  /**
   * returns a edge given a edgeID
   *
   * @param edgeID of node being retrieved
   * @return a edge with the given edgeID
   */
  public Edge retrieveRow(Integer edgeID) {
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
  public boolean updateRow(Integer edgeID, Edge newEdge) {
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
  public boolean deleteRow(Integer edgeID) {
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

  @Override
  public boolean populate() {
    return false;
  }

  /**
   * gets index of given edgeID in the list of edges
   *
   * @param edgeID edgeID being checked
   * @return value of index
   */
  private int getIndex(Integer edgeID) {
    for (int i = 0; i < edges.size(); i++) {
      Edge e = edges.get(i);
      if (e.getEdgeID() == edgeID) {
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
  public List<Edge> getAllRows() {
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

  public boolean importCSV(String filename) {
    NodeDaoImpl nodeDao = new NodeDaoImpl();
    try {
      File f = new File(filename);
      Scanner myReader = new Scanner(f);
      while (myReader.hasNextLine()) {
        String row = myReader.nextLine();
        String[] vars = row.split(",");
        Edge e = new Edge(Integer.parseInt(vars[1]), nodeDao.retrieveRow(Integer.parseInt(vars[2])), nodeDao.retrieveRow(Integer.parseInt(vars[2])));
        addRow(e);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  /**
   * return a list of a given nodeID's edges
   * @param nodeID
   * @return
   */
  public List<Edge> getEdges(int nodeID) {
    List<Edge> edgeList = new ArrayList<>();
    for(Edge edge : edges) {
      if(edge.getStartNode().getNodeID() == nodeID || edge.getStartNode().getNodeID() == nodeID) {
        edgeList.add(edge);
      }
    }
    return edgeList;
  }
}
