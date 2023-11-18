package interface_adapter.top_genre;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopGenreViewModel extends ViewModel {

    private static final String TITLE_LABLE = "Top Genre View";
    private TopGenreState state = new TopGenreState();

    public TopGenreViewModel(){
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
