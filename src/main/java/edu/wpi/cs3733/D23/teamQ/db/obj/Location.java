package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
  private Node node;
  private String longName;
  private String shortName;
  private String nodeType;

  public Location(String longName, String shortName, String nodeType) {
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
