package use_case.Login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);
    void prepareFailView(String error);
}
