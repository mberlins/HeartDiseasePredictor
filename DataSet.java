package standard;

import java.util.ArrayList;

public class DataSet
{
    ArrayList incidents = new ArrayList();

    void addIncident(Incident sample)
    {
        incidents.add(sample);
    }
}
