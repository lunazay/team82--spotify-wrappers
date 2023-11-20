package interface_adapter.top_album;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopAlbumViewModel extends ViewModel {
    private static final String TITLE_LABEL = "Top Album View";

    private TopAlbumState state = new TopAlbumState();

    public TopAlbumViewModel() {
        super("Top Album");
    }

    public void setState(TopAlbumState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public TopAlbumState getState() {
        return state;
    }
}
