package api;

import entity.User;
import entity.Artist;
import org.json.JSONException;

public interface DevelopDB {
    User getTopSongs();

    User getTopArtist();
}
