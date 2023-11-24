package use_case.login;

public class LoginInputData {
    private final String token;

    public LoginInputData(String token){
        this.token = token;
    }
    public String getToken(){
        return token;
    }
}
