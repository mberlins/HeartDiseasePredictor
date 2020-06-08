package standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reading
{
    int counter;
    ArrayList<DataSet> samples;
    DataSet sample;
    //ArrayList<String> line;
    //double[] position;


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ArrayList<DataSet> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<DataSet> samples) {
        this.samples = samples;
    }

    Reading()
    {
        counter = 0;
        sample = new DataSet();
        samples = new ArrayList<DataSet>();
        //line = new ArrayList<String>();
        //position = new double[14];
    }

    void readFile(File file) throws FileNotFoundException
    {
        System.out.print("Reading initialized\n\n");

        double[] position;
        position = new double[14];

        //File cleveland = new File("C:\\Users\\Admin\\IdeaProjects\\HeartDiseasePredictor\\src\\standard\\processed_cleveland.txt");
        Scanner in = new Scanner(file);

        while (in.hasNextLine())
        {
            String tmp = in.nextLine();
            System.out.print(tmp);
            System.out.print("\n");
            //line.add(in.nextLine());
            //System.out.print(line.get(0));

            String[] parts = tmp.split(",");

        /*for (int i = 0; i < parts.length; i++)
        {
            System.out.println(parts[i]);
        }*/

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

        /*for (int i = 0; i < parts.length; i++)
        {
            System.out.println(position[i]);
        }*/

            Incident incident = new Incident(position);

            sample.addIncident(incident);

        }
        samples.add(sample);

        counter++;
    }


}
