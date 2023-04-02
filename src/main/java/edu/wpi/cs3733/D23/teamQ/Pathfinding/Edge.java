package edu.wpi.cs3733.D23.teamQ.Pathfinding;

public class Edge {
  public int weight;
  public TestNode node;

  Edge(int weight, TestNode node) {
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

  public TestNode getNode() {
    return node;
  }

  public void setNode(TestNode node) {
    this.node = node;
  }
}
