package interface_adapter.login;

public class LoginState {
    private String code = "";
    private String loginError = null;
    public LoginState(){}

    public String getCode() {
        return code;
    }

    public void setLoginError(String error){
        this.loginError = error;
    }

    public String getLoginError(){
        return loginError;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
