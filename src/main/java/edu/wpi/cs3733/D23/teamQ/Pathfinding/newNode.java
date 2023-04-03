package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import edu.wpi.cs3733.D23.teamQ.db.obj.Node;
import java.util.ArrayList;
import java.util.List;

public class newNode extends Node implements Comparable<newNode> {
  newNode parent = null;
  Node goal = null;

  private static int idCounter = 0;
  private int id;

  private List<Edge> neighbors;

  //  // Evaluation functions
  double f = Double.MAX_VALUE;
  double g = Double.MAX_VALUE;
  private int xCoord;
  private int yCoord;

  newNode(int xCoord, int yCoord) {
    super(xCoord, yCoord);
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  public newNode() {
    super();
  }

  public List<Edge> getNeighbors() {
    return neighbors;
  }

  public Node getGoal() {
    return goal;
  }

  public void setGoal(Node goal) {
    this.goal = goal;
  }

  public double getF() {
    return f;
  }

  public static int getIdCounter() {
    return idCounter;
  }

  public int getId() {
    return id;
  }

  public newNode getParent() {
    return parent;
  }

  //  @Override
  public int compareTo(newNode n) {
    return Double.compare(this.f, n.f);
  }

  public int getxCoord() {
    return xCoord;
  }

  public int getyCoord() {
    return yCoord;
  }

  public void addBranch(int weight, newNode newNode) {
    Edge newEdge = new Edge(weight, newNode);
    //    Edge inverseEdge = new Edge(weight, this);
    neighbors.add(newEdge);
    //    neighbors.add(inverseEdge);
  }
}
