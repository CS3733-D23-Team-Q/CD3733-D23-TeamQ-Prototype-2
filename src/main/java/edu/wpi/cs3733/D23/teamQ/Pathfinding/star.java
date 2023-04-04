package edu.wpi.cs3733.D23.teamQ.Pathfinding;


import edu.wpi.cs3733.D23.teamQ.db.obj.Edge;
import edu.wpi.cs3733.D23.teamQ.db.obj.Node;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class star extends Edge {

  public star() {
    super();
  }

  public static double calculateHeuristic(Node n, Node target) {
    int dx = Math.abs(n.getXCoord() - target.getYCoord());
    int dy = Math.abs(n.getYCoord() - target.getYCoord());
    int D = Math.abs(dx + dy);
    return D;
  }

  public static Node aStar(Node start, Node target) {
    PriorityQueue<Node> closedList = new PriorityQueue<>();
    PriorityQueue<Node> openList = new PriorityQueue<>();

    start.setF(start.getG() + calculateHeuristic(start, target));
    openList.add(start);

    while (!openList.isEmpty()) {
      Node n = openList.peek();
      if (n == target) {
        return n;
      }

      for (Edge edge : n.getEdges()) {
        Node m = edge.getStartNode();
        double totalWeight = n.getG() + edge.getWeight();

        if (!openList.contains(m) && !closedList.contains(m)) {
          m.setParent(n);
          m.setG(totalWeight);
          m.setF(m.getG() + calculateHeuristic(m, target));
          openList.add(m);
        } else {
          if (totalWeight < m.getG()) {
            m.setParent(n);
            m.setG(totalWeight);
            m.setF(m.getG() + calculateHeuristic(m, target));

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

    while (n.getParent() != null) {
      ids.add(n.getNodeID());
      n = (Node) n.getParent();
    }
    ids.add(n.getNodeID());
    Collections.reverse(ids);

    for (int id : ids) {
      System.out.print(id + " ");
    }
    System.out.println("");
  }
}
