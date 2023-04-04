package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Move;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoveDaoImpl implements GenDao<Move, Integer> {
  private List<Move> moves = new ArrayList<Move>();
  private int nextID = 0;

  public MoveDaoImpl() {
    populate();
    if (moves.size() != 0) {
      nextID = moves.get(moves.size() - 1).getMoveID() + 1;
    }
  }

  /**
   * returns a move given a nodeID
   *
   * @param nodeID of move being retrieved
   * @return a move with the given nodeID
   */
  public Move retrieveRow(Integer nodeID) {
    int index = this.getIndex(nodeID);
    return moves.get(index);
  }

  /**
   * updates move in list with a new move
   *
   * @param nodeID nodeID of Move being replaced
   * @param newMove new location being inserted
   * @return true if successful
   */
  public boolean updateRow(Integer nodeID, Move newMove) {
    int index = this.getIndex(nodeID);
    moves.set(index, newMove);
    return true;
  }

  /**
   * deletes move from list of moves
   *
   * @param moveID of move being deleted
   * @return true if successfully deleted
   */
  public boolean deleteRow(Integer moveID) {
    try (Connection connection = GenDao.connect();
        PreparedStatement st =
            connection.prepareStatement("DELETE FROM move WHERE \"moveID\" = ?")) {;
      st.setInt(1, moveID);
      st.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int index = this.getIndex(moveID);
    moves.remove(index);

    return true;
  }

  /**
   * adds a move to the list
   *
   * @param m move being added
   * @return true if successful
   */
  public boolean addRow(Move m) {
    try (Connection conn = GenDao.connect();
        PreparedStatement stmt =
            conn.prepareStatement(
                "INSERT INTO move(\"nodeID\", \"longName\", \"date\") VALUES (?, ?, ?)")) {
      stmt.setInt(2, m.getNode().getNodeID());
      stmt.setString(3, m.getLongName());
      stmt.setString(4, m.getDate());
      stmt.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    m.setMoveID(nextID);
    nextID++;
    return moves.add(m);
  }

  @Override
  public boolean populate() {
    try {
      Connection conn = GenDao.connect();
      Statement stm = conn.createStatement();
      ResultSet rst = stm.executeQuery("Select * From move");
      NodeDaoImpl nodeDao = new NodeDaoImpl();

      while (rst.next()) {
        moves.add(
            new Move(
                nodeDao.retrieveRow(rst.getInt("nodeID")),
                rst.getString("longName"),
                rst.getString("date")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return true;
  }

  /**
   * gets index of given nodeID in the list of moves
   *
   * @param nodeID nodeID being checked
   * @return value of index
   */
  private int getIndex(Integer nodeID) {
    for (int i = 0; i < moves.size(); i++) {
      Move m = moves.get(i);
      if (m.getNode().getNodeID() == nodeID) {
        return i;
      }
    }
    throw new RuntimeException("No move found with ID " + nodeID);
  }

  /**
   * function that gets all moves in the list
   *
   * @return all moves in list
   */
  public List<Move> getAllRows() {
    return moves;
  }

  public boolean toCSV(String filename) {
    try {
      File myObj = new File(filename);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      }
      FileWriter myWriter = new FileWriter(filename);
      for (int i = 0; i < moves.size(); i++) {
        Move m = moves.get(i);
        myWriter.write(
            m.getMoveID()
                + ','
                + m.getNode().getNodeID()
                + ','
                + m.getLongName()
                + ','
                + m.getDate()
                + "\n");
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
      return true;
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      return false;
    }
  }

  public boolean importCSV(String filename) {
    NodeDaoImpl nodeDao = new NodeDaoImpl();
    try {
      File f = new File(filename);
      Scanner myReader = new Scanner(f);
      while (myReader.hasNextLine()) {
        String row = myReader.nextLine();
        String[] vars = row.split(",");
        Move m = new Move(nodeDao.retrieveRow(Integer.parseInt(vars[1])), vars[2], vars[3]);
        addRow(m);
        return true;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return false;
  }
}
