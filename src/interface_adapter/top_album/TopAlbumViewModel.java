package interface_adapter.top_album;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

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
        support.firePropertyChange("TopAlbumState", null, this.state);
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
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, titleLabel.getFont().getSize())); // Set font to bold
        // Add other UI components as needed
        topAlbumPanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the list of albums from the state
        List<String> albums = state.getTopAlbumNames();

        // Display the list of albums in the view
        if (albums != null && !albums.isEmpty()) {
            JPanel albumsPanel = new JPanel(new GridLayout(albums.size(), 1));
            for (String album : albums) {
                JLabel albumLabel = new JLabel(album);
                albumsPanel.add(albumLabel);
            }
            topAlbumPanel.add(albumsPanel, BorderLayout.CENTER);
        } else {
            // Handle case when there's no albums available
            JLabel noDataLabel = new JLabel("No top albums available.");
            topAlbumPanel.add(noDataLabel, BorderLayout.CENTER);
        }

        return topAlbumPanel;
    }
}
