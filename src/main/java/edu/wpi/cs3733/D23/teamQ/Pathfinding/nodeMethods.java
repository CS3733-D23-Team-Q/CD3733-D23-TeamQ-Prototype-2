package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.List;

public class nodeMethods extends Node {

  private static int idCounter = 0;
  private int id;

  private List<Edge> neighbors;

  nodeMethods(int xCoord, int yCoord) {
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

  public Node getParent() {
    return parent;
  }

  public double getF() {
    return f;
  }

  @Override
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }

  public void addBranch(int weight, Node node) {
    Edge newEdge = new Edge(weight, node);
    //    Edge inverseEdge = new Edge(weight, this);
    neighbors.add(newEdge);
    //    neighbors.add(inverseEdge);
  }
}
