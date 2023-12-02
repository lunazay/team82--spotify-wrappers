package use_case.login;


public class LoginOutputData {

    public String currentUserId;
    public LoginOutputData(String userId) {
        this.currentUserId = userId;
    }
    //TODO: figure out what the output data of the login would be,
    // im guessing it would be id potentially of the user since that is the input data of all the other use cases

}
