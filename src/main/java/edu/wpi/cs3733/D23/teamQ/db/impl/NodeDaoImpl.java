package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Node;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NodeDaoImpl implements GenDao<Node, Integer> {
  private static List<Node> nodes;

  NodeDaoImpl(List<Node> nodes) {
    this.nodes = nodes;
  }

  /**
   * returns a node given a nodeID
   *
   * @param nodeID of node being retrieved
   * @return a node with the given nodeID
   */
  public Node retrieveRow(Integer nodeID) {
    int index = this.getIndex(nodeID);
    return nodes.get(index);
  }

  /**
   * updates node in linked list with a new node
   *
   * @param nodeID nodeID of node being replaced
   * @param newNode new node being inserted
   * @return true if successful
   */
  public boolean updateRow(Integer nodeID, Node newNode) {
    int index = this.getIndex(nodeID);
    nodes.set(index, newNode);
    return true;
  }

  /**
   * deletes nodes from list of nodes
   *
   * @param nodeID of node being deleted
   * @return true if successfully deleted
   */
  public boolean deleteRow(Integer nodeID) {
    int index = this.getIndex(nodeID);
    nodes.remove(index);
    return true;
  }

  /**
   * adds a node to the linked list
   *
   * @param n node being added
   * @return true if successful
   */
  public boolean addRow(Node n) {
    return nodes.add(n);
  }

  /**
   * gets index of given nodeID in the list of nodes
   *
   * @param nodeID nodeID being checked
   * @return value of index
   */
  private int getIndex(Integer nodeID) {
    for (int i = 0; i < nodes.size(); i++) {
      Node n = nodes.get(i);
      if (n.getNodeID() == nodeID) {
        return i;
      }
    }
    throw new RuntimeException("No node found with ID " + nodeID);
  }

  /**
   * function that gets all nodes in the list
   *
   * @return all nodes in list
   */
  public static List<Node> getAllRows() {
    return nodes;
  }

  /**
   * function that exports node table into given csv file
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
      for (int i = 0; i < nodes.size(); i++) {
        Node n = nodes.get(i);
        myWriter.write(
            n.getNodeID()
                + ','
                + n.getXCoord()
                + ','
                + n.getYCoord()
                + ','
                + n.getFloor()
                + ','
                + n.getBuilding()
                + ','
                + n.getEdges()
                + ','
                + n.getLocation()
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
