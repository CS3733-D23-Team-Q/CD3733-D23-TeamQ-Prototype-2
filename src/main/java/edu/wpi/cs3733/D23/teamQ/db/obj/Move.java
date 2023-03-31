package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Node node;
    private String longName;
    private String shortName;

    public Move(Node node, String longName, String shortName) {
        this.node = node;
        this.longName = longName;
        this.shortName = shortName;
    }

    public String toString(){
        return "node: "
                + this.node.getNodeID()
                + ", longName: "
                + this.longName
                + ", shortName: "
                + this.shortName;
    }
}
