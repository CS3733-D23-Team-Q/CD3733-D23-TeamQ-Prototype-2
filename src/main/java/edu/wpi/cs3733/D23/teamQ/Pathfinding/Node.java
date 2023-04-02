package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
  // Id for readability of result purposes
  private static int idCounter = 0;
  public int id;

  // Parent in the path
  public Node parent = null;

  public List<Edge> neighbors;

  // Evaluation functions
  public double f = Double.MAX_VALUE;
  public double g = Double.MAX_VALUE;

  private int xCoord;
  private int yCoord;

  // Hardcoded heuristic
  //    public double h;

  Node(int xCoord, int yCoord) {
    //        this.h = h;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  @Override
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }

  public void addBranch(int weight, Node node) {
    Edge newEdge = new Edge(weight, node);
    Edge inverseEdge = new Edge(weight, this);
    neighbors.add(newEdge);
    neighbors.add(inverseEdge);
  }

  public int getxCoord() {
    return xCoord;
  }

  public int getyCoord() {
    return yCoord;
  }

  //        int dx = Math.abs(n.getxCoord() - goal.getxCoord());
  //        int dy = Math.abs(n.getyCoord() - goal.getyCoord());
  //        int D = Math.abs(dx+dy);
  //        return D * (dx + dy);

}
