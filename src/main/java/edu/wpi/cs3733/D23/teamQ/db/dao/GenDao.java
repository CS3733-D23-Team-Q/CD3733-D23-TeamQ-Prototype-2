package edu.wpi.cs3733.D23.teamQ.db.dao;

import java.util.List;

public interface GenDao<T> {
    public List<T> getAllRows();
    public T retrieveRow(String requestID);
    public boolean updateRow(String requestID, T fr);
    public boolean deleteRow(String requestID);
    public boolean addRow(T fr);
}
