package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRequestDaoImpl implements GenDao<ConferenceRequest, Integer> {
  private List<ConferenceRequest> conferenceRequests = new ArrayList<ConferenceRequest>();

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
                "INSERT INTO \"conferenceRequest\"(\"requester\", \"progress\", \"assignee\", \"specialInstructions\", \"time\", \"foodChoice\", \"roomNum\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
      stmt.setString(1, x.getRequester());
      stmt.setInt(2, x.getProgress());
      stmt.setString(3, x.getAssignee());
      stmt.setString(4, x.getSpecialInstructions());
      stmt.setString(5, x.getDateTime());
      stmt.setString(6, x.getFoodChoice());
      stmt.setString(7, x.getRoomNumber());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conferenceRequests.add(x);
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
                rst.getInt("requester"),
                rst.getString("progress"),
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
      if (x.getRequestID() == requestID) {
        return i;
      }
    }
    throw new RuntimeException("No move found with ID " + requestID);
  }

  /**
   * function that gets all conference requests in the list
   *
   * @return all conference requests in list
   */
  public List<ConferenceRequest> getAllRows() {
    return conferenceRequests;
  }
  /*
  public List<ConferenceRequest> listConferenceRequests(String assignerUsername) {
      List<ConferenceRequest> requests = new ArrayList<>();
      try(Connection conn = GenDao.connect();
          PreparedStatement stmt = conn.prepareStatement("SELECT * FROM conferenceRequest WHERE requester = ?")) {
          stmt.setString(1, assignerUsername);
          ResultSet rs = stmt.executeQuery();
          while(rs.next()) {
              int requestID = rs.getInt("requestID");
              String requester = rs.getString("requester");
              String progress = rs.getString("progress");
              String assignee = rs.getString("assignee");
              String specialInstructions = rs.getString("specialInstructions");
              String time = rs.getString("time");
              boolean cleanRoom = rs.getBoolean("cleanRoom");
              String foodChoice = rs.getString("foodChoice");
              String roomNum = rs.getString("roomNum");
              ConferenceRequest request = new ConferenceRequest(requestID, requester, progress, assignee, roomNum, specialInstructions, time, cleanRoom, foodChoice);
              requests.add(request);
          }
      } catch(SQLException e) {
          e.printStackTrace();
      }
      return requests;
  }
   */

  public List<ConferenceRequest> listConferenceRequests(String username) {
    List<ConferenceRequest> list = new ArrayList<ConferenceRequest>();
    for (ConferenceRequest request : conferenceRequests) {
      if (request.getRequester().equals(username)) {}
    }
    return list;
  }
}
