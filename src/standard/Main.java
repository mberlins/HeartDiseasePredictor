package standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;


public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        DataSet dataSet = new DataSet();
        Incident incident = new Incident();
        Reading start = new Reading();


        File cleveland = new File("processed.cleveland.data");
        File magyarorszag = new File("processed.hungarian.data");
        /*File suisse = new File("processed.switzerland.data");
        File va = new File("processed.va.data");*/
        start.readFile(cleveland);
        start.readFile(magyarorszag);
        /*start.readFile(suisse);
        start.readFile(va);*/




        AdaBoost adaBoost = new AdaBoost(start.samples.get(0));

        adaBoost.train();

        int tmp = 0;
        int correct = 0;
        for(int i = 0; i < start.getCounters().get(0); i++)
        {
            tmp = adaBoost.classify(start.samples.get(0).incidents.get(i));
            if(start.samples.get(0).incidents.get(i).getNum() == 0 && tmp == 0)
                correct++;
            if(start.samples.get(0).incidents.get(i).getNum() > 0 && tmp == 1)
                correct++;
        }
        System.out.println(correct);
    }
}