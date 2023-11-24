package use_case.login;

import entity.User;

import java.io.IOException;

public interface LoginUserDataAccessInterface {
    void save (User user); // I think that "save" here might actually have the same
                           // functionality as setToken (it will store the token in
                           // our system so we can access it for future calls.)

    void setToken( String authcode ) throws IOException;
    User get(String id);
}
