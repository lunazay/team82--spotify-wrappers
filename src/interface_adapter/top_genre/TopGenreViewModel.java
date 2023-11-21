package interface_adapter.top_genre;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopGenreViewModel extends ViewModel {

    // any buttons/ titles we want dsiplayed should be written here
    private TopGenreState state = new TopGenreState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TopGenreViewModel(){
        super("top genres");
    }
    public void setState(TopGenreState state){
        this.state = state;
    }
    // the Top genre presenter will call this to let the viewmodel to alert the view
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    // do i need an override here?
    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
    public TopGenreState getState() {
        return state;
    }
}
