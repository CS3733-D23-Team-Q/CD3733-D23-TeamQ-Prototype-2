/*-------------------------*/
/* DO NOT DELETE THIS TEST */
/*-------------------------*/

package edu.wpi.cs3733.D23.teamQ;

import static org.junit.jupiter.api.Assertions.*;

import edu.wpi.cs3733.D23.teamQ.userData.accountDAO;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

public class loginSystemTest {

  enum question {
    DOB("What is your date of birth?"),
    FC("What is your favorite color?"),
    NOP("What is the name of your first pet?"),
    HT("What is your hometown?");
    private String value;

    question(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  accountDAO dao = new accountDAO();
  question q1 = question.DOB;
  question q2 = question.FC;
  question q4 = question.NOP;
  question q3 = question.HT;

  @Test
  public void testIsEmail() {
    boolean expected = dao.isEmail("liukelu1@gmail.com");
    assertEquals(expected, true);
  }
}
