package edu.wpi.cs3733.D23.teamQ;

import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDaoImpl;
import edu.wpi.cs3733.D23.teamQ.db.impl.QuestionDAOImpl;

public class Main {

  public static void main(String[] args) {
    AccountDaoImpl dao = new AccountDaoImpl();
    QuestionDAOImpl qdao = new QuestionDAOImpl();

    /*
    List<Account> accounts = dao.getAllRows();
    for (Account a : accounts) {
      System.out.println(a.getUsername());
    }
     */

    App.launch(App.class, args);

    // System.out.println(dao.retrieveRow("admin").getUsername());

    // dao.populate();

    /*
    for (Account a : dao.retrieveRows("liukelu1@gmail.com")) {
      System.out.println(a.getUsername());
    }
     */

    /*
    System.out.println(dao.getIndex("admin"));
    System.out.println(qdao.getIndex(""));
    System.out.println(qdao.retrieveRow("What is your favorite color?").getId());
     */

    /*
    for (Integer i : dao.getIndexes("liukelu1@gmail.com")) {
      System.out.println(i);
    }
     */
  }

  // shortcut: psvm

}
