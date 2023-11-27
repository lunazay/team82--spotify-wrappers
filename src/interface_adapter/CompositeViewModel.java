package interface_adapter;

import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreViewModel;
import interface_adapter.top_songs.TopSongsViewModel;

import javax.swing.*;
import java.awt.*;

public class CompositeViewModel extends JPanel{
    private GetValenceViewModel getValenceViewModel;
    private RelatedArtistsViewModel relatedArtistsViewModel;
    private TopGenreViewModel topGenreViewModel;
    private TopSongsViewModel topSongsViewModel;
    private TopAlbumViewModel topAlbumViewModel;
    private TopArtistsViewModel topArtistsViewModel;

    public CompositeViewModel(){
        setLayout(new GridLayout(3, 2)); // Adjust layout as needed
        GetValenceViewModel getValenceViewModel = new GetValenceViewModel();
        RelatedArtistsViewModel relatedArtistsViewModel = new RelatedArtistsViewModel();
        TopGenreViewModel topGenreViewModel = new TopGenreViewModel();
        TopSongsViewModel topSongsViewModel = new TopSongsViewModel();
        TopAlbumViewModel topAlbumViewModel = new TopAlbumViewModel();
        TopArtistsViewModel topArtistsViewModel = new TopArtistsViewModel();

        add(getValenceViewModel.getViewPanel());
        //add(relatedArtistsViewModel.getViewPanel());
        add(topGenreViewModel.getViewPanel());
        add(topSongsViewModel.getViewPanel());
        //add(topAlbumViewModel.getViewPanel());
        //add(topArtistsViewModel.getViewPanel());

    }

}
