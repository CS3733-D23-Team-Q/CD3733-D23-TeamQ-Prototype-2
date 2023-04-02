package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class star extends Edge {
  star(int weight, TestNode node) {
    super(weight, node);
  }

  public int getWeight(TestNode n, TestNode goal) {
    int xDist = goal.getX() - n.getX();
    int yDist = goal.getY() - n.getY();
    double trueDist = Math.sqrt(xDist * xDist + yDist * yDist);
    return (int) trueDist;
  }

  public static double calculateHeuristic(TestNode n, TestNode target) {
    int dx = Math.abs(n.getX() - target.getX());
    int dy = Math.abs(n.getY() - target.getY());
    int D = Math.abs(dx + dy);
    return D;
  }

  public static TestNode aStar(TestNode start, TestNode target) {
    PriorityQueue<TestNode> closedList = new PriorityQueue<>();
    PriorityQueue<TestNode> openList = new PriorityQueue<>();

    start.f = start.g + calculateHeuristic(start, target);
    openList.add(start);

    while (!openList.isEmpty()) {
      TestNode n = openList.peek();
      if (n == target) {
        return n;
      }

      for (Edge edge : n.neighbors) {
        TestNode m = edge.node;
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

  public static void printPath(TestNode target) {
    TestNode n = target;

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
