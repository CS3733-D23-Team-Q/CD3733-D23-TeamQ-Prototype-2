package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.ConferenceRequest;
import edu.wpi.cs3733.D23.teamQ.db.obj.FlowerRequest;
import edu.wpi.cs3733.D23.teamQ.db.obj.ServiceRequest;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequestDaoImpl implements GenDao<ServiceRequest, Integer> {
  ObservableList<ServiceRequest> serviceRequests = FXCollections.observableArrayList();
  private GenDao conferenceRequestTable;
  private GenDao flowerRequestsTable;

  private static ServiceRequestDaoImpl single_instance = null;

  public static synchronized ServiceRequestDaoImpl getInstance(
      ConferenceRequestDaoImpl conferenceRequestTable, FlowerRequestDaoImpl flowerRequestTable) {
    if (single_instance == null)
      single_instance = new ServiceRequestDaoImpl(conferenceRequestTable, flowerRequestTable);

    return single_instance;
  }

  private ServiceRequestDaoImpl(GenDao conferenceRequestTable, GenDao flowerRequestsTable) {
    this.conferenceRequestTable = conferenceRequestTable;
    this.flowerRequestsTable = flowerRequestsTable;
    this.serviceRequests = getAllRows();
  }

  public ObservableList<ServiceRequest> getAllRows() {

    ObservableList<ServiceRequest> srL = FXCollections.observableArrayList();
    List<FlowerRequest> flowerRequests = flowerRequestsTable.getAllRows();
    List<ConferenceRequest> conferenceRequests = conferenceRequestTable.getAllRows();

    for (int i = 0; i < flowerRequests.size(); i++) {
      FlowerRequest fr = flowerRequests.get(i);
      ServiceRequest s =
          new ServiceRequest(
              fr.getRequestID(),
              fr.getRequester(),
              fr.progressToInt(fr.getProgress()),
              fr.getAssignee(),
              fr.getRoomNumber(),
              fr.getSpecialInstructions());
      srL.add(s);
    }
    for (int i = 0; i < conferenceRequests.size(); i++) {
      ConferenceRequest cr = conferenceRequests.get(i);
      ServiceRequest s =
          new ServiceRequest(
              cr.getRequestID(),
              cr.getRequester(),
              cr.progressToInt(cr.getProgress()),
              cr.getAssignee(),
              cr.getRoomNumber(),
              cr.getSpecialInstructions());
      srL.add(s);

    }
    return srL;
  }

  @Override
  public ServiceRequest retrieveRow(Integer ID) {
    return null;
  }

  @Override
  public boolean updateRow(Integer ID, ServiceRequest x) throws SQLException {
    return false;
  }

  @Override
  public boolean deleteRow(Integer ID) throws SQLException {
    return false;
  }

  public boolean addRow(ServiceRequest x) {
    return false;
  }

  public boolean populate() throws SQLException {
    return false;
  }
}
