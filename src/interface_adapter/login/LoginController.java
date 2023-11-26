package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import java.io.IOException;

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor){
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void execute(String token) throws IOException {
        LoginInputData loginInputData = new LoginInputData(token);
        loginUseCaseInteractor.execute(loginInputData);
    }
}
