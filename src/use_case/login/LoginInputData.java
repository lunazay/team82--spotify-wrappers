package use_case.login;

public class LoginInputData {
    private final String codeInput;

    public LoginInputData(String codeInput){
        this.codeInput = codeInput;
    }
    public String getToken(){
        return codeInput;
    }
}
