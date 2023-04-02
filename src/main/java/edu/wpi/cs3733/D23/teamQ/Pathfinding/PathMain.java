package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.aStar;
import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.printPath;

public class PathMain {
  public static void main(String[] args) {

    //test 

    TestNode head = new TestNode(0, 0);
    head.g = 0;

    TestNode n1 = new TestNode(1, 0);
    TestNode n2 = new TestNode(0, 1);

    head.addBranch(1, n1);
    head.addBranch(1, n2);

    TestNode n3 = new TestNode(1, 1);
    n1.addBranch(1, n3);
    n2.addBranch(1, n3);

    TestNode n4 = new TestNode(2, 1);
    n3.addBranch(1, n4);

    TestNode n5 = new TestNode(3, 1);
    n4.addBranch(1, n5);

    TestNode n6 = new TestNode(3, 0);
    TestNode n7 = new TestNode(4, 1);

    n5.addBranch(1, n6);
    n5.addBranch(1, n7);

    TestNode n8 = new TestNode(4, 0);
    n6.addBranch(1, n8);
    n7.addBranch(1, n8);
    n8.addBranch(1, n7);

    TestNode n9 = new TestNode(0, 2);
    n2.addBranch(1, n9);
    //
    TestNode n10 = new TestNode(1, 2);
    n3.addBranch(1, n10);
    n9.addBranch(1, n10);
    n10.addBranch(1, n3);
    n10.addBranch(1, n9);

    TestNode n11 = new TestNode(2, 2);
    n4.addBranch(1, n11);
    n10.addBranch(1, n11);
    n11.addBranch(1, n4);
    n11.addBranch(1, n10);

    TestNode n12 = new TestNode(3, 2);
    n5.addBranch(1, n12);
    n11.addBranch(1, n12);
    n12.addBranch(1, n5);
    n12.addBranch(1, n11);

    TestNode n13 = new TestNode(4, 2);
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

    TestNode res = aStar(head, n8);
    printPath(res);
  }
}
