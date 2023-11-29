package interface_adapter.top_artists;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class TopArtistsViewModel extends ViewModel {
    public static final String BUTTON_LABEL = "label";      // example of a button label name
    private TopArtistsState state = new TopArtistsState();

    public TopArtistsViewModel() {
        super("top artists");
    }
    public void setState(TopArtistsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TopArtistsState getState() {
        return state;
    }

    @Override
    public JPanel getViewPanel() {
        /// Create and configure the JPanel for the top genre view
        JPanel topArtistPanel = new JPanel();
        topArtistPanel.setLayout(new BorderLayout());

        // Add components representing the top artist view
        JLabel titleLabel = new JLabel("Top Artist");
        topArtistPanel.add(titleLabel, BorderLayout.NORTH);

        List<String> artists = state.getArtistNames();

        if (artists != null && !artists.isEmpty()) {
            JPanel artistPanel = new JPanel(new GridLayout(artists.size(), 1));
            for (String artist : artists) {
                JLabel artistLabel = new JLabel(artist);
                artistPanel.add(artistLabel);
            }
            topArtistPanel.add(artistPanel, BorderLayout.CENTER);
        } else {
            // Handle case when there's no genres available
            JLabel noDataLabel = new JLabel("No top artists available.");
            topArtistPanel.add(noDataLabel, BorderLayout.CENTER);
        }

        return topArtistPanel;
    }
}
