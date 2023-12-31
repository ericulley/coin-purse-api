package net.coinpurse.api.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sessions")
public class Session {
    @Id
    private String id;
    private String email;
    private String password;

    //  Constructor 1: None
    public Session() {
    }
    // Constructor 2: All
    public Session(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    // Constructor 3: No id for DB
    public Session(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //  Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
