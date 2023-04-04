package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
  private int edgeID;
  private Node startNode;
  private Node endNode;

  public Edge(int edgeID, Node startNode, Node endNode) {
    this.edgeID = edgeID;
    this.startNode = startNode;
    this.endNode = endNode;
  }

  public String edgeToString() {
    return "edgeID: "
        + this.edgeID
        + ", startNode: "
        + this.startNode
        + ", endNode: "
        + this.endNode;
  }
}
