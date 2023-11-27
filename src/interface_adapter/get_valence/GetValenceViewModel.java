package interface_adapter.get_valence;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetValenceViewModel extends ViewModel {

    private GetValenceState state = new GetValenceState();

    public GetValenceViewModel() {
        super("get valence");
    }

    public void setState(GetValenceState state) { this.state = state; }

    public GetValenceState getState() { return this.state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
