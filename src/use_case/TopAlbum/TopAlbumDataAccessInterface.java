package use_case.TopAlbum;
import entity.Song;

public interface TopAlbumDataAccessInterface {
    Song[] getTopAlbums(String id, String timeframe);

}
