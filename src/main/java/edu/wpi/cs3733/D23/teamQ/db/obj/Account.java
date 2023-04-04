package edu.wpi.cs3733.D23.teamQ.db.obj;

public class Account {
  private String username;
  private String password;
  private String email;
  private int securityQuestion1;
  private int securityQuestion2;
  private String securityAnswer1;
  private String securityAnswer2;

  private String firstName;
  private String lastName;
  private String title;
  private int IDNum;
  private int phoneNumber;


  public Account(
      String username,
      String password,
      String email,
      int securityQuestion1,
      int securityQuestion2,
      String securityAnswer1,
      String securityAnswer2,
      String firstName,
      String lastName,
      String title,
      int IDNum,
      int phoneNumber) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.securityQuestion1 = securityQuestion1;
    this.securityQuestion2 = securityQuestion2;
    this.securityAnswer1 = securityAnswer1;
    this.securityAnswer2 = securityAnswer2;
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
    this.IDNum = IDNum;
    this.phoneNumber = phoneNumber;
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

  public int getSecurityQuestion1() {
    return securityQuestion1;
  }

  public void setSecurityQuestion1(int securityQuestion1) {
    this.securityQuestion1 = securityQuestion1;
  }

  public int getSecurityQuestion2() {
    return securityQuestion2;
  }

  public void setSecurityQuestion2(int securityQuestion2) {
    this.securityQuestion2 = securityQuestion2;
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
  public String getFirstName(){return firstName;}
  public void setFirstName(String FN){this.firstName = FN;}
  public String getLastName(){return lastName;}
  public void setLastName(String LN){this.lasttName = LN;}
  public String getTitle(){return title;}
  public void setTitle(String title){this.title = title;}
  public int getIDNum(){return IDNum;}
  public void setIDNum(int ID){this.IDNum = ID;}
  public int getPhoneNumber(){return phoneNumber;}
  public void setPhoneNumber(int PN){this.phoneNumber = PN;}
}

