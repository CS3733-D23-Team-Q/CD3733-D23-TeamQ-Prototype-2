package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.aStar;
import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.printPath;

import edu.wpi.cs3733.D23.teamQ.db.obj.Node;

public class PathMain {
  public static void main(String[] args) {
    Node head = new Node(0, 0);
    head.setG(0);
    Node n1 = new Node(1, 2);
    Node n2 = new Node(3, 1);
    Node n3 = new Node(2, 2);
    Node n4 = new Node(3, 3);
    Node n5 = new Node(4, 3);
    Node n6 = new Node(4, 1);
    Node n7 = new Node(5, 2);
    Node n8 = new Node(5, 1);
    Node n9 = new Node(2, 3);
    Node n10 = new Node(3, 4);
    Node n11 = new Node(4, 4);
    Node n12 = new Node(5, 5);
    Node n13 = new Node(6, 4);
    Node goal = n8;
    head.addBranch(n1, 1);
    head.addBranch(n2, 2);
    n1.addBranch(n3, 3);
    n2.addBranch(n3, 3);
    n2.addBranch(n9, 9);
    n9.addBranch(n10, 10);
    n10.addBranch(n11, 11);
    n10.addBranch(n3, 3);
    n3.addBranch(n4, 4);
    n4.addBranch(n11, 11);
    n11.addBranch(n12, 12);
    n12.addBranch(n13, 13);
    n12.addBranch(n5, 5);
    n5.addBranch(n6, 6);
    n5.addBranch(n7, 7);
    n6.addBranch(n8, 8);
    n7.addBranch(n8, 8);
    Node res = aStar(n1, goal);
    printPath(res);
  }
}
