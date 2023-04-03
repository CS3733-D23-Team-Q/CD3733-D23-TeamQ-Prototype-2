package edu.wpi.cs3733.D23.teamQ.userData;

import java.sql.*;
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

  public boolean isEmail(String uname) {
    boolean email = false;
    Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
    if (pattern.matcher(uname).matches()) {
      email = true;
    }
    return email;
  }

  public ResultSet getAccountFromEmail(String uname) {
    Connection con = connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String query = "SELECT * FROM 'account' WHERE 'email' = ?";
    try {
      pst = con.prepareStatement(query);
      pst.setString(1, uname);
      rs = pst.executeQuery();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return rs;
  }

  public ResultSet getAccountFromUsername(String uname) {
    Connection con = connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String query = "SELECT * FROM 'account' WHERE 'username' = ?";
    try {
      pst = con.prepareStatement(query);
      pst.setString(1, uname);
      rs = pst.executeQuery();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return rs;
  }

  // or restrict the username not be in the format of email
  public boolean checkUser(String uname) {
    boolean exist = false;
    Connection con = connect();
    try {
      ResultSet rs = getAccountFromUsername(uname);
      if (rs.next()) {
        exist = true;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    if (isEmail(uname)) {
      try {
        ResultSet rs = getAccountFromEmail(uname);
        if (rs.next()) {
          exist = true;
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return exist;
  }

  // email verification and shaking alert if any field is empty
  public void createAccount(
      String uname,
      String password,
      String email,
      String question1,
      String question2,
      String answer1,
      String answer2) {
    Connection con = connect();
    String query = "INSERT INTO 'account' VALUES (?,?,?,?,?,?,?)";
    if (!checkUser(uname)) {
      try {
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, uname);
        pst.setString(2, password);
        pst.setString(3, email);
        pst.setString(4, question1);
        pst.setString(5, question2);
        pst.setString(6, answer1);
        pst.setString(7, answer2);
        int rs = pst.executeUpdate();
        if (rs < 0) {
          System.out.println("Failed to create an account.");
        } else {
          System.out.println("Account created successfully!");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } else {
      System.out.println("Username already exists. Try another one.");
    }
  }

  // or restrict the username not be in the format of email within the database
  public void login(String uname, String enteredPassword) {
    Connection con = connect();
    String pass = "";
    String loginResult = "";
    if (checkUser(uname)) {
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
      String question1,
      String question2,
      String answer1,
      String answer2,
      String newPassword) {
    Connection con = connect();
    String query = "UPDATE 'account' SET 'password' = ? WHERE 'username' = ?";
    if (checkUser(uname)) {
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
}
