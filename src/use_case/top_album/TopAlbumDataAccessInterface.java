package use_case.top_album;
import entity.Album;

import java.util.ArrayList;

public interface TopAlbumDataAccessInterface {
    ArrayList<Album> getTopAlbums(String id, String timeframe) throws Exception;

}
