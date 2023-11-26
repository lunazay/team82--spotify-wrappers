package use_case.login;

import entity.User;

import java.io.IOException;

public interface LoginUserDataAccessInterface {

    void setToken(String authcode ) throws IOException;
    User getNewUser() throws IOException;  // TODO: create a user here.
}
