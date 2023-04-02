package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.List;

public class Node implements Comparable<Node> {
  // Id for readability of result purposes
  //  private static int idCounter = 0;
  //  private int id;

  // Parent in the path
  Node parent = null;

  private List<Edge> neighbors;
  //
  //  // Evaluation functions
  double f = Double.MAX_VALUE;
  double g = Double.MAX_VALUE;
  private int xCoord;
  private int yCoord;

  Node(int xCoord, int yCoord) {
    //        this.h = h;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    //    this.id = idCounter++;
    //    this.neighbors = new ArrayList<>();
  }
  //
  public List<Edge> getNeighbors() {
    return neighbors;
  }
  //
  //  public static int getIdCounter() {
  //    return idCounter;
  //  }
  //
  //  public int getId() {
  //    return id;
  //  }
  //
  //  public Node getParent() {
  //    return parent;
  //  }
  //
  public double getF() {
    return f;
  }
  //
  //  @Override
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }
  //
  //  public void addBranch(int weight, Node node) {
  //    Edge newEdge = new Edge(weight, node);
  //    Edge inverseEdge = new Edge(weight, this);
  //    neighbors.add(newEdge);
  //    neighbors.add(inverseEdge);
  //  }

  public int getxCoord() {
    return xCoord;
  }

  public int getyCoord() {
    return yCoord;
  }
}
