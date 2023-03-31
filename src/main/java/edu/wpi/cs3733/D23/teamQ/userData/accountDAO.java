package edu.wpi.cs3733.D23.teamQ.userData;

import java.sql.*;

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

  public void createAccount(String uname, String newPassword, String email, String answer1, String answer2) {
    Connection con = connect();
    String query = "INSERT INTO account VALUES (?,?,?)";
    try {
      PreparedStatement pst = con.prepareStatement(query);
      pst.setString(1, uname);
      pst.setString(2, password);
      pst.setString(3, email);
      pst.setString(4, answer1);
      pst.setString(5, answer2);
      int rs = pst.executeUpdate();
      if (rs < 0) {
        System.out.println("Failed to create an account.");
      } else {
        System.out.println("Account created successful!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void findAccount(String uname, String enteredPassword) {
    Connection con = connect();
    String pass = "";
    String query = "SELECT password FROM account WHERE username = 'uname'";
    try {
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      rs.next();
      pass = rs.getString("password");
      if (enteredPassword.equals(password)) {
        System.out.println("Logged in successful.");
      } else {
        System.out.println("Wrong password or username doesn't exist.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void resetPassword(String uname, String newPassword) {
    Connection con = connect();
    String query = "UPDATE account SET password = 'newPassword' WHERE username = 'uname'";
    try {
      Statement st = con.createStatement();
      int rs = st.executeUpdate(query);
      if (rs < 0) {
        System.out.println("Failed to reset your password.");
      } else {
        System.out.println("Updated successful!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // email
  public void retrieveUsername() {}
}
