package use_case.GetValence;

import java.io.IOException;

public interface GetValenceDataAccessInterface {

    String getValence(String id, String timeframe) throws IOException;
}
