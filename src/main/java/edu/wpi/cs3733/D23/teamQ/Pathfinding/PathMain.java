package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.aStar;
import static edu.wpi.cs3733.D23.teamQ.Pathfinding.star.printPath;

public class PathMain {
  public static void main(String[] args) {

    newNodeMethods head = new newNodeMethods(0, 0);
    head.g = 0;

    newNodeMethods n1 = new newNodeMethods(1, 0);
    newNodeMethods n2 = new newNodeMethods(0, 1);

    head.addBranch(1, n1);
    head.addBranch(1, n2);

    newNodeMethods n3 = new newNodeMethods(1, 1);
    n1.addBranch(1, n3);
    n2.addBranch(1, n3);

    newNodeMethods n4 = new newNodeMethods(2, 1);
    n3.addBranch(1, n4);

    newNodeMethods n5 = new newNodeMethods(3, 1);
    n4.addBranch(7, n5);

    newNodeMethods n6 = new newNodeMethods(3, 0);
    newNodeMethods n7 = new newNodeMethods(4, 1);

    n5.addBranch(1, n6);
    n5.addBranch(1, n7);
    n6.addBranch(1, n6);
    n7.addBranch(1, n5);

    newNodeMethods n8 = new newNodeMethods(4, 0);
    n6.addBranch(1, n8);
    n7.addBranch(1, n8);
    n8.addBranch(1, n7);
    n8.addBranch(1, n6);

    newNodeMethods n9 = new newNodeMethods(0, 2);
    n2.addBranch(1, n9);
    //
    newNodeMethods n10 = new newNodeMethods(1, 2);
    n3.addBranch(1, n10);
    n9.addBranch(1, n10);
    n10.addBranch(1, n3);
    n10.addBranch(1, n9);

    newNodeMethods n11 = new newNodeMethods(2, 2);
    n4.addBranch(1, n11);
    n10.addBranch(1, n11);
    n11.addBranch(1, n4);
    n11.addBranch(1, n10);

    newNodeMethods n12 = new newNodeMethods(3, 2);
    n5.addBranch(1, n12);
    n11.addBranch(1, n12);
    n12.addBranch(1, n5);
    n12.addBranch(1, n11);

    newNodeMethods n13 = new newNodeMethods(4, 2);
    n7.addBranch(1, n13);
    n12.addBranch(1, n13);
    n13.addBranch(1, n7);
    n13.addBranch(7, n12);

    newNode res = aStar(head, n8);
    printPath((newNodeMethods) res);
  }
}
