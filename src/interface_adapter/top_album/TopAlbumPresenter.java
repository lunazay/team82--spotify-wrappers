package interface_adapter.top_album;

import interface_adapter.ViewManagerModel;
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
        // TODO: need to finish this
    }

    @Override
    public void prepareFailView(String error){
        // TODO: need to finish this

    }
}
