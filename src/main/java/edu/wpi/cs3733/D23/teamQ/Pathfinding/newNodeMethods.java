package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.List;

public class newNodeMethods extends newNode {

  private static int idCounter = 0;
  private int id;

  private List<Edge> neighbors;

  newNodeMethods(int xCoord, int yCoord) {
    super(xCoord, yCoord);
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  public List<Edge> getNeighbors() {
    return neighbors;
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

  public double getF() {
    return f;
  }

  @Override
  public int compareTo(newNode n) {
    return Double.compare(this.f, n.f);
  }

  public void addBranch(int weight, newNode newNode) {
    Edge newEdge = new Edge(weight, newNode);
    //    Edge inverseEdge = new Edge(weight, this);
    neighbors.add(newEdge);
    //    neighbors.add(inverseEdge);
  }
}
