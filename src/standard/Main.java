package standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;


public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        long timeStart=System.currentTimeMillis();

        Reading start = new Reading();


        File cleveland = new File("processed.cleveland.data");
        File magyarorszag = new File("processed.hungarian.data");
        File suisse = new File("processed.switzerland.data");
        File va = new File("processed.va.data");
        File all = new File ("processed.all.data");
        start.readFile(cleveland);
        start.readFile(magyarorszag);
        start.readFile(suisse);
        start.readFile(va);
        start.readFile(all);

        AdaBoost adaBoost = new AdaBoost(start.samples.get(0));
        adaBoost.train();

        Test test = new Test(start, adaBoost);
        test.test();

        long timeStop=System.currentTimeMillis();
        System.out.println("Czas trenowania: "+ (timeStop - timeStart));
    }
}