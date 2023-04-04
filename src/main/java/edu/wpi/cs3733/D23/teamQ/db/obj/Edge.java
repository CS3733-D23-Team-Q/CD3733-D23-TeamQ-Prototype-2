package edu.wpi.cs3733.D23.teamQ.db.obj;

import edu.wpi.cs3733.D23.teamQ.Pathfinding.newNode;
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
    // int yDist = getGoal().getYCoord() - this.getyCoord();
    // int yDist2 = getGoal().getYCoord();
    // System.out.println("here: " + yDist2);
    // newNode please = getGoal();
    // please.getyCoord();
    // System.out.println(please.getYCoord());
    int weight = (int) Math.sqrt(xDist * xDist + yDist * yDist);
    return weight;
  }

  public void addBranch(Node node1, Node node2) {
    Edge branch = new Edge(this.getEdgeID(), node1, node2);
    //    Edge inverseEdge = new Edge(weight, this);
    branch.set
    edges.add(branch);
    //    neighbors.add(inverseEdge);
  }

}
