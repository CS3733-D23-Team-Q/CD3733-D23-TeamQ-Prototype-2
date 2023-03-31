package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;
import java.util.List;

public class FlowerRequestDaoImpl implements GenDao<FlowerRequest, Integer> {
  private List<FlowerRequest> flowerRequests;

  /**
   * returns a flowerRequest given a requestID
   *
   * @param requestID of conferenceRequest being retrieved
   * @return a conferenceRequest with the given nodeID
   */
  public FlowerRequest retrieveRow(Integer requestID) {
    int index = this.getIndex(requestID);
    return flowerRequests.get(index);
  }

  /**
   * updates flowerRequest in list with a new flowerRequest
   *
   * @param requestID requestID of conferenceRequest being replaced
   * @param newRequest new conferenceRequest being inserted
   * @return true if successful
   */
  public boolean updateRow(Integer requestID, FlowerRequest newRequest) {
    int index = this.getIndex(requestID);
    flowerRequests.set(index, newRequest);
    return true;
  }

  /**
   * deletes flowerRequest from list of flowerRequests
   *
   * @param requestID of flowerRequest being deleted
   * @return true if successfully deleted
   */
  public boolean deleteRow(Integer requestID) {
    int index = this.getIndex(requestID);
    flowerRequests.remove(index);
    return true;
  }

  /**
   * adds a flowerRequest to the list
   *
   * @param x flowerRequest being added
   * @return true if successful
   */
  public boolean addRow(FlowerRequest x) {
    return flowerRequests.add(x);
  }

  /**
   * gets index of given request in the list of requests
   *
   * @param requestID requestID being checked
   * @return value of index
   */
  private int getIndex(Integer requestID) {
    for (int i = 0; i < flowerRequests.size(); i++) {
      FlowerRequest x = flowerRequests.get(i);
      if (x.getRequestID() == requestID) {
        return i;
      }
    }
    throw new RuntimeException("No move found with ID " + requestID);
  }

  /**
   * function that gets all flower requests in the list
   *
   * @return all flower requests in list
   */
  public List<FlowerRequest> getAllRows() {
    return flowerRequests;
  }
}
