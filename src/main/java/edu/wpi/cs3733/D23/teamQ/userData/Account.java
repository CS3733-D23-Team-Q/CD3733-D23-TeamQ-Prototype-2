package edu.wpi.cs3733.D23.teamQ.userData;

public class Account {
  private String username;
  private String password;
  private String email;
  private String securityAnswer1;
  private String securityAnswer2;

  Account(String username, String password, String email, String securityAnswer1, String securityAnswer2) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.securityAnswer1 = securityAnswer1;
    this.securityAnswer2 = securityAnswer2;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  public String getSecurityAnswer1() {
    return securityAnswer1;
  }

  public void setSecurityAnswer1(String securityAnswer1) {
    this.securityAnswer1 = securityAnswer1;
  }
  public String getSecurityAnswer2() {
    return securityAnswer2;
  }

  public void setSecurityAnswer2(String securityAnswer2) {
    this.securityAnswer2 = securityAnswer2;
  }
}
