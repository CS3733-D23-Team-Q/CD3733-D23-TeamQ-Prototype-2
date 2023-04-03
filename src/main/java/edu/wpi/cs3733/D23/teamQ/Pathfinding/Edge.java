package edu.wpi.cs3733.D23.teamQ.Pathfinding;

public class Edge extends newNode {
  //  private int weight;
  private newNode newNode;

  Edge(int weight, newNode newNode) {

    this.setWeight(weight);
    this.newNode = newNode;
  }

  //  public int getWeight() {
  //    //    int xDist = getGoal().getXCoord() - this.getNode().getXCoord();
  //    //    int yDist = getGoal().getYCoord() - this.getNode().getyCoord();
  //    //    int yDist = getGoal().getYCoord() - this.getyCoord();
  //    //    int yDist2 = getGoal().getYCoord();
  //    //    System.out.println("here: " + yDist2);
  //    //    newNode please = getGoal();
  //    //    please.getyCoord();
  //    //    System.out.println(please.getYCoord());
  //    return weight;

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

  //  public int getWeight() {
  //    return weight;
  //  }

  //  formula: xDist = target.getX() - source.getX();
  // *          yDist = target.getY() - source.getY()
  //          *          trueDist =  Math.sqrt(xDist * xDist + yDist * yDist);

  //  public void setWeight(newNode n) {
  //    int w = calculateWeight();
  //    this.weight = w;
  //  }
  //

  //  public void setWeight(int weight) {
  //    this.weight = weight;
  //  }

  //  public void setWeight() {
  //    int temp = this.newNode.getxCoord();
  //    System.out.println("please please please: " + temp);
  //  }

  //  public int calculateWeight() {
  //    newNode pleaseEndmMe = new newNode(12, 15);
  //    System.out.println(pleaseEndmMe.getYCoord());
  //    pleaseEndmMe.setGoal();
  //    int yDist2 = getGoal().getYCoord();

  //    int yDist2 = getGoal().getYCoord();
  //    int yDist2 = pleaseEndmMe.getyCoord();
  //    return yDist2;
  //  }

  public newNode getNode() {
    return newNode;
  }

  public void setNode(newNode newNode) {
    this.newNode = newNode;
  }
}
