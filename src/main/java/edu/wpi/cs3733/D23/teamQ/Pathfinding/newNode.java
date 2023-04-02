package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import edu.wpi.cs3733.D23.teamQ.db.obj.Node;
import java.util.List;

public class newNode extends Node implements Comparable<newNode> {
  newNode parent = null;

  private List<Edge> neighbors;
  //  // Evaluation functions
  double f = Double.MAX_VALUE;
  double g = Double.MAX_VALUE;
  private int xCoord;
  private int yCoord;

  newNode(int xCoord, int yCoord) {
    super(xCoord, yCoord);
  }

  public List<Edge> getNeighbors() {
    return neighbors;
  }

  public double getF() {
    return f;
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
}
