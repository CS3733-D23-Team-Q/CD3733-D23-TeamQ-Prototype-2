package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.List;

public class TestNode implements Comparable<TestNode>, Inode {
  // ID for readability of result purposes
  private static int idCounter = 0;
  public int id;

  // Parent in the path
  public TestNode parent = null;

  public List<Edge> neighbors;

  // Evaluation functions
  public double f = Double.MAX_VALUE;
  public double g = Double.MAX_VALUE;

  private int xCoord;
  private int yCoord;

  // Hardcoded heuristic
  //    public double h;

  TestNode(int xCoord, int yCoord) {
    //        this.h = h;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  @Override
  public int compareTo(TestNode n) {
    return Double.compare(this.f, n.f);
  }

  public void addBranch(int weight, TestNode node) {
    Edge newEdge = new Edge(weight, node);
    Edge inverseEdge = new Edge(weight, this);
    neighbors.add(newEdge);
    neighbors.add(inverseEdge);
  }

  @Override
  public int getNodeID() {
    return this.getNodeID();
  }

  @Override
  public int getX() {
    return this.getX();
  }

  @Override
  public int getY() {
    return this.getY();
  }

  //        int dx = Math.abs(n.getxCoord() - goal.getxCoord());
  //        int dy = Math.abs(n.getyCoord() - goal.getyCoord());
  //        int D = Math.abs(dx+dy);
  //        return D * (dx + dy);

}
