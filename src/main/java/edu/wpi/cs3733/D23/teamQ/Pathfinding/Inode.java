package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import edu.wpi.cs3733.D23.teamQ.db.obj.Node;

public interface Inode {

    public int getNodeID(Node Anode);

    public int getX(Node Anode);
    public int getY(Node Anode);
}
