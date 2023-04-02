package edu.wpi.cs3733.D23.teamQ.Pathfinding;

public class Edge {
  private int weight;
  private Node node;

  Edge(int weight, Node node) {
    super();
    this.weight = weight;
    this.node = node;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Node getNode() {
    return node;
  }

  public void setNode(Node node) {
    this.node = node;
  }
}
