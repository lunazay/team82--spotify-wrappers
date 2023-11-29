package interface_adapter.top_album;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
        // Create and configure the JPanel for the top album view
        JPanel topAlbumPanel = new JPanel();
        topAlbumPanel.setLayout(new BorderLayout());

        // Add components representing the top album view
        JLabel titleLabel = new JLabel("Top Albums");
        // Add other UI components as needed

        topAlbumPanel.add(titleLabel, BorderLayout.NORTH);
        // Add other components to the panel

        return topAlbumPanel;
    }
}
