package interface_adapter.top_genre;

import entity.Genre;
import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

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

    public ArrayList<Genre> getgenres(){
        return state.getGenres();
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

    @Override
    public JPanel getViewPanel() {
        // Create and configure the JPanel for the top genre view
        JPanel topGenrePanel = new JPanel();
        topGenrePanel.setLayout(new BorderLayout());

        // Add components representing the top genre view
        JLabel titleLabel = new JLabel("Top Genres");
        // Add other UI components as needed

        topGenrePanel.add(titleLabel, BorderLayout.NORTH);
        // Add other components to the panel

        return topGenrePanel;
    }
}
