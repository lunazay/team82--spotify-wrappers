package interface_adapter.top_songs;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopSongsViewModel extends ViewModel {
    private static final String TITLE_LABLE = "Top Songs View";
    private TopSongsState state = new TopSongsState();

    public TopSongsViewModel(){
        super("Top Songs");
    }

    public void setState(TopSongsState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // the Top Songs presenter will call this to let the viewmodel to alert the view
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public TopSongsState getState() {
        return state;
    }
}
