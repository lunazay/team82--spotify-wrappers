package use_case.TopGenre;
import entity.Genre;

import java.io.IOException;
import java.util.ArrayList;

public interface TopGenreDataAccessInterface {
    ArrayList<Genre> getTopGenres(String id, String timeframe) throws IOException;
}

