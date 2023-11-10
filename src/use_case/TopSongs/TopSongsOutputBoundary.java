package use_case.TopSongs;

public interface TopSongsOutputBoundary {
    void prepareSuccessView(TopSongsOutputData topSongsOutputData);
    void prepareFailView(String error);
}
