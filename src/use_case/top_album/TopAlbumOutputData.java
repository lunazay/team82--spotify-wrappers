package use_case.top_album;

import java.util.List;

public class TopAlbumOutputData {
    private List<String> albumNames;

    private boolean useCaseFailed;

    public TopAlbumOutputData(List<String> albumNames, boolean useCaseFailed) {
        this.albumNames = albumNames;
        this.useCaseFailed = useCaseFailed;

    }

    public List<String> getAlbumNames() {
        return albumNames;
    }
}
