package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.List;

public class Node implements Comparable<Node> {
  Node parent = null;

  private List<Edge> neighbors;
  //  // Evaluation functions
  double f = Double.MAX_VALUE;
  double g = Double.MAX_VALUE;
  private int xCoord;
  private int yCoord;

  Node(int xCoord, int yCoord) {
    this.xCoord = xCoord;
    this.yCoord = yCoord;
  }

  public List<Edge> getNeighbors() {
    return neighbors;
  }

  public double getF() {
    return f;
  }

  //  @Override
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }

  public int getxCoord() {
    return xCoord;
  }

  public int getyCoord() {
    return yCoord;
  }
}
