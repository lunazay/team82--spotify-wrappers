package use_case.top_genre;

import java.util.List;

public class TopGenreOutputData {

    private List<String> genreNames;

    private Integer genreNumber;

    private boolean useCaseFailed;

    public TopGenreOutputData(List<String> genreNames, boolean useCaseFailed, Integer genreNumber) {
        this.genreNames = genreNames;
        this.useCaseFailed = useCaseFailed;
        this.genreNumber = genreNumber;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }
}
