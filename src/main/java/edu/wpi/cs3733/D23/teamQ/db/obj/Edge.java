package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge{
  private int edgeID;
  private Node startNode;
  private Node endNode;

  Edge(int edgeID, Node startNode, Node endNode) {
    this.edgeID = edgeID;
    this.startNode = startNode;
    this.endNode = endNode;
  }

  public Edge() {
  }

  public String edgeToString() {
    return "edgeID: "
        + this.edgeID
        + ", startNode: "
        + this.startNode
        + ", endNode: "
        + this.endNode;
  }

  public int getWeight() {
    int xDist = this.getStartNode().getXCoord() - this.getEndNode().getXCoord();
    int yDist = this.getStartNode().getYCoord() - this.getEndNode().getYCoord();
    int weight = (int) Math.sqrt(xDist * xDist + yDist * yDist);
    return weight;
  }



}
