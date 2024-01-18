package dev.mayankg.clean_coding.unit3Refactoring.userLogin;

public class User {
    String userId;

    public User(String userId) {
        super();
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}