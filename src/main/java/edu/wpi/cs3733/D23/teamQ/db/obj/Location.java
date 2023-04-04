package edu.wpi.cs3733.D23.teamQ.db.obj;

import edu.wpi.cs3733.D23.teamQ.db.impl.LocationDaoImpl;
import edu.wpi.cs3733.D23.teamQ.db.impl.NodeDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;

@Getter
@Setter
public class Location {
  private Node node;
  private String longName;
  private String shortName;
  private String nodeType;

  public Location(int nodeID, String longName, String shortName, String nodeType) {
    NodeDaoImpl requestN = new NodeDaoImpl();
    this.node = requestN.retrieveRow(nodeID);
    this.longName = longName;
    this.shortName = shortName;
    this.nodeType = nodeType;
  }

  public String toString() {
    return "node: "
        + this.node.getNodeID()
        + ", longName: "
        + this.longName
        + ", shortName: "
        + this.shortName
        + ", nodeType: "
        + this.nodeType;
  }
}
