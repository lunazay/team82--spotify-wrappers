package use_case.top_genre;

import java.util.List;

public class TopGenreOutputData {

    private List<String> genreNames;

    private boolean useCaseFailed;

    public TopGenreOutputData(List<String> genreNames, boolean useCaseFailed) {
        this.genreNames = genreNames;
        this.useCaseFailed = useCaseFailed;

    }

    public List<String> getGenreNames() {
        return genreNames;
    }
}
