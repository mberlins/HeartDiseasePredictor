package standard;

import java.util.ArrayList;

public class DataSet
{
    ArrayList<Incident> incidents = new ArrayList<Incident>();

    void addIncident(Incident sample)
    {
        incidents.add(sample);
    }

    void print()
    {
        Incident tmp = new Incident();


        System.out.print("\n\nPrinting initialized \n\n\n\n");
        for (int i=0; i < incidents.size(); i++)
        {

            tmp = incidents.get(i);
            tmp.print();
            System.out.print("\n");

        }
    }
}
