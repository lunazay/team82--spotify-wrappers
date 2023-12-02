package use_case.top_genre;
import entity.Genre;

import java.util.ArrayList;

public interface TopGenreDataAccessInterface {
    ArrayList<Genre> getTopGenres(String id, String timeframe) throws Exception;
}

