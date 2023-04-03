package edu.wpi.cs3733.D23.teamQ.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface GenDao<T, G> {
  static final String url = "jdbc:postgresql://database.cs.wpi.edu:5432/teamqdb";
  static final String user = "teamq";
  static final String password = "teamq140";

  public static Connection connect() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return conn;
  }

  public List<T> getAllRows();

  public T retrieveRow(G ID) throws SQLException;

  public boolean updateRow(G ID, T x) throws SQLException;

  public boolean deleteRow(G ID) throws SQLException;

  public boolean addRow(T x);

  public boolean populate() throws SQLException;
}
