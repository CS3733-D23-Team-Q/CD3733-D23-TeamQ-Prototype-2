package edu.wpi.cs3733.D23.teamQ.Pathfinding;

public class Edge {
  private int weight;
  private newNode newNode;

  Edge(int weight, newNode newNode) {
    this.weight = weight;
    this.newNode = newNode;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public newNode getNode() {
    return newNode;
  }

  public void setNode(newNode newNode) {
    this.newNode = newNode;
  }
}
