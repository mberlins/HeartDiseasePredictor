package standard;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class DecisionStump
{
    private double threshold;
    private double amountOfSay;
    private int greaterNodeIll, greaterNodeHealthy, lowerNodeIll, lowerNodeHealthy;


    /**
     * oblicza giniImpurity dla swojego słabego klasyfikatora
     */
    public double giniImpurityStump(int yes1, int no1, int yes2, int no2)
    {
        double gini1, gini2, Totalgini, totalNum, total1, total2;
        total1 = yes1 + no1;
        total2 = yes2 + no2;
        totalNum = total1 + total2;
        gini1 = 1 - pow((yes1 / (total1)), 2) - pow((no1 / (total1)), 2);
        gini2 = 1 - pow((yes2 / (total2)), 2) - pow((no2 / (total2)), 2);
        Totalgini = gini1 * (total1 / totalNum) + gini2 * (total2 / totalNum);

        return Totalgini;
    }

    /**
     * zlicza trafione i nietrafione wyniki klasyfikacji
     */
    public void tryIncidents(ArrayList<Incident> incidents, int attribute)
    {

        double value;

        for (Incident incident : incidents) {
            value = incident.getterSuperieur(attribute);

            if (value <= threshold && incident.getNum() > 0)
                lowerNodeIll++;
            else if (value <= threshold && incident.getNum() == 0)
                lowerNodeHealthy++;
            else if (value > threshold && incident.getNum() > 0)
                greaterNodeIll++;
            else if (value > threshold && incident.getNum() == 0)
                greaterNodeHealthy++;
        }
    }

    /**
     * oblicza najlepszy próg podziału dla swojego słabego klasyfikatora
     */
    public void calculateThreshold (ArrayList<Incident> incidents, int attribute)
    {
        int lowerNodeIll = 0;
        int lowerNodeHealthy = 0;
        int greaterNodeIll = 0;
        int greaterNodeHealthy = 0;
        double value = 0;
        double localThreshold = 0;
        double lowestImpurity = 1;
        double tmp;

        for (Incident incident : incidents) {

            localThreshold = incident.getterSuperieur(attribute);


            for (Incident incident2 : incidents) {
            value = incident2.getterSuperieur(attribute);

            if (value <= localThreshold && incident2.getNum() > 0)
                lowerNodeIll++;
            else if (value <= localThreshold && incident2.getNum() == 0)
                lowerNodeHealthy++;
            else if (value > localThreshold && incident2.getNum() > 0)
                greaterNodeIll++;
            else if (value > localThreshold && incident2.getNum() == 0)
                greaterNodeHealthy++;
            }

            tmp = giniImpurityStump(lowerNodeIll, lowerNodeHealthy, greaterNodeIll, greaterNodeHealthy);

            if(lowestImpurity > tmp)
            {
                threshold = localThreshold;
                lowestImpurity = tmp;
            }
        }
    }

    public void setThreshold(double threshold)
    {
        this.threshold = threshold;
    }

    public double getThreshold()
    {
        return threshold;
    }
}
