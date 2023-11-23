package use_case.top_album;
import entity.Song;

public interface TopAlbumDataAccessInterface {
    Song[] getTopAlbums(String id, String timeframe);

}
