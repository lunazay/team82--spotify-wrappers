package interface_adapter.top_album;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class TopAlbumViewModel extends ViewModel {
    private static final String TITLE_LABEL = "top album view";

    private TopAlbumState state = new TopAlbumState();

    public TopAlbumViewModel() {
        super("top album");
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

    @Override
    public JPanel getViewPanel() {
        // Create and configure the JPanel for the top genre view
        JPanel topAlnumsPanel = new JPanel();
        topAlbumsPanel.setLayout(new BorderLayout());

        // Add components representing the top genre view
        JLabel titleLabel = new JLabel("Top Albums");
        topAlbumsPanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the list of genres from the state
        ArrayList<String> genres = state.get();

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
