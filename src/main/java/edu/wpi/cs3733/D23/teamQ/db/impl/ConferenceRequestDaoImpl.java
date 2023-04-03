package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRequestDaoImpl implements GenDao<ConferenceRequest, Integer> {
  private List<ConferenceRequest> conferenceRequests = new ArrayList<ConferenceRequest>();

  public ConferenceRequestDaoImpl() throws SQLException {
    populate();
  }
  /**
   * returns a conferenceRequest given a requestID
   *
   * @param requestID of conferenceRequest being retrieved
   * @return a conferenceRequest with the given nodeID
   */
  public ConferenceRequest retrieveRow(Integer requestID) {
    int index = this.getIndex(requestID);
    return conferenceRequests.get(index);
  }

  /**
   * updates conferenceRequest in list with a new conferenceRequest
   *
   * @param requestID requestID of conferenceRequest being replaced
   * @param newRequest new conferenceRequest being inserted
   * @return true if successful
   */
  public boolean updateRow(Integer requestID, ConferenceRequest newRequest) throws SQLException {

    int index = this.getIndex(requestID);
    conferenceRequests.set(index, newRequest);

    deleteRow(requestID);
    addRow(newRequest);

    return true;
  }

  /**
   * deletes conferenceRequest from list of conferenceRequests
   *
   * @param requestID of conferenceRequest being deleted
   * @return true if successfully deleted
   */
  public boolean deleteRow(Integer requestID) throws SQLException {
    try (Connection connection = GenDao.connect();
        PreparedStatement st =
            connection.prepareStatement(
                "DELETE FROM \"conferenceRequest\" WHERE \"requestID\" = ?")) {;
      st.setInt(1, requestID);
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int index = this.getIndex(requestID);
    conferenceRequests.remove(index);

    return true;
  }

  /**
   * adds a conferenceRequest to the list
   *
   * @param x conferenceRequest being added
   * @return true if successful
   */
  public boolean addRow(ConferenceRequest x) {
    try (Connection conn = GenDao.connect();
        PreparedStatement stmt =
            conn.prepareStatement(
                "INSERT INTO \"conferenceRequest\"(\"requestID\", requester, progress, assignee, \"specialInstructions\", \"time\", \"foodChoice\", \"roomNum\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
      stmt.setInt(1, x.getRequestID());
      stmt.setString(2, x.getRequester());
      stmt.setInt(3, x.getProgress());
      stmt.setString(4, x.getAssignee());
      stmt.setString(5, x.getSpecialInstructions());
      stmt.setString(6, x.getDateTime());
      stmt.setString(7, x.getFoodChoice());
      stmt.setString(8, x.getRoomNumber());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    conferenceRequests.add(x);
    return true;
  }

  @Override
  public boolean populate() throws SQLException {
    try {
      Connection conn = GenDao.connect();
      Statement stm = conn.createStatement();
      String sql = "Select * From \"conferenceRequest\"";
      ResultSet rst = stm.executeQuery(sql);
      while (rst.next()) {
        ConferenceRequest conferenceRequest =
            new ConferenceRequest(
                rst.getInt("requestID"),
                rst.getString("progress"),
                rst.getInt("requester"),
                rst.getString("assignee"),
                rst.getString("roomNum"),
                rst.getString("specialInstructions"),
                rst.getString("date/time"),
                rst.getString("foodChoice"));
        conferenceRequests.add(conferenceRequest);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return true;
  }

  /**
   * gets index of given request in the list of requests
   *
   * @param requestID requestID being checked
   * @return value of index
   */
  private int getIndex(Integer requestID) {
    for (int i = 0; i < conferenceRequests.size(); i++) {
      ConferenceRequest x = conferenceRequests.get(i);
      if (x.getRequestID() == (Integer) requestID) {
        return i;
      }
    }
    throw new RuntimeException("No request found with ID " + requestID);
  }

  /**
   * function that gets all conference requests in the list
   *
   * @return all conference requests in list
   */
  public List<ConferenceRequest> getAllRows() {
    return conferenceRequests;
  }

  public List<ConferenceRequest> listConferenceRequests(String username) {
    List<ConferenceRequest> list = new ArrayList<ConferenceRequest>();
    for (ConferenceRequest request : conferenceRequests) {
      if (request.getRequester().equals(username)) {}
    }
    return list;
  }
}
