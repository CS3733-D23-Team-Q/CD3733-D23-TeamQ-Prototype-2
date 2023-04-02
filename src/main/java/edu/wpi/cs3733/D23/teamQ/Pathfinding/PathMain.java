package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.Node.aStar;
import static edu.wpi.cs3733.D23.teamQ.Pathfinding.Node.printPath;

public class PathMain {
  public static void main(String[] args) {

    Node head = new Node(0, 0);
    head.g = 0;

    Node n1 = new Node(1, 0);
    Node n2 = new Node(0, 1);

    head.addBranch(1, n1);
    head.addBranch(1, n2);

    Node n3 = new Node(1, 1);
    n1.addBranch(1, n3);
    n2.addBranch(1, n3);

    Node n4 = new Node(2, 1);
    n3.addBranch(1, n4);

    Node n5 = new Node(3, 1);
    n4.addBranch(1, n5);

    Node n6 = new Node(3, 0);
    Node n7 = new Node(4, 1);

    n5.addBranch(1, n6);
    n5.addBranch(1, n7);

    Node n8 = new Node(4, 0);
    n6.addBranch(1, n8);
    n7.addBranch(1, n8);
    n8.addBranch(1, n7);

    Node n9 = new Node(0, 2);
    n2.addBranch(1, n9);
    //
    Node n10 = new Node(1, 2);
    n3.addBranch(1, n10);
    n9.addBranch(1, n10);
    n10.addBranch(1, n3);
    n10.addBranch(1, n9);

    Node n11 = new Node(2, 2);
    n4.addBranch(1, n11);
    n10.addBranch(1, n11);
    n11.addBranch(1, n4);
    n11.addBranch(1, n10);

    Node n12 = new Node(3, 2);
    n5.addBranch(1, n12);
    n11.addBranch(1, n12);
    n12.addBranch(1, n5);
    n12.addBranch(1, n11);

    Node n13 = new Node(4, 2);
    n7.addBranch(1, n13);
    n12.addBranch(1, n13);
    n13.addBranch(1, n7);
    n13.addBranch(1, n12);
    //
    //        head.addBranch(1, n1);
    //        head.addBranch(5, n2);
    //        head.addBranch(2, n3);
    //        n3.addBranch(1, n2);
    //
    //        Node n4 = new Node(1);
    //        Node n5 = new Node(1);
    //        Node target = new Node(1,5);
    //
    //        n1.addBranch(n4.getWeight(n4, target), n4);
    //        n2.addBranch(4, n5);
    //        n3.addBranch(6, n4);
    //
    //        n4.addBranch(3, target);
    //        n5.addBranch(1, n4);
    //        n5.addBranch(3, target);

    Node res = aStar(head, n8);
    printPath(res);
  }
}
