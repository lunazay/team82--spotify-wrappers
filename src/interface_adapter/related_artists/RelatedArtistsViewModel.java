package interface_adapter.related_artists;

import interface_adapter.ViewModel;

import entity.Artist;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RelatedArtistsViewModel extends ViewModel {
    private RelatedArtistsState state = new RelatedArtistsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public RelatedArtistsViewModel(){
        super("related artists");
    }
    public void setState(RelatedArtistsState state){
        this.state = state;
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public RelatedArtistsState getState(){
        return state;
    }

    public Artist[] getRelatedArtists(){
        return state.getRelatedArtists();
    }
}
