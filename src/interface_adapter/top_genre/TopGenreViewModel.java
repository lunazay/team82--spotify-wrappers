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
    private ArrayList<String> genres;

    public TopGenreViewModel(){
        super("top genres");
    }
    public void setState(TopGenreState state){
        this.state = state;
    }

    // the Top genre presenter will call this to let the viewmodel to alert the view

    public void setgenres(ArrayList<String> genres){
        this.genres = genres;
    }
    @Override
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }
    @Override
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
        topGenrePanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the list of genres from the state
        ArrayList<String> genres = this.genres;

        // Display the list of genres in the view
        if (genres != null && !genres.isEmpty()) {
            JPanel genresPanel = new JPanel(new GridLayout(genres.size(), 1));
            for (String genre : genres) {
                JLabel genreLabel = new JLabel(genre);
                genresPanel.add(genreLabel);
            }
            topGenrePanel.add(genresPanel, BorderLayout.CENTER);
        } else {
            // Handle case when there's no genres available
            JLabel noDataLabel = new JLabel("No top genres available.");
            topGenrePanel.add(noDataLabel, BorderLayout.CENTER);
        }

        return topGenrePanel;
    }
}
