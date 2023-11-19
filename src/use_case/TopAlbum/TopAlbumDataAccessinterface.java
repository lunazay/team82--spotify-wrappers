package use_case.TopAlbum;
import entity.Song;

public interface TopAlbumDataAccessinterface {
    Song[] getTopAlbums(String id, String timeframe);

}
