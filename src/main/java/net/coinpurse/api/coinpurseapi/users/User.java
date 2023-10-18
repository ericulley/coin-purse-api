package net.coinpurse.api.coinpurseapi.users;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String bio;

    //  Constructor 1: none
    public User() {
    }
    //  Constructor 2: All
    public User(ObjectId id, String name, String email, String password, String bio) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }
    //  Constructor 3: No id for DB
    public User(String name, String email, String password, String bio) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }
    //  Constructor 4: No id or bio for client initialization
    public User(String name, String email, String password) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}