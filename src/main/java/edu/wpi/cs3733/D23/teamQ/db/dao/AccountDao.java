package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> getAllAccounts();
    public Account retrieveRow(String username);
    public boolean updateRow(String username, Account a);
    public boolean deleteRow(String username);
    public boolean addRow(Account a);
}
