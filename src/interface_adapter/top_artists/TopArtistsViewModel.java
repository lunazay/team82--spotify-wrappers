package interface_adapter.top_artists;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
        // Create and configure the JPanel for the top genre view
        JPanel topArtistPanel = new JPanel();
        topArtistPanel.setLayout(new BorderLayout());

        // Add components representing the top genre view
        JLabel titleLabel = new JLabel("Top Genres");
        // Add other UI components as needed

        topArtistPanel.add(titleLabel, BorderLayout.NORTH);
        // Add other components to the panel

        return topArtistPanel;
    }
}
