package edu.wpi.cs3733.D23.teamQ.db;

import edu.wpi.cs3733.D23.teamQ.db.impl.ConferenceRequestDaoImpl;
import edu.wpi.cs3733.D23.teamQ.db.impl.FlowerRequestDaoImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;
import java.sql.SQLException;

public class Qdb {
  public static void main(String[] args) throws SQLException {
    ConferenceRequestDaoImpl requestC = new ConferenceRequestDaoImpl();
    FlowerRequestDaoImpl requestF = new FlowerRequestDaoImpl();
    ConferenceRequest conferenceRequest =
        new ConferenceRequest("test", 0, "test", "test", "test", "test", "test");
    FlowerRequest flowerRequest =
        new FlowerRequest("test", 0, "test", "test", "test", "test", "test", 1);

    requestC.addRow(conferenceRequest);
    requestF.addRow(flowerRequest);

    // List<ConferenceRequest> list = request.getAllRows();

    // request.deleteRow(5);
  }
}
