package edu.wpi.cs3733.D23.teamQ.userData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class accountDAO {
  private static final String url = "jdbc:postgresql://database.cs.wpi.edu:5432/teamqdb";
  private static final String user = "teamq";
  private static final String password = "teamq140";

  public static Connection connect() {
    Connection con = null;
    try {
      Class.forName("org.postgresql.Driver");
      con = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return con;
  }
  // test

  public boolean addUser(
      String uname, String pass, String email, int q1, int q2, String a1, String a2) {
    boolean result = false;
    Connection con = connect();
    try {
      String query =
          "INSERT INTO account"
              + "(username, password, email, security_question_1, security_question_2, security_answer_1, security_answer_2)"
              + "VALUES(?,?,?,?,?,?,?)";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      pst.setString(2, pass);
      pst.setString(3, email);
      pst.setInt(4, q1);
      pst.setInt(5, q2);
      pst.setString(6, a1);
      pst.setString(7, a2);
      int rs = pst.executeUpdate();
      if (rs == 1) {
        result = true;
        System.out.println("Account created successful!");
      } else {
        System.out.println("Failed to create your account.");
      }
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  public boolean deleteUser(String uname) {
    boolean result = false;
    Connection con = connect();
    try {
      String query = "DELETE FROM account WHERE username = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      int rs = pst.executeUpdate();
      if (rs == 1) {
        result = true;
        System.out.println("Account deleted successful!");
      } else {
        System.out.println("Failed to delete your account.");
      }
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  public boolean updatePassword(String uname, String newPass) {
    boolean result = false;
    Connection con = connect();
    try {
      String query = "UPDATE account SET password = ? WHERE username = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, newPass);
      pst.setString(2, uname);
      int rs = pst.executeUpdate();
      if (rs == 1) {
        result = true;
        System.out.println("Password updated successful!");
      } else {
        System.out.println("Failed to update your password.");
      }
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  public Account getAccountFromUsername(String uname) {
    String pass = "";
    String email = "";
    int q1 = 0;
    int q2 = 0;
    String a1 = "";
    String a2 = "";
    Account a = new Account(uname, pass, email, q1, q2, a1, a2);
    Connection con = connect();
    try {
      String query = "SELECT * FROM account WHERE username = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        a.setUsername(rs.getString(1));
        a.setPassword(rs.getString(2));
        a.setEmail(rs.getString(3));
        a.setSecurityQuestion1(rs.getInt(4));
        a.setSecurityQuestion2(rs.getInt(5));
        a.setSecurityAnswer1(rs.getString(6));
        a.setSecurityAnswer2(rs.getString(7));
      }
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return a;
  }

  public List<Account> getAccountFromEmail(String uname) {
    List<Account> as = new ArrayList<Account>();
    Connection con = connect();
    try {
      String query = "SELECT * FROM account WHERE email = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        String username = "";
        String pass = "";
        String email = uname;
        int q1 = 0;
        int q2 = 0;
        String a1 = "";
        String a2 = "";
        Account a = new Account(username, pass, uname, q1, q2, a1, a2);
        a.setUsername(rs.getString(1));
        a.setPassword(rs.getString(2));
        a.setEmail(rs.getString(3));
        a.setSecurityQuestion1(rs.getInt(4));
        a.setSecurityQuestion2(rs.getInt(5));
        a.setSecurityAnswer1(rs.getString(6));
        a.setSecurityAnswer2(rs.getString(7));
        as.add(a);
        con.close();
        pst.close();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return as;
  }

  public boolean usernameExist(String uname) {
    boolean result = false;
    Connection con = connect();
    try {
      String query = "SELECT * FROM account WHERE username = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        result = true;
      }
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  public boolean emailExist(String uname) {
    boolean result = false;
    Connection con = connect();
    try {
      String query = "SELECT * FROM account WHERE email = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        result = true;
      }
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }

  /*
  public boolean isEmail(String uname) {
    boolean email = false;
    Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
    if (pattern.matcher(uname).matches()) {
      email = true;
    }
    return email;
  }

  // email verification and shaking alert if any field is empty
  public void createAccount(
      String uname,
      String password,
      String email,
      int question1,
      int question2,
      String answer1,
      String answer2) {
    int result;
    Connection con = connect();
    String query = "INSERT INTO account VALUES (?,?,?,?,?,?,?)";
    if (!userExist(uname)) {
      try {
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, uname);
        pst.setString(2, password);
        pst.setString(3, email);
        pst.setInt(4, question1);
        pst.setInt(5, question2);
        pst.setString(6, answer1);
        pst.setString(7, answer2);
        int rs = pst.executeUpdate();
        if (rs < 0) {
          System.out.println("Failed to create an account.");
        } else {
          System.out.println("Account created successful!");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } else {
      System.out.println("Username already exist. Try another one.");
    }
  }

  // or restrict the username not be in the format of email within the database
  public void login(String uname, String enteredPassword) {
    Connection con = connect();
    String pass = "";
    String loginResult = "";
    if (userExist(uname)) {
      try {
        ResultSet rs = getAccountFromUsername(uname);
        rs.next();
        pass = rs.getString("password");
        if (enteredPassword.equals(pass)) {
          loginResult = "Logged in successful.";
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      if (isEmail(uname) && !loginResult.equals("Logged in successful.")) {
        try {
          ResultSet rs = getAccountFromEmail(uname);
          rs.next();
          pass = rs.getString("password");
          if (enteredPassword.equals(pass)) {
            loginResult = "Logged in successful.";
            System.out.println(loginResult);
          } else {
            loginResult = "Wrong password.";
            System.out.println(loginResult);
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    } else {
      System.out.println("Username doesn't exist.");
    }
  }

  // username only
  // also need to match the specific question
  public boolean passedSecurityTest(
      String uname, String question1, String question2, String answer1, String answer2) {
    boolean passed = false;
    String q1 = "";
    String q2 = "";
    String a1 = "";
    String a2 = "";
    Connection con = connect();
    String query =
        "SELECT 'securityQuestion1', 'securityQuestion2', 'securityAnswer1', 'securityAnswer2' FROM 'account' WHERE 'username' = ?";
    try {
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      ResultSet rs = pst.executeQuery();
      rs.next();
      q1 = rs.getString("securityQuestion1");
      q2 = rs.getString("securityQuestion2");
      a1 = rs.getString("securityAnswer1");
      a2 = rs.getString("securityAnswer2");
      if (question1.equals(q1)
          && question2.equals(q2)
          && answer1.equals(a1)
          && answer2.equals(a2)) {
        passed = true;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return passed;
  }

  // username only
  public void resetPassword(
      String uname,
      String newPassword,
      String question1,
      String question2,
      String answer1,
      String answer2) {
    Connection con = connect();
    String query = "UPDATE account SET password = ? WHERE username = ?";
    if (!userExist(uname)) {
      if (passedSecurityTest(uname, question1, question2, answer1, answer2)) {
        try {
          PreparedStatement pst = con.prepareStatement(query);
          pst.setString(1, newPassword);
          pst.setString(2, uname);
          int rs = pst.executeUpdate();
          if (rs < 0) {
            System.out.println("Failed to reset your password.");
          } else {
            System.out.println("Updated successful!");
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      } else {
        System.out.println("One or more answers are wrong.");
      }
    } else {
      System.out.println("Username doesn't exist.");
    }
  }
   */
}
