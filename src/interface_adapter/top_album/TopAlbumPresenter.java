package interface_adapter.top_album;

import interface_adapter.ViewManagerModel;
import interface_adapter.top_genre.TopGenreState;
import use_case.top_album.TopAlbumOutputBoundary;
import use_case.top_album.TopAlbumOutputData;

public class TopAlbumPresenter implements TopAlbumOutputBoundary {
    private final TopAlbumViewModel topAlbumViewModel;
    private ViewManagerModel viewManagerModel;

    public TopAlbumPresenter(ViewManagerModel viewManagerModel,
                             TopAlbumViewModel topAlbumViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topAlbumViewModel = topAlbumViewModel;
    }

    @Override
    public void prepareSuccessView(TopAlbumOutputData album) {
        TopAlbumState topAlbumState = topAlbumViewModel.getState();
        topAlbumState.setTopAlbumNames(album.getAlbumNames());
        this.topAlbumViewModel.setState(topAlbumState);
        this.topAlbumViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error){
        TopAlbumState topAlbumState = topAlbumViewModel.getState();
        topAlbumState.setError(error);
        topAlbumViewModel.setState(topAlbumState);
        topAlbumViewModel.firePropertyChanged();
    }
}
