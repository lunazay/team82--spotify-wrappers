package use_case.top_genre;


import java.util.ArrayList;

public class TopGenreOutputData {

    private ArrayList<String> genreNames;

    private Integer genreNumber;

    private boolean useCaseFailed;

    public TopGenreOutputData(ArrayList<String> genreNames, boolean useCaseFailed, Integer genreNumber) {
        this.genreNames = genreNames;
        this.useCaseFailed = useCaseFailed;
        this.genreNumber = genreNumber;
    }

    public ArrayList<String> getGenreNames() {
        return genreNames;
    }
}
