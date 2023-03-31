package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.obj.Edge;
import edu.wpi.cs3733.D23.teamQ.db.obj.Location;
import edu.wpi.cs3733.D23.teamQ.db.obj.Move;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MapEditorController {

  @FXML private MFXButton BackHomeBTN;

  @FXML private TableColumn<Node, String> Building;

  @FXML private TableColumn<Move, String> Date;

  @FXML private TableColumn<Edge, Node> EndNode;

  @FXML private TableColumn<Node, String> Floor;

  @FXML private TableColumn<Location, String> LongName;

  @FXML private TableColumn<Node, String> NodeID;

  @FXML private TableColumn<Location, String> NodeType;

  @FXML private TableColumn<Location, String> ShortName;

  @FXML private TableColumn<Edge, Node> StartNode;

  @FXML private TableColumn<Node, Number> Xcoord;

  @FXML private TableColumn<Node, Number> Ycoord;

  @FXML private TableView<TableColumn> editor;

  @FXML
  public void initialize() {
    /** Navigate to homepage after click on the button */
    BackHomeBTN.setOnMouseClicked((event -> Navigation.navigate(Screen.HOME)));

    /**
     * ObservableList<Node> list = FXCollections.observableArrayList(); for (int i = 0; i <
     * getNodes().size(); i++) { list.add(getNodes().get(i)); } editor = new TableView<Node>(list);
     *
     * <p>//get building Building.setCellValueFactory( new
     * Callback<TableColumn.CellDataFeatures<Node, String>, ObservableValue<String>>() { @Override
     * public ObservableValue<String> call(TableColumn.CellDataFeatures<Node, String> param) {
     * SimpleStringProperty building = new SimpleStringProperty(param.getValue().getBuilding());
     * return building; } });
     *
     * <p>//get Xcoord Xcoord.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Node,
     * Number>, ObservableValue<Number>>() { @Override public ObservableValue<Number>
     * call(TableColumn.CellDataFeatures<Node, Number> param) { SimpleIntegerProperty xcoord = new
     * SimpleIntegerProperty(param.getValue().getXCoord()); return xcoord; } });
     *
     * <p>//get Ycoord Ycoord.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Node,
     * Number>, ObservableValue<Number>>() { @Override public ObservableValue<Number>
     * call(TableColumn.CellDataFeatures<Node, Number> param) { SimpleIntegerProperty ycoord = new
     * SimpleIntegerProperty(param.getValue().getYCoord()); return ycoord; } });
     *
     * <p>editor.getColumns().add(Building); editor.getColumns().add(Xcoord);
     */

    /**
     * Building.setCellValueFactory(new PropertyValueFactory<Node, String>("Building"));
     * Xcoord.setCellValueFactory(new PropertyValueFactory<Node, Number>("Xcoord"));
     * Ycoord.setCellValueFactory(new PropertyValueFactory<Node, Number>("Ycoord"));
     *
     * <p>editor.setItems(nodes()); }
     *
     * <p>public ObservableList<Node> nodes() { ObservableList<Node> node =
     * FXCollections.observableArrayList(); for (int i = 0; i < NodeDaoImpl.getAllRows().size();
     * i++) { node.add(NodeDaoImpl.getAllRows().get(i)); } return node; }
     */
  }
}
