package use_case.top_artists;

import java.util.List;

public class TopArtistsOutputData {
    private final List<String> artistNames;

    private boolean useCaseFailed;

    public TopArtistsOutputData(List<String> artistNames, boolean useCaseFailed) {
        this.artistNames = artistNames;
        this.useCaseFailed = useCaseFailed;

    }

    public List<String> getArtistNames() {
        return artistNames;
    }
}
