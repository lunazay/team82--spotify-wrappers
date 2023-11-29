package interface_adapter;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public abstract class ViewModel {
    private String viewName;

    public ViewModel(String viewName){
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);

    public abstract JPanel getViewPanel();

    public String userId;

    public void setUserId(String currentUserId) {
        this.userId = currentUserId;
    }
}
