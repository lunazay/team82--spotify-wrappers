package use_case.login;

import java.io.IOException;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws IOException;
}
