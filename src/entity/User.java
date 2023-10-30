package entity;

public class User extends DataObject {

    private final String userID;

    private final String displayName;


    public User(String userID, String displayName) {

        this.userID = userID;
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName(){
        return displayName;
    }


    @Override
    public String getUserID() {
        return userID;
    }
}
