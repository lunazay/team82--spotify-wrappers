package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {
    public static final String DONE_BUTTON_LABEL = "Done";
    public final String TITLE_LABLE = "logged in view";
    public static final String SHORT_BUTTON_LABEL = "Short term";
    public static final String MEDIUM_BUTTON_LABEL = "Medium term";
    public static final String LONG_BUTTON_LABEL = "Long term";

    private LoggedInState state = new LoggedInState();
    public LoggedInViewModel(){
        super("logged in");
    }

    String id = "";
    public String getId(){
        return state.getid();
    }

    public void setState(LoggedInState state) {
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
        return null;
    }

    public LoggedInState getState(){
        return state;
    }
}

