package standard;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        DataSet dataSet = new DataSet();
        Incident incident = new Incident();

        Reading start = new Reading();
        File cleveland = new File("processed.cleveland.data");
        /*File magyarorszag = new File("processed.hungarian.data");
        File suisse = new File("processed.switzerland.data");
        File va = new File("processed.va.data");*/
        start.readFile(cleveland);
        /*start.readFile(magyarorszag);
        start.readFile(suisse);
        start.readFile(va);*/

        //start.samples.get(0).print();



        DecisionStump a = new DecisionStump();

        a.setThreshold(30);

        a.tryIncidents(start.samples.get(0).incidents, 0);


        a.calculateThreshold(start.samples.get(0).incidents, 0);
        System.out.print(a.getThreshold());


        //System.out.print(a.giniImpurityStump(105, 39, 34, 125));
    }
}
