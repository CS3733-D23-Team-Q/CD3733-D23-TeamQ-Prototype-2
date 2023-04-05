package edu.wpi.cs3733.D23.teamQ.db;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.impl.*;
import edu.wpi.cs3733.D23.teamQ.db.obj.*;

public class Qdb {
  public GenDao<Account, String> accountTable = new AccountDaoImpl();
  public GenDao<ConferenceRequest, Integer> conferenceRequestTable = new ConferenceRequestDaoImpl();
  public GenDao<FlowerRequest, Integer> flowerRequestTable = new FlowerRequestDaoImpl();
  public GenDao<ServiceRequest, Integer> serviceRequestTable =
      new ServiceRequestDaoImpl(conferenceRequestTable, flowerRequestTable);
  public GenDao<Node, Integer> nodeTable = new NodeDaoImpl();
  public GenDao<Edge, Integer> edgeTable = new EdgeDaoImpl(nodeTable);
  public GenDao<Move, Integer> moveTable = new MoveDaoImpl();
  public GenDao<Location, Integer> locationTable = new LocationDaoImpl();

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
