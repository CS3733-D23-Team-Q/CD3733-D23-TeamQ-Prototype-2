package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.impl.ServiceRequestDaoImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.ServiceRequest;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListServiceRequestController {
  @FXML Button homeButton;
  @FXML MenuItem homeItem;
  @FXML MenuItem exitItem;
  @FXML TableView<ServiceRequest> tableView;
  @FXML TableColumn<ServiceRequest, Integer> requestID;
  @FXML TableColumn<ServiceRequest, Integer> progress;
  @FXML TableColumn<ServiceRequest, String> requester;
  @FXML TableColumn<ServiceRequest, String> assignee;
  @FXML TableColumn<ServiceRequest, String> roomNumber;
  @FXML TableColumn<ServiceRequest, String> specialInstructions;

  @FXML Button selectButton;

  ServiceRequestDaoImpl serviceRequestDao = new ServiceRequestDaoImpl();

  @FXML
  public void initialize() {
    requestID.setCellValueFactory(new PropertyValueFactory<ServiceRequest, Integer>("requestID"));
    progress.setCellValueFactory(new PropertyValueFactory<ServiceRequest, Integer>("progress"));
    requester.setCellValueFactory(new PropertyValueFactory<ServiceRequest, String>("requester"));
    assignee.setCellValueFactory(new PropertyValueFactory<ServiceRequest, String>("assignee"));
    roomNumber.setCellValueFactory(new PropertyValueFactory<ServiceRequest, String>("roomNumber"));
    specialInstructions.setCellValueFactory(
        new PropertyValueFactory<ServiceRequest, String>("specialInstructions"));

    tableView.setItems(serviceRequestDao.getAllRows());
  }

  @FXML
  public void homeButtonClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void selectButtonClicked() {
    System.out.println(
        "ID: " + tableView.getSelectionModel().getSelectedItems().get(0).getRequestID());
    System.out.println(
        "Progress: " + tableView.getSelectionModel().getSelectedItems().get(0).getProgress());
    System.out.println(
        "Requester: " + tableView.getSelectionModel().getSelectedItems().get(0).getRequester());
    System.out.println(
        "Assignee: " + tableView.getSelectionModel().getSelectedItems().get(0).getAssignee());
    System.out.println(
        "Room Number: " + tableView.getSelectionModel().getSelectedItems().get(0).getRoomNumber());
    System.out.println(
        "Special Instructions: "
            + tableView.getSelectionModel().getSelectedItems().get(0).getSpecialInstructions());
  }

  @FXML
  public void homeItemClicked() {
    Navigation.navigate(Screen.HOME);
  }

  @FXML
  public void exitItemClicked() {
    Platform.exit();
  }
}
