package use_case.top_album;

public interface TopAlbumOutputBoundary {
    void prepareSuccessView(TopAlbumOutputData user);

    void prepareFailView(String error);
}
