package net.coinpurse.api.coinpurseapi.users;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sessions")
public class Session {
    @Id
    private ObjectId id;
    private String email;
    private String password;

    //  Constructor 1: None
    public Session() {
    }
    // Constructor 2: All
    public Session(ObjectId id, String email, String password) {
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
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
