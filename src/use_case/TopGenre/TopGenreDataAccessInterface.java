package use_case.TopGenre;
import entity.Genre;

public interface TopGenreDataAccessInterface {
    Genre[] getTopGenres(String id, String timeframe);
}

