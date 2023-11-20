package interface_adapter.login;

import use_case.Login.LoginInputBoundary;
import use_case.Login.LoginInputData;

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor){
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void execute(String token){
        LoginInputData loginInputData = new LoginInputData();
        loginUseCaseInteractor.execute(loginInputData);
    }
}
