package edu.wpi.cs3733.D23.teamQ.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public interface GenDao<T, G> {

  public List<T> getAllRows();

  public T retrieveRow(G ID);

  public boolean updateRow(G ID, T x);

  public boolean deleteRow(G ID);

  public boolean addRow(T x);
}
