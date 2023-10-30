package entity;

public class User extends DataObject {

    private final String displayName;


    public User(String id, String displayName) {

        super(id);
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
