package use_case.TopSongs;

public interface TopSongsOutputBoundary {
    void prepareSuccessView(TopSongsOutputData user);

    void prepareFailView(String error);
}
