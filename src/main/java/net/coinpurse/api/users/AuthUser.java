package net.coinpurse.api.users;

public class AuthUser {
    private String user;
    private String userName;
    private String email;
    private Boolean isAuthorized;

    public AuthUser(String user, String userName, String email, Boolean isAuthorized) {
        this.user = user;
        this.userName = userName;
        this.email = email;
        this.isAuthorized = isAuthorized;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(Boolean authorized) {
        isAuthorized = authorized;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "user=" + user +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
