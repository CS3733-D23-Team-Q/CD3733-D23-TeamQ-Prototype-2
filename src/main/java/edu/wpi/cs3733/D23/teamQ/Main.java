package edu.wpi.cs3733.D23.teamQ;

import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;

public class Main {

  public static void main(String[] args) {
    AccountDAOImpl dao = new AccountDAOImpl();
    App.launch(App.class, args);
  }

  // shortcut: psvm

}
