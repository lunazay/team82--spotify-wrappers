package use_case.login;

import entity.User;

public class LoginOutputData {

    public User currentUser;
    public LoginOutputData(User currentUser) {
        this.currentUser = currentUser;
    }
    //TODO: figure out what the output data of the login would be,
    // im guessing it would be id potentially of the user since that is the input data of all the other use cases

}
