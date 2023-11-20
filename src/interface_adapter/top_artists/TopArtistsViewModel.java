package interface_adapter.top_artists;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopArtistsViewModel extends ViewModel {
    public static final String BUTTON_LABEL = "label";      // example of a button label name
    private TopArtistsState state = new TopArtistsState();

    public TopArtistsViewModel() {
        super("top artists");
    }
    public void setState(TopArtistsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TopArtistsState getState() {
        return state;
    }
}
