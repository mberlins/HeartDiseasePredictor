package standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reading
{

    ArrayList<DataSet> samples;
    DataSet sample;
    ArrayList<Integer> counters;

    public ArrayList<Integer> getCounters() {
        return counters;
    }

    public ArrayList<DataSet> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<DataSet> samples) {
        this.samples = samples;
    }

    Reading()
    {
        sample = new DataSet();
        samples = new ArrayList<DataSet>();
        counters = new ArrayList<Integer>();
    }

    void readFile(File file) throws FileNotFoundException
    {

        System.out.print("Reading initialized\n\n");
        int counter = 0;
        DataSet temporary = new DataSet();
        double[] position;
        position = new double[14];

        Scanner in = new Scanner(file);

        while (in.hasNextLine())
        {
            counter++;
            String tmp = in.nextLine();
            String[] parts = tmp.split(",");


            for (int i = 0; i < parts.length; i++)
            {
                double help = 0;
                if (parts[i].equals("?"))
                {
                    help = -1;
                }
                else
                    help = Double.parseDouble(parts[i]);

                position[i] = help;
            }


            Incident incident = new Incident(position);

            temporary.addIncident(incident);

        }
        samples.add(temporary);

        counters.add(counter);
    }
}
