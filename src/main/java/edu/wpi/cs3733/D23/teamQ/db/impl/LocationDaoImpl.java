package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Location;
import java.sql.*;
import java.util.List;

public class LocationDaoImpl implements GenDao<Location, Integer> {
  private List<Location> locations;

  public LocationDaoImpl() {
    populate();
  }

  /**
   * returns a location given a nodeID
   *
   * @param nodeID of location being retrieved
   * @return a node with the given nodeID
   */
  public Location retrieveRow(Integer nodeID) {
    int index = this.getIndex(nodeID);
    return locations.get(index);
  }

  /**
   * updates location in linked list with a new location
   *
   * @param nodeID nodeID of location being replaced
   * @param newLocation new location being inserted
   * @return true if successful
   */
  public boolean updateRow(Integer nodeID, Location newLocation) {
    deleteRow(nodeID);
    addRow(newLocation);

    int index = this.getIndex(nodeID);
    locations.set(index, newLocation);
    return true;
  }

  /**
   * deletes location from list of locations
   *
   * @param nodeID of location being deleted
   * @return true if successfully deleted
   */
  public boolean deleteRow(Integer nodeID) {
    try (Connection connection = GenDao.connect();
        PreparedStatement st =
            connection.prepareStatement(
                "DELETE FROM \"conferenceRequest\" WHERE \"requestID\" = ?")) {;
      st.setInt(1, nodeID);
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int index = this.getIndex(nodeID);
    locations.remove(index);

    return true;
  }

  /**
   * adds a location to the list
   *
   * @param l location being added
   * @return true if successful
   */
  public boolean addRow(Location l) {
    try (Connection conn = GenDao.connect();
        PreparedStatement stmt =
            conn.prepareStatement(
                "INSERT INTO \"conferenceRequest\"(\"nodeID\", \"longName\", \"shortName\", \"nodeType\") VALUES (?, ?, ?, ?)")) {
      stmt.setInt(1, l.getNode().getNodeID());
      stmt.setString(2, l.getLongName());
      stmt.setString(3, l.getShortName());
      stmt.setString(4, l.getNodeType());
      stmt.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return locations.add(l);
  }

  public boolean populate() {
    try {
      Connection conn = GenDao.connect();
      Statement stm = conn.createStatement();
      ResultSet rst = stm.executeQuery("Select * From \"locationName\"");
      while (rst.next()) {
        locations.add(
            new Location(
                rst.getInt("nodeID"),
                rst.getString("longName"),
                rst.getString("shortName"),
                rst.getString("nodeType")));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return true;
  }

  /**
   * gets index of given nodeID in the list of locations
   *
   * @param nodeID nodeID being checked
   * @return value of index
   */
  private int getIndex(Integer nodeID) {
    for (int i = 0; i < locations.size(); i++) {
      Location l = locations.get(i);
      if (l.getNode().getNodeID() == nodeID) {
        return i;
      }
    }
    throw new RuntimeException("No location found with ID " + nodeID);
  }

  /**
   * function that gets all locations in the list
   *
   * @return all locations in list
   */
  public List<Location> getAllRows() {
    return locations;
  }
}
