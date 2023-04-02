package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Node implements Comparable<Node> {
  // Id for readability of result purposes
  private static int idCounter = 0;
  public int id;

  // Parent in the path
  public Node parent = null;

  public List<Edge> neighbors;

  // Evaluation functions
  public double f = Double.MAX_VALUE;
  public double g = Double.MAX_VALUE;

  private int xCoord;
  private int yCoord;

  // Hardcoded heuristic
  //    public double h;

  Node(int xCoord, int yCoord) {
    //        this.h = h;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  @Override
  public int compareTo(Node n) {
    return Double.compare(this.f, n.f);
  }

  //    public static class Edge {
  //        private final Node one;
  //        private final Node two;
  //
  //        //        Edge(int weight, Node node){
  ////            this.weight = weight;
  ////            this.node = node;
  ////        }
  //        Edge(Node one, Node two){
  //            this.one = one;
  //            this.two = two;
  //        }

  public static class Edge {
    Edge(int weight, Node node) {
      this.weight = weight;
      this.node = node;
    }

    public int weight;
    public Node node;
  }

  public int weight;
  public Node node;

  public void addBranch(int weight, Node node) {
    Edge newEdge = new Edge(weight, node);
    Edge inverseEdge = new Edge(weight, this);
    neighbors.add(newEdge);
    neighbors.add(inverseEdge);
  }

  public int getWeight(Node n, Node goal) {
    int xDist = goal.getxCoord() - n.getxCoord();
    int yDist = goal.getyCoord() - n.getyCoord();
    double trueDist = Math.sqrt(xDist * xDist + yDist * yDist);
    return (int) trueDist;
  }

  public static double calculateHeuristic(Node n, Node target) {
    int dx = Math.abs(n.getxCoord() - target.getxCoord());
    int dy = Math.abs(n.getyCoord() - target.getyCoord());
    int D = Math.abs(dx + dy);
    return D;
  }

  public int getxCoord() {
    return xCoord;
  }

  public int getyCoord() {
    return yCoord;
  }

  //        int dx = Math.abs(n.getxCoord() - goal.getxCoord());
  //        int dy = Math.abs(n.getyCoord() - goal.getyCoord());
  //        int D = Math.abs(dx+dy);
  //        return D * (dx + dy);

  public static Node aStar(Node start, Node target) {
    PriorityQueue<Node> closedList = new PriorityQueue<>();
    PriorityQueue<Node> openList = new PriorityQueue<>();

    start.f = start.g + calculateHeuristic(start, target);
    openList.add(start);

    while (!openList.isEmpty()) {
      Node n = openList.peek();
      if (n == target) {
        return n;
      }

      for (Node.Edge edge : n.neighbors) {
        Node m = edge.node;
        double totalWeight = n.g + edge.weight;

        if (!openList.contains(m) && !closedList.contains(m)) {
          m.parent = n;
          m.g = totalWeight;
          m.f = m.g + calculateHeuristic(m, target);
          openList.add(m);
        } else {
          if (totalWeight < m.g) {
            m.parent = n;
            m.g = totalWeight;
            m.f = m.g + calculateHeuristic(m, target);

            if (closedList.contains(m)) {
              closedList.remove(m);
              openList.add(m);
            }
          }
        }
      }

      openList.remove(n);
      closedList.add(n);
    }
    return null;
  }

  public static void printPath(Node target) {
    Node n = target;

    if (n == null) return;

    List<Integer> ids = new ArrayList<>();

    while (n.parent != null) {
      ids.add(n.id);
      n = n.parent;
    }
    ids.add(n.id);
    Collections.reverse(ids);

    for (int id : ids) {
      System.out.print(id + " ");
    }
    System.out.println("");
  }
}
