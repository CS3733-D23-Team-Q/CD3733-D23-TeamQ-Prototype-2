package edu.wpi.cs3733.D23.teamQ;

import static org.junit.jupiter.api.Assertions.*;

import edu.wpi.cs3733.D23.teamQ.controllers.CreateAccountController;
import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AccountDAOTest {
  AccountDAOImpl dao = new AccountDAOImpl();

  public boolean samePropertyValueAs(Account a) {
    boolean result = false;
    Account b = new Account("admin", "teamq", "admin@gmail.com", 1, 2, "310", "blue");
    if (a.getUsername().equals(b.getUsername())
        && a.getPassword().equals(b.getPassword())
        && a.getEmail().equals(b.getEmail())
        && a.getSecurityQuestion1() == (b.getSecurityQuestion1())
        && a.getSecurityQuestion2() == (b.getSecurityQuestion2())
        && a.getSecurityAnswer1().equals(b.getSecurityAnswer1())
        && a.getSecurityAnswer2().equals(b.getSecurityAnswer2())) {
      result = true;
    }
    return result;
  }

  @Test
  public void testGetAccountFromUsername() {
    Account a = dao.getAccountFromUsername("admin");
    assertEquals(true, samePropertyValueAs(a));
  }

  @Test
  public void testGetAccountFromEmail() {
    List<Account> as = dao.getAccountFromEmail("admin@gmail.com");
    Account a = as.get(0);
    assertEquals(true, samePropertyValueAs(a));
  }

  @Test
  public void testAddUserTrue() {
    boolean actual = dao.addUser("kelu", "123", "kelu@gmail.com", 1, 2, "310", "blue");
    dao.deleteUser("kelu");
    assertEquals(true, actual);
  }

  @Test
  public void testDeleteUserTrue() {
    dao.addUser("kelu", "123", "kelu@gmail.com", 1, 2, "310", "blue");
    boolean actual = dao.deleteUser("kelu");
    assertEquals(true, actual);
  }

  @Test
  public void testUpdatePasswordTrue() {
    dao.addUser("kelu", "123", "kelu@gmail.com", 1, 2, "310", "blue");
    boolean actual = dao.updatePassword("kelu", "111");
    dao.deleteUser("kelu");
    assertEquals(true, actual);
  }

  @Test
  public void getAccountFromUsernameTrue() {
    Account a = dao.getAccountFromUsername("admin");
  }

  @Test
  public void testUsernameExistTrue() {
    boolean actual = dao.usernameExist("admin");
    assertEquals(true, actual);
  }

  @Test
  public void testUsernameExistFalse() {
    boolean actual = dao.usernameExist("liukelu");
    assertEquals(false, actual);
  }

  @Test
  public void testEmailExistTrue() {
    boolean actual = dao.emailExist("admin@gmail.com");
    assertEquals(true, actual);
  }

  @Test
  public void testEmailExistFalse() {
    boolean actual = dao.emailExist("liukelu@gmail.com");
    assertEquals(false, actual);
  }

  @Test
  public void testGetQuestionId() {
    int actual = dao.getQuestionId("What is your favorite color?");
    assertEquals(2, actual);
  }

  CreateAccountController cac = new CreateAccountController();

  // public boolean isEmail(String uname) {
  //    boolean email = false;
  //    Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
  //    if (pattern.matcher(uname).matches()) {
  //      email = true;
  //    }
  //    return email;
  //  }

  /*
  @Test
  public void testValidEmailEmpty() {
    int actual = cac.validEmail("");
    assertEquals(0, actual);
  }

  @Test
  public void testValidEmailTrue() {
    int actual = cac.validEmail("this@is.email");
    assertEquals(1, actual);
  }

  @Test
  public void testValidEmailFalse() {
    int actual = cac.validEmail("liu");
    assertEquals(2, actual);
  }
   */
}
