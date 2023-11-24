package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor){
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void execute(String token){
        LoginInputData loginInputData = new LoginInputData(token);
        loginUseCaseInteractor.execute(loginInputData);
    }
}
