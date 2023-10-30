package entity;

public class User {

    private final String userID;

    private final String displayName;


    public User(String userID, String displayName) {

        this.userID = userID;
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return this.displayName;
    }

    public String getUserID() {
        return userID;
    }
}
