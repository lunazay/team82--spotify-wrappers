package interface_adapter.top_album;

import java.util.Collections;
import java.util.List;

public class TopAlbumState {

    private List<String> topAlbumNames = Collections.emptyList();

    private String error = null;
    public TopAlbumState(TopAlbumState copy){
        topAlbumNames = copy.topAlbumNames;
        error = copy.error;
    }

    public TopAlbumState() {}

    // TODO: complete the rest of the state

    public void setError(String error){
        this.error = error;
    }





}
