package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
  private String username;
  private String password;

  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
