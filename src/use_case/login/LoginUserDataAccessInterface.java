package use_case.login;

import entity.User;

import java.io.IOException;

public interface LoginUserDataAccessInterface {
    void setToken( String authcode ) throws IOException;
    User getUser(String id);  // TODO: create a user here.
}
