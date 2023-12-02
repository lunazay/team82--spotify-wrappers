package use_case.login;

import java.io.IOException;

public class LoginInteractor implements LoginInputBoundary{
    final LoginUserDataAccessInterface userDataAccessInterface;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface, LoginOutputBoundary loginOutputBoundary){
        this.userDataAccessInterface = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }
    @Override
    public void execute(LoginInputData loginInputData) throws IOException {
        try {
            String codeInput = loginInputData.getCodeInput();

            // Sending the token to the DAO, so it can be stored inside the program:
            userDataAccessInterface.setToken(codeInput);

            // and also getting the user id back:
            String currentUserId = userDataAccessInterface.getCurrentUserId();

            LoginOutputData loginOutputData = new LoginOutputData(currentUserId);
            loginPresenter.prepareSuccessView(loginOutputData);
        } catch (IOException e) {
            loginPresenter.prepareFailView("Could not log in, try again!");
        }
    }
}
