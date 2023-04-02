package edu.wpi.cs3733.D23.teamQ.db;

import edu.wpi.cs3733.D23.teamQ.db.impl.ConferenceRequestDaoImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import java.sql.SQLException;

public class Qdb {
  public static void main(String[] args) throws SQLException {
    ConferenceRequestDaoImpl request = new ConferenceRequestDaoImpl();
    ConferenceRequest conferenceRequest =
        new ConferenceRequest(5, 0, "test", "test", "test", "test", "test", "test");

    request.addRow(conferenceRequest);

    // request.populate();

    // List<ConferenceRequest> list = request.getAllRows();

    request.deleteRow(5);
  }
}
