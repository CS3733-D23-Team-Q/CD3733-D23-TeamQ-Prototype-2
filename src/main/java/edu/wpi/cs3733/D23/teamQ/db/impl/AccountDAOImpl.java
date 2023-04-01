package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl {
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

  public int getQuestionId(String question) {
    int q = 0;
    Connection con = connect();
    try {
      String query = "SELECT id FROM security_question WHERE question = ?";
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, question);
      ResultSet rs = pst.executeQuery();
      rs.next();
      q = rs.getInt(1);
      con.close();
      pst.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return q;
  }
}