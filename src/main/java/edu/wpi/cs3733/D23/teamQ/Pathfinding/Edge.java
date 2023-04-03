package edu.wpi.cs3733.D23.teamQ.Pathfinding;

public class Edge extends newNode {
  private int weight;
  private newNode newNode;

  Edge(int weight, newNode newNode) {

    this.weight = weight;
    this.newNode = newNode;
  }

  //  public int getWeight() {
  //    int xDist = getGoal().getXCoord() - this.getNode().getXCoord();
  //    int yDist = getGoal().getYCoord() - this.getNode().getyCoord();
  //  int xDist = getGoal().getXCoord() - this.getXCoord();
  //    int yDist = getGoal().getYCoord() - this.getyCoord();
  //    //
  //    double temp = Math.sqrt(xDist * xDist + yDist * yDist);
  //    //        int weight = Math.toIntExact(temp);
  //    int please = (int) Math.round(temp);

  //    int xTest = this.getXCoord();
  //    int yTest = this.getYCoord();
  //    double temp = Math.sqrt(xTest * xTest + yTest * yTest);
  //    int please = (int) Math.round(temp);
  //
  //    //    int test = this.getXCoord();
  //
  //    return please;
  //  }

  public int getWeight() {
    return weight;
  }

  //  formula: xDist = target.getX() - source.getX();
  // *          yDist = target.getY() - source.getY()
  //          *          trueDist =  Math.sqrt(xDist * xDist + yDist * yDist);

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
