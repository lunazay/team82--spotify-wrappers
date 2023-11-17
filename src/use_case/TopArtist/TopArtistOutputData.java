package use_case.TopArtist;

import java.util.List;

public class TopArtistOutputData {
    private List<String> artistNames;

    private boolean useCaseFailed;

    public TopArtistOutputData(List<String> artistNames, boolean useCaseFailed) {
        this.artistNames = artistNames;
        this.useCaseFailed = useCaseFailed;

    }

    public List<String> getArtistNames() {
        return artistNames;
    }
}
