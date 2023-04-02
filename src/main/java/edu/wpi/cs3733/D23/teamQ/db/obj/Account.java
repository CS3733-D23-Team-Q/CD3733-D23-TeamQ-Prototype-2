package edu.wpi.cs3733.D23.teamQ.db.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String username;
    private String password;
    private String email;
    private String securityQuestion1;
    private String securityQuestion2;
    private String securityAnswer1;
    private String securityAnswer2;

    public Account(
            String username,
            String password,
            String email,
            String securityQuestion1,
            String securityQuestion2,
            String securityAnswer1,
            String securityAnswer2) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.securityQuestion1 = securityQuestion1;
        this.securityQuestion2 = securityQuestion2;
        this.securityAnswer1 = securityAnswer1;
        this.securityAnswer2 = securityAnswer2;
    }
}