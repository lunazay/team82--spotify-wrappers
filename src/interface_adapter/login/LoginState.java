package interface_adapter.login;

public class LoginState {
    private String code = "";
    private String error;
    public LoginState(){}

    public String getCode() {
        return code;
    }

    public void setLoginError(String error){
        this.error = error;
    }

    public String getLoginError(){
        return error;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
