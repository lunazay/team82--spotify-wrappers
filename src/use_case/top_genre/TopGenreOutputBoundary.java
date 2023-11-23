package use_case.top_genre;

public interface TopGenreOutputBoundary {
    void prepareSuccessView(TopGenreOutputData user);
    void prepareFailView(String error);

}
