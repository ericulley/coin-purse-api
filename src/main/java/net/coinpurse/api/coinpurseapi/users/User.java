package net.coinpurse.api.coinpurseapi.users;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private String bio;

    //  Constructor 1: none
    public User() {
    }
    //  Constructor 2: All
    public User(ObjectId id, String email, String password, String bio) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }
    //  Constructor 3: No id for DB
    public User(String email, String password, String bio) {
        this.email = email;
        this.password = password;
        this.bio = bio;
    }
    //  Constructor 4: No id or bio for client initialization
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //  Getters & Setters
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
