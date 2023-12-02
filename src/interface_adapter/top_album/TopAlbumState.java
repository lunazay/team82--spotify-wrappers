package interface_adapter.top_album;

import java.util.Collections;
import java.util.List;

public class TopAlbumState {
    public List<String> topAlbumNames = Collections.emptyList();
    private String albumsError = null;

    public TopAlbumState() {}

    public void setTopAlbumNames(List<String> topAlbumNames) {
        this.topAlbumNames = topAlbumNames;
    }

    public List<String> getTopAlbumNames() {
        return topAlbumNames;

    }

    public void setAlbumsError(String error){
        this.albumsError = error;
    }
    public String getAlbumsError() {
        return this.albumsError;
    }

    @Override
    public String toString(){
        return "TopAlbumState{" + "topAlbumNames='" + topAlbumNames + '}';
    }
}
