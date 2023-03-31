package edu.wpi.cs3733.D23.teamQ.db.impl;

import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AccountDaoImpl implements GenDao<Account, String> {
    private List<Account> accounts;

    AccountDaoImpl(LinkedList<Account> accounts) {
        this.accounts = accounts;
    }
    /**
     * returns a account given a username
     *
     * @param username of node being retrieved
     * @return an account with the given username
     */
    public Account retrieveRow (String username) {
        int index = this.getIndex(username);
        return accounts.get(index);
    }
    /**
     * updates account in list with a new account
     *
     * @param username of account being replaced
     * @param newAccount new account being inserted
     * @return true if successful
     */
    public boolean updateRow(String username, Account newAccount) {
        int index = this.getIndex(username);
        accounts.set(index, newAccount);
        return true;
    }
    /**
     * deletes account from list of accounts
     *
     * @param username of node being deleted
     * @return true if successfully deleted
     */
    public boolean deleteRow(String username) {
        int index = this.getIndex(username);
        accounts.remove(index);
        return true;
    }
    /**
     * adds an account to the linked list
     *
     * @param a account being added
     * @return true if successful
     */
    public boolean addRow(Account a) {
        return accounts.add(a);
    }
    /**
     * gets index of given account in the list of accounts
     *
     * @param username username being checked
     * @return value of index
     */
    private int getIndex(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            if (a.getUsername().equals(username)) {
                return i;
            }
        }
        throw new RuntimeException("No username found matching " + username);
    }

    /**
     * function that gets all accounts in the list
     *
     * @return all accounts in list
     */
    public List<Account> getAllRows(){
        return accounts;
    }

    /**
     * function that exports account table into given csv file
     *
     * @param filename csv file to export to
     * @return true if successfully exported, false otherwise
     */
    public boolean toCSV(String filename){
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            FileWriter myWriter = new FileWriter(filename);
            for (int i = 0; i < accounts.size(); i++) {
                Account a = accounts.get(i);
                myWriter.write(
                        a.getUsername()
                                + ','
                                + a.getPassword()
                                + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
}
