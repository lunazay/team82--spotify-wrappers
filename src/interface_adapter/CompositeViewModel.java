package interface_adapter;

import app.LoggedInUseCaseFactory;
import interface_adapter.get_valence.GetValenceController;
import interface_adapter.get_valence.GetValenceState;
import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.related_artists.RelatedArtistsState;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_album.TopAlbumController;
import interface_adapter.top_album.TopAlbumState;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_artists.TopArtistsState;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenreState;
import interface_adapter.top_genre.TopGenreViewModel;
import interface_adapter.top_songs.TopSongsController;
import interface_adapter.top_songs.TopSongsState;
import interface_adapter.top_songs.TopSongsViewModel;
import use_case.top_songs.TopSongsInputBoundary;
import view.LoggedInView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class CompositeViewModel extends JPanel implements PropertyChangeListener{
    private GetValenceViewModel getValenceViewModel;
    private RelatedArtistsViewModel relatedArtistsViewModel;
    public TopGenreViewModel topGenreViewModel;
    private TopSongsViewModel topSongsViewModel;
    private TopAlbumViewModel topAlbumViewModel;
    private TopArtistsViewModel topArtistsViewModel;

    public JPanel gridPanel;

    public CompositeViewModel() {

        this.relatedArtistsViewModel = new RelatedArtistsViewModel();
        this.topGenreViewModel = new TopGenreViewModel();
        this.topSongsViewModel = new TopSongsViewModel();
        this.topAlbumViewModel = new TopAlbumViewModel();
        this.topArtistsViewModel = new TopArtistsViewModel();
        this.getValenceViewModel = new GetValenceViewModel();

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("TopGenreState")) {
            TopGenreState currentState = (TopGenreState) evt.getNewValue();
            ArrayList<String> genres = currentState.getGenres();
            this.topGenreViewModel.setgenres(genres);
        }
        if (evt.getPropertyName().equals("TopAlbumState")) {
            TopAlbumState currentState = (TopAlbumState) evt.getNewValue();
            // List<String> albums = currentState.getTopAlbumNames();
            this.topAlbumViewModel.setState(currentState);
        }
        if (evt.getPropertyName().equals("TopSongsState")) {
            TopSongsState currentState = (TopSongsState) evt.getNewValue();
            this.topSongsViewModel.setState(currentState);
        }
        if (evt.getPropertyName().equals("TopArtistsState")) {
            TopArtistsState currentState = (TopArtistsState) evt.getNewValue();
            this.topArtistsViewModel.setState(currentState);
        }
        if (evt.getPropertyName().equals("ValenceState")) {
            GetValenceState getValenceState = (GetValenceState) evt.getNewValue();
            this.getValenceViewModel.setState(getValenceState);
        }
        if (evt.getPropertyName().equals("RelatedArtistsState")) {
            RelatedArtistsState relatedArtistsState = (RelatedArtistsState) evt.getNewValue();
            this.relatedArtistsViewModel.setState(relatedArtistsState);
        }
    }

    public JPanel getGridPanel() {
        JPanel result = new JPanel();
        gridPanel = new JPanel(new GridLayout(2, 3)); // Adjust layout as needed
        // Add view panels to the gridPanel
        gridPanel.add(getValenceViewModel.getViewPanel());
        gridPanel.add(relatedArtistsViewModel.getViewPanel());
        gridPanel.add(topGenreViewModel.getViewPanel());
        gridPanel.add(topSongsViewModel.getViewPanel());
        gridPanel.add(topAlbumViewModel.getViewPanel());
        gridPanel.add(topArtistsViewModel.getViewPanel());

        result.add(gridPanel, BorderLayout.CENTER); // Add the gridPanel to hold view models

        return result;
    }
}