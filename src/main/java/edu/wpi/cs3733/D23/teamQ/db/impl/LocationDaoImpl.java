package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.LocationDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Location;

import java.util.List;

public class LocationDaoImpl implements LocationDao {
    private List<Location> locations;

    /**
     * returns a location given a nodeID
     *
     * @param nodeID of location being retrieved
     * @return a node with the given nodeID
     */
    public Location retrieveRow(String nodeID) {
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
    public boolean updateRow(String nodeID, Location newLocation) {
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
    public boolean deleteRow(String nodeID) {
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
        return locations.add(l);
    }

    /**
     * gets index of given nodeID in the list of locations
     *
     * @param nodeID nodeID being checked
     * @return value of index
     */
    private int getIndex(String nodeID) {
        for (int i = 0; i < locations.size(); i++) {
            Location l = locations.get(i);
            if (l.getNode().getNodeID().equals(nodeID)) {
                return i;
            }
        }
        throw new RuntimeException("No location found with ID " + nodeID);
    }
}
