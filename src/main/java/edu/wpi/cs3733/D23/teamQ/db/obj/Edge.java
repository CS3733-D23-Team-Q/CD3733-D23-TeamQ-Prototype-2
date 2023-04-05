package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
  private int edgeID;
  private Node startNode;
  private Node endNode;

  /**
   * constructor to create an Edge object
   * @param edgeID
   * @param startNode
   * @param endNode
   */
  public Edge(int edgeID, Node startNode, Node endNode) {
    this.edgeID = edgeID;
    this.startNode = startNode;
    this.endNode = endNode;
  }

  public Edge(Node startNode, Node endNode) {
    this.startNode = startNode;
    this.endNode = endNode;
  }

  public Edge() {}

  /**
   * Creates a string to display information on a given edge
   * @return a String with edge information
   */
  public String edgeToString() {
    return "edgeID: "
        + this.edgeID
        + ", startNode: "
        + this.startNode
        + ", endNode: "
        + this.endNode;
  }

  /**
   * Gets weight of an edge using coordinates of
   * an edges start and end node
   * @return calculated weight
   */
  public int getWeight() {
    int xDist = Math.abs(this.getStartNode().getXCoord() - this.getEndNode().getXCoord());
    int yDist = Math.abs(this.getStartNode().getYCoord() - this.getEndNode().getYCoord());
    int weight = (int) Math.sqrt(xDist * xDist + yDist * yDist);
    return weight;
  }
}
