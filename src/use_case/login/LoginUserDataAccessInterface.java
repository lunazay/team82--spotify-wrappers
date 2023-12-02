package use_case.login;

import java.io.IOException;

public interface LoginUserDataAccessInterface {

    void setToken(String authcode ) throws IOException;

    String getCurrentUserId() throws IOException;
}
