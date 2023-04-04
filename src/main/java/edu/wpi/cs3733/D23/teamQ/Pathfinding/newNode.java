package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import edu.wpi.cs3733.D23.teamQ.db.obj.Node;
import java.util.ArrayList;
import java.util.List;

public class newNode extends Node implements Comparable<newNode> {
  newNode parent = null;
  //  Node goal = null;

  private static int idCounter = 0;
  private int id;
  private int weight;
  private List<Edge> neighbors;
  double f = Double.MAX_VALUE;
  double g = Double.MAX_VALUE;
  private int xCoord;
  private int yCoord;
  private newNode goal;

  newNode(int xCoord, int yCoord) {
    super(xCoord, yCoord);
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
    this.weight = weight;
  }

  public newNode() {
    super();
  }

  public List<Edge> getNeighbors() {
    return neighbors;
  }

  public newNode getGoal() {
    return goal;
  }

  public void setGoal() {
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

  public void generateWeight(List<Edge> neighbors) {
    for (Edge e : neighbors) {
      int i = e.getNode().getxCoord();
      int i2 = e.getStartNode().getxCoord();
      int w = i2 - i;
      e.setWeight(w);
    }
  }
}
