package interface_adapter.related_artists;

import interface_adapter.ViewModel;


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

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
        support.firePropertyChange("RelatedArtistsState", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public JPanel getViewPanel() {
        // Create and configure the JPanel for the related artists view
        JPanel relatedArtistPanel = new JPanel();
        relatedArtistPanel.setLayout(new BorderLayout());

        // Add components representing the related artists view
        JLabel titleLabel = new JLabel("Related Artist");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, titleLabel.getFont().getSize())); // Set font to bold
        relatedArtistPanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the list of related artists from the state
        List<String> relatedArtist = state.getRelatedArtists();

        // Display the list of related artists in the view
        if (relatedArtist != null && !relatedArtist.isEmpty()) {
            JPanel artistPanel = new JPanel(new GridLayout(relatedArtist.size(), 1));
            for (String artist : relatedArtist) {
                JLabel artistLabel = new JLabel(artist);
                artistPanel.add(artistLabel);
            }
            relatedArtistPanel.add(artistPanel, BorderLayout.CENTER);
        } else {
            // Handle case when there's no related artist available
            JLabel noDataLabel = new JLabel("No related artist available.");
            relatedArtistPanel.add(noDataLabel, BorderLayout.CENTER);
        }

        return relatedArtistPanel;
    }

    public RelatedArtistsState getState(){
        return state;
    }

    public List<String> getRelatedArtists(){
        return state.getRelatedArtists();
    }
}
