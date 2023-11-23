package use_case.login;

public class LoginInteractor implements LoginInputBoundary{
    final LoginUserDataAccessInterface userDataAccessInterface;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface, LoginOutputBoundary loginOutputBoundary){
        this.userDataAccessInterface = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }
    @Override
    public void execute(LoginInputData loginInputData){
        //TODO: fifure this out when input data is done
        LoginOutputData loginOutputData = new LoginOutputData();
        loginPresenter.prepareSuccessView(loginOutputData);
    }
}
