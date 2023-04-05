package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
  private int nodeID;
  private String longName;
  private String shortName;
  private String nodeType;

  /**
   * constructor to create a Location object
   * @param nodeID
   * @param longName
   * @param shortName
   * @param nodeType
   */
  public Location(int nodeID, String longName, String shortName, String nodeType) {
    this.nodeID = nodeID;
    this.longName = longName;
    this.shortName = shortName;
    this.nodeType = nodeType;
  }

  /**
   * Creates a string to display information on a given location
   * @return a String with location information
   */
  public String toString() {
    return "node: "
        + this.nodeID
        + ", longName: "
        + this.longName
        + ", shortName: "
        + this.shortName
        + ", nodeType: "
        + this.nodeType;
  }
}
