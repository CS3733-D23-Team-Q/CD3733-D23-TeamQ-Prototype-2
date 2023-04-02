package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.aStar;
import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.printPath;

public class PathMain {
  public static void main(String[] args) {

    nodeMethods head = new nodeMethods(0, 0);
    head.g = 0;

    nodeMethods n1 = new nodeMethods(1, 0);
    nodeMethods n2 = new nodeMethods(0, 1);

    head.addBranch(1, n1);
    head.addBranch(1, n2);

    nodeMethods n3 = new nodeMethods(1, 1);
    n1.addBranch(1, n3);
    n2.addBranch(1, n3);

    nodeMethods n4 = new nodeMethods(2, 1);
    n3.addBranch(1, n4);

    nodeMethods n5 = new nodeMethods(3, 1);
    n4.addBranch(7, n5);

    nodeMethods n6 = new nodeMethods(3, 0);
    nodeMethods n7 = new nodeMethods(4, 1);

    n5.addBranch(1, n6);
    n5.addBranch(1, n7);
    n6.addBranch(1, n6);
    n7.addBranch(1, n5);

    nodeMethods n8 = new nodeMethods(4, 0);
    n6.addBranch(1, n8);
    n7.addBranch(1, n8);
    n8.addBranch(1, n7);
    n8.addBranch(1, n6);

    nodeMethods n9 = new nodeMethods(0, 2);
    n2.addBranch(1, n9);
    //
    nodeMethods n10 = new nodeMethods(1, 2);
    n3.addBranch(1, n10);
    n9.addBranch(1, n10);
    n10.addBranch(1, n3);
    n10.addBranch(1, n9);

    nodeMethods n11 = new nodeMethods(2, 2);
    n4.addBranch(1, n11);
    n10.addBranch(1, n11);
    n11.addBranch(1, n4);
    n11.addBranch(1, n10);

    nodeMethods n12 = new nodeMethods(3, 2);
    n5.addBranch(1, n12);
    n11.addBranch(1, n12);
    n12.addBranch(1, n5);
    n12.addBranch(1, n11);

    nodeMethods n13 = new nodeMethods(4, 2);
    n7.addBranch(1, n13);
    n12.addBranch(1, n13);
    n13.addBranch(1, n7);
    n13.addBranch(7, n12);

    Node res = aStar(head, n8);
    printPath((nodeMethods) res);
  }
}
