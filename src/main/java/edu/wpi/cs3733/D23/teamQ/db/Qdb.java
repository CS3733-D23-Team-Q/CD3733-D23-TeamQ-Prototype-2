package edu.wpi.cs3733.D23.teamQ.db;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.impl.*;
import edu.wpi.cs3733.D23.teamQ.db.obj.*;

public class Qdb {
  public GenDao<Person, Integer> personTable = PersonDaoImpl.getInstance();
  public GenDao<Account, String> accountTable = AccountDaoImpl.getInstance();
  public GenDao<ConferenceRequest, Integer> conferenceRequestTable =
      ConferenceRequestDaoImpl.getInstance();
  public GenDao<FlowerRequest, Integer> flowerRequestTable = FlowerRequestDaoImpl.getInstance();
  public GenDao<ServiceRequest, Integer> serviceRequestTable =
      ServiceRequestDaoImpl.getInstance(
          (ConferenceRequestDaoImpl) conferenceRequestTable,
          (FlowerRequestDaoImpl) flowerRequestTable);
  public GenDao<Node, Integer> nodeTable = NodeDaoImpl.getInstance();
  public GenDao<Edge, Integer> edgeTable = EdgeDaoImpl.getInstance((NodeDaoImpl) nodeTable);
  public GenDao<Move, Integer> moveTable = MoveDaoImpl.getInstance((NodeDaoImpl) nodeTable);
  public GenDao<Location, Integer> locationTable = LocationDaoImpl.getInstance();

  private static Qdb single_instance = null;

  private Qdb() {}

  public void addFlowerRequest(FlowerRequest req) {
    this.flowerRequestTable.addRow(req);
  }

  public static synchronized Qdb getInstance() {
    if (single_instance == null) single_instance = new Qdb();

    return single_instance;
  }
}
