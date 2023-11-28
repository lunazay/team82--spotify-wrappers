package interface_adapter.top_songs;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class TopSongsViewModel extends ViewModel {
    private static final String TITLE_LABEL = "top songs view";
    private TopSongsState state = new TopSongsState();

    public TopSongsViewModel(){
        super("top songs");
    }

    public void setState(TopSongsState state){
        this.state = state;
    }

    public ArrayList<String> getsongs(){
        return state.getSongs();
    }
    // the Top genre presenter will call this to let the viewmodel to alert the view
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // the Top Songs presenter will call this to let the viewmodel to alert the view
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    @Override
    public JPanel getViewPanel() {
        // Create and configure the JPanel for the top genre view
        JPanel topSongsPanel = new JPanel();
        topSongsPanel.setLayout(new BorderLayout());

        // Add components representing the top genre view
        JLabel titleLabel = new JLabel("Top Songs");
        topSongsPanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the list of genres from the state
        ArrayList<String> songs = state.getSongs();

        // Display the list of genres in the view
        if (songs != null && !songs.isEmpty()) {
            JPanel songsPanel = new JPanel(new GridLayout(songs.size(), 1));
            for (String song : songs) {
                JLabel genreLabel = new JLabel(song);
                songsPanel.add(genreLabel);
            }
            topSongsPanel.add(songsPanel, BorderLayout.CENTER);
        } else {
            // Handle case when there's no genres available
            JLabel noDataLabel = new JLabel("No top songs available.");
            topSongsPanel.add(noDataLabel, BorderLayout.CENTER);
        }

        return topSongsPanel;
    }

    public TopSongsState getState() {
        return state;
    }
}
