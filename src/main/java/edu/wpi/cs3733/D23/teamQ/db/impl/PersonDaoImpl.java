package edu.wpi.cs3733.D23.teamQ.db.impl;
import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import edu.wpi.cs3733.D23.teamQ.db.obj.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements GenDao<Account, String>{
    static final String url = "jdbc:postgresql://database.cs.wpi.edu:5432/teamqdb";
    static final String user = "teamq";
    static final String password = "teamq140";

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

    private List<Person> People = new ArrayList<Person>();

    public Person retrieveRow(int IDNum) {
        populate();
        int index = this.getIndex(IDNum);
        return People.get(index);
    }



    public boolean updateRow(String uname, Person personWithNewChanges) {
        populate();
        boolean result = false;
        Connection con = GenDao.connect();
        String newFN = personWithNewChanges.getFirstName();
        String newLN = personWithNewChanges.getLastName();
        String newTitle = personWithNewChanges.getTitle();
        int newPN = personWithNewChanges.getPhoneNumber();

        try {
            String query =
                    "UPDATE person SET firstName = ?, lastName = ?, title = ?, phoneNumber= ? WHERE username = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newFN);
            pst.setString(2, newLN);
            pst.setString(3, newTitle);
            pst.setInt(4, newPN);

            int rs = pst.executeUpdate();
            if (rs == 1) {
                result = true;
                int index = this.getIndex(uname);
                People.get(index).setFirstName(newFN);
                People.get(index).setLastName(newLN);
                People.get(index).setTitle(newTitle);
                People.get(index).setPhone(newPN);
                System.out.println("Updated successfully!");
            } else {
                System.out.println("Failed to update.");
            }
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean deleteRow(int IDNum) {
        populate();
        boolean result = false;
        Connection con = GenDao.connect();
        try {
            String query = "DELETE FROM person WHERE IDNum = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, IDNum);
            int rs = pst.executeUpdate();
            if (rs == 1) {
                result = true;
                int index = this.getIndex(IDNum);
                People.remove(index);
                System.out.println("Person deleted successful!");
            } else {
                System.out.println("Failed to delete your Person.");
            }
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean addRow(Person a) {
        populate();
        int IDNum = a.getIDNum();
        String FirstName = a.getFirstName();
        String LastName = a.getLastName();
        String Title = a.getTitle();
        int PhoneNumber = a.getPhoneNumber();
        boolean result = false;
        Connection con = GenDao.connect();
        try {
            String query =
                    "INSERT INTO person (IDNum, FirstName, LastName, Title, PhoneNumber) VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, IDNum);
            pst.setString(2, FirstName);
            pst.setString(3, LastName);
            pst.setString(4, Title);
            pst.setInt(5, PhoneNumber);
            int rs = pst.executeUpdate();
            if (rs == 1) {
                result = true;
                People.add(a);
                System.out.println("Person created successful!");
            } else {
                System.out.println("Failed to create your person.");
            }
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Account> getAllRows() {
        populate();
        return accounts;
    }

    public boolean populate() {
        Connection con = GenDao.connect();
        try {
            String query = "SELECT * FROM account";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Account a;
                a =
                        new Account(
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getInt("security_question_1"),
                                rs.getInt("security_question_2"),
                                rs.getString("security_answer_1"),
                                rs.getString("security_answer_2"));
                accounts.add(a);
            }
            con.close();
            st.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int getIndex(String uname) {
        populate();
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            if (a.getUsername().equals(uname)) {
                return i;
            }
        }
        return -1;
    }

    public List<Integer> getIndexes(String email) {
        populate();
        List<Integer> is = new ArrayList<Integer>();
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            if (a.getEmail().equals(email)) {
                is.add(i);
            }
        }
        return is;
    }

}
