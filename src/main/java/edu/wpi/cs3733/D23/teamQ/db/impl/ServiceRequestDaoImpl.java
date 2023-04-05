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
  ObservableList<ServiceRequest> serviceRequests;

  public ServiceRequestDaoImpl() {
    this.serviceRequests = getAllRows();
  }

  public ObservableList<ServiceRequest> getAllRows() {
    // need method to get active user's username
    String username = "";
    ObservableList<ServiceRequest> srL = FXCollections.observableArrayList();
    FlowerRequestDaoImpl requestF = new FlowerRequestDaoImpl();
    ConferenceRequestDaoImpl requestC = new ConferenceRequestDaoImpl();
    List<FlowerRequest> flowerRequests = requestF.getAllRows();
    List<ConferenceRequest> conferenceRequests = requestC.getAllRows();

    for (int i = 0; i < flowerRequests.size(); i++) {
      FlowerRequest fr = flowerRequests.get(i);
      if (fr.getRequester().equals(username)) {
        ServiceRequest s =
            new ServiceRequest(
                fr.getRequestID(),
                fr.getRequester(),
                fr.getProgress(),
                fr.getAssignee(),
                fr.getRoomNumber(),
                fr.getSpecialInstructions());
        srL.add(s);
      }
    }
    for (int i = 0; i < conferenceRequests.size(); i++) {
      ConferenceRequest cr = conferenceRequests.get(i);
      if (cr.getRequester().equals(username)) {
        ServiceRequest s =
            new ServiceRequest(
                cr.getRequestID(),
                cr.getRequester(),
                cr.getProgress(),
                cr.getAssignee(),
                cr.getRoomNumber(),
                cr.getSpecialInstructions());
        srL.add(s);
      }
    }
    return srL;
  }

  @Override
  public ServiceRequest retrieveRow(Integer ID) throws SQLException {
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
