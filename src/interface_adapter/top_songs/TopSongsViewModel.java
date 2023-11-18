package interface_adapter.top_songs;

import interface_adapter.ViewModel;
import interface_adapter.top_genre.TopGenreState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopSongsViewModel extends ViewModel {
    private static final String TITLE_LABLE = "Top Songs View";
    private TopGenreState state = new TopGenreState();

    public TopSongsViewModel(){
        super("Top Genre");
    }

    public void setState(TopGenreState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // the Top genre presenter will call this to let the viewmodel to alert the view
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public TopGenreState getState() {
        return state;
    }
}
