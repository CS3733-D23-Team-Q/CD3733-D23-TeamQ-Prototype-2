package edu.wpi.cs3733.D23.teamQ.db.dao;

import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import java.util.List;

public interface AccountDao {
  public boolean addUser(
      String uname, String pass, String email, int q1, int q2, String a1, String a2);

  public boolean deleteUser(String uname);

  public boolean updatePassword(String uname, String newPass);

  public Account getAccountFromUsername(String uname);

  public List<Account> getAccountFromEmail(String uname);

  public boolean usernameExist(String uname);

  boolean emailExist(String uname);
}
