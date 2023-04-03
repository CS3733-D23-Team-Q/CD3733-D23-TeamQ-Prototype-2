package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class star extends Edge {
  star(int weight, newNode newNode) {
    super(weight, newNode);
  }

  //  public int getWeight(newNode n, newNode goal) {
  //    int xDist = goal.getxCoord() - n.getxCoord();
  //    int yDist = goal.getyCoord() - n.getyCoord();
  //    int trueDist = (int) Math.sqrt(xDist * xDist + yDist * yDist);
  //    return trueDist;
  //  }

  public static double calculateHeuristic(newNode n, newNode target) {
    int dx = Math.abs(n.getxCoord() - target.getxCoord());
    int dy = Math.abs(n.getyCoord() - target.getyCoord());
    int D = Math.abs(dx + dy);
    return D;
  }

  public static newNode aStar(newNode start, newNode target) {
    PriorityQueue<newNode> closedList = new PriorityQueue<>();
    PriorityQueue<newNode> openList = new PriorityQueue<>();

    start.f = start.g + calculateHeuristic(start, target);
    openList.add(start);

    while (!openList.isEmpty()) {
      newNode n = openList.peek();
      if (n == target) {
        return n;
      }

      for (Edge edge : n.getNeighbors()) {
        newNode m = edge.getNode();
        double totalWeight = n.g + edge.getWeight();

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

  public static void printPath(newNode target) {
    newNode n = target;

    if (n == null) return;

    List<Integer> ids = new ArrayList<>();

    while (n.parent != null) {
      ids.add(n.getId());
      n = (newNode) n.parent;
    }
    ids.add(n.getId());
    Collections.reverse(ids);

    for (int id : ids) {
      System.out.print(id + " ");
    }
    System.out.println("");
  }
}
