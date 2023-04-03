package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.aStar;
import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.printPath;

public class PathMain {
  public static void main(String[] args) {

    newNode head = new newNode(0, 0);
    head.g = 0;

    newNode n1 = new newNode(0, 0);
    //    newNode n1 = new newNode(1, 0);
    newNode n2 = new newNode(1, 0);

    head.addBranch(1, n1);
    head.addBranch(1, n2);

    newNode n3 = new newNode(3, 0);

    newNode n4 = new newNode(1, 0);
    newNode n5 = new newNode(1, 4);
    newNode n6 = new newNode(2, 0);
    newNode n7 = new newNode(3, 4);
    newNode n9 = new newNode(4, 0);

    n2.addBranch(1, n3);
    n3.addBranch(1, n9);
    n4.addBranch(1, n5);
    n5.addBranch(1, n9);
    n6.addBranch(1, n7);
    n7.addBranch(1, n5);

    //    newNode n3 = new newNode(1, 1);
    //    n1.addBranch(1, n3);
    //    n2.addBranch(1, n3);
    //
    //    newNode n4 = new newNode(2, 1);
    //    n3.addBranch(1, n4);
    //
    //    newNode n5 = new newNode(3, 1);
    //    n4.addBranch(1, n5);
    //
    //    newNode n6 = new newNode(3, 0);
    //    newNode n7 = new newNode(4, 1);
    //
    //    n5.addBranch(1, n6);
    //    n5.addBranch(1, n7);
    //    n6.addBranch(1, n6);
    //    n7.addBranch(1, n5);
    //
    //    newNode n8 = new newNode(4, 0);
    //    n6.addBranch(1, n8);
    //    n7.addBranch(1, n8);
    //    n8.addBranch(1, n7);
    //    n8.addBranch(1, n6);
    //
    //    newNode n9 = new newNode(0, 2);
    //    n2.addBranch(1, n9);
    //    //
    //    newNode n10 = new newNode(1, 2);
    //    n3.addBranch(1, n10);
    //    n9.addBranch(1, n10);
    //    n10.addBranch(1, n3);
    //    n10.addBranch(1, n9);
    //
    //    newNode n11 = new newNode(2, 2);
    //    n4.addBranch(1, n11);
    //    n10.addBranch(1, n11);
    //    n11.addBranch(1, n4);
    //    n11.addBranch(1, n10);
    //
    //    newNode n12 = new newNode(3, 2);
    //    n5.addBranch(1, n12);
    //    n11.addBranch(1, n12);
    //    n12.addBranch(1, n5);
    //    n12.addBranch(1, n11);
    //
    //    newNode n13 = new newNode(4, 2);
    //    n7.addBranch(1, n13);
    //    n12.addBranch(1, n13);
    //    n13.addBranch(1, n7);
    //    n13.addBranch(1, n12);
    //
    newNode goal = n9;

    //    goal.setGoal();

    //    end goal = new end(temp.getxCoord(), temp.getYCoord());
    //    n8.getXCoord(), n8.getYCoord();

    //    goal.setGoal(n8);
    //    System.out.println("here " + goal.getClass());
    //    System.out.println("here " + goal);

    //    Edge why = new Edge();
    //    newNode iBegYou = new newNode(7, 22);
    //    iBegYou.setWeight();

    n1.generateWeight(n1.getNeighbors());
    n2.generateWeight(n2.getNeighbors());
    n3.generateWeight(n3.getNeighbors());
    n4.generateWeight(n4.getNeighbors());
    n5.generateWeight(n5.getNeighbors());
    n6.generateWeight(n6.getNeighbors());
    n7.generateWeight(n7.getNeighbors());
    //    n8.generateWeight(n1.getNeighbors());
    n9.generateWeight(n9.getNeighbors());
    //    n10.generateWeight(n1.getNeighbors());
    //    n11.generateWeight(n1.getNeighbors());
    //    n12.generateWeight(n1.getNeighbors());
    //    n13.generateWeight(n1.getNeighbors());

    newNode res = aStar(head, goal);
    printPath((newNode) res);

    //    System.out.println("y test" + res.getyCoord());
  }
}
