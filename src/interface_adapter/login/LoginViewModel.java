package interface_adapter.login;

import interface_adapter.ViewModel;
import view.LoginView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel {

    public final String TITLE_LABLE = "log in View";

    private LoginState state = new LoginState();
    public LoginViewModel(){
        super("log in");
    }

    public void setState(LoginState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoginState getState(){
        return state;
    }
}
