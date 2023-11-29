package interface_adapter.top_album;

import java.util.ArrayList;
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


    public void setTopAlbumNames(List<String> topAlbumNames) {

        this.topAlbumNames = topAlbumNames;
    }

    public List<String> getTopAlbumNames(List<String> topAlbumNames) {

        return topAlbumNames;

    }

    public void setError(String error){

        this.error = error;
    }
    public String getError() {

        return this.error;
    }

    @Override
    public String toString(){

        return "TopAlbumState{" + "topAlbumNames='" + topAlbumNames + '}';
    }







}
