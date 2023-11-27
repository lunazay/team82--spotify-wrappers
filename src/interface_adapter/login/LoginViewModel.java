package interface_adapter.login;

import interface_adapter.ViewModel;
import view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel {

    public final String TITLE_LABLE = "log in view";

    public String code;

    public static final String LOGIN_BUTTON_LABEL = "Log in";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private LoginState state = new LoginState();

    public String codeOuput(){
        return state.getCode();
    }
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

    @Override
    public JPanel getViewPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("To log in, click on this link: " + state.getCode());
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    public LoginState getState(){
        return state;
    }
}
