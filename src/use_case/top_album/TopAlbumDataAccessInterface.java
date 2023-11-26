package use_case.top_album;
import entity.Song;

import java.util.List;

public interface TopAlbumDataAccessInterface {
    List<String> getTopAlbums(String id, String timeframe) throws Exception;

}
