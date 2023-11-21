package interface_adapter.top_album;

import interface_adapter.ViewManagerModel;
import interface_adapter.top_artists.TopArtistsState;
import use_case.TopAlbum.TopAlbumOutputBoundary;
import use_case.TopAlbum.TopAlbumOutputData;

public class TopAlbumPresenter implements TopAlbumOutputBoundary {
    private final TopAlbumViewModel topAlbumViewModel;
    private ViewManagerModel viewManagerModel;

    public TopAlbumPresenter(ViewManagerModel viewManagerModel,
                             TopAlbumViewModel topAlbumViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topAlbumViewModel = topAlbumViewModel;
    }

    @Override
    public void prepareSuccessView(TopAlbumOutputData user) {
        // TODO: need to implement this
        TopAlbumState topAlbumState = topAlbumViewModel.getState();
        topAlbumState.setTopAlbumNames(user.getAlbumNames());
        this.topAlbumViewModel.setState(topAlbumState);
        topAlbumViewModel.firePropertyChanged();

        viewManagerModel.setActiveViewName(topAlbumViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){
        TopAlbumState topAlbumState = topAlbumViewModel.getState();
        topAlbumState.setError(error);
        topAlbumViewModel.firePropertyChanged();
    }
}
