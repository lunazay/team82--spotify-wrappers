package use_case.TopAlbum;

public interface TopAlbumOutputBoundary {
    void prepareSuccessView(TopAlbumOutputData user);

    void prepareFailView(String error);
}
