package use_case.get_valence;

import java.io.IOException;

public interface GetValenceDataAccessInterface {

    String getValence(String id, String timeframe) throws Exception;
}
