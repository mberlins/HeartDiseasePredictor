package standard;

import javafx.scene.transform.MatrixType;

import java.util.ArrayList;

import java.lang.Math;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.exp;

public class DecisionStump
{
    private int attribute;
    private double threshold;
    public double amountOfSay;
    private int greaterNodeIll, greaterNodeHealthy, lowerNodeIll, lowerNodeHealthy;
    private int correctlyClassified, wronglyClassified;
    private boolean greaterIll;
    private boolean ifUsed = false;


    DecisionStump(int attribute)
    {
        this.attribute = attribute;
    }

    /**
     * oblicza giniImpurity dla swojego słabego klasyfikatora
     */
    public double giniImpurity(int yes1, int no1, int yes2, int no2)
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
    public double stumpGiniImpurity(ArrayList<Incident> incidents)
    {
        lowerNodeIll = 0;
        lowerNodeHealthy = 0;
        greaterNodeIll = 0;
        greaterNodeHealthy = 0;
        int i = 0;
        double value;

        for (Incident incident : incidents)
        {
            value = incident.getterSuperieur(attribute);

            if (value <= threshold && incident.getNum() > 0)
                lowerNodeIll++;
            else if (value <= threshold && incident.getNum() == 0)
                lowerNodeHealthy++;
            else if (value > threshold && incident.getNum() > 0)
                greaterNodeIll++;
            else if (value > threshold && incident.getNum() == 0)
                greaterNodeHealthy++;

            i++;
        }


        /*if(lowerNodeIll == 0 && greaterNodeIll == 0 && greaterNodeHealthy == 0)
            System.out.println(i);*/
        /*System.out.println(lowerNodeIll);
        System.out.println(lowerNodeHealthy);
        System.out.println(greaterNodeIll);
        System.out.println(greaterNodeHealthy);*/
        return giniImpurity(lowerNodeIll, lowerNodeHealthy, greaterNodeIll, greaterNodeHealthy);
    }

    /**
     * oblicza swój najlepszy próg podziału
     */
    public void calculateThreshold (ArrayList<Incident> incidents)
    {
        int lowerNodeIll = 0;
        int lowerNodeHealthy = 0;
        int greaterNodeIll = 0;
        int greaterNodeHealthy = 0;
        double value = 0;
        double localThreshold = 0;
        double lowestImpurity = 1;
        double tmp;

        for (Incident incident : incidents)
        {
            localThreshold = incident.getterSuperieur(attribute);

            for (Incident incident2 : incidents)
            {
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

            tmp = giniImpurity(lowerNodeIll, lowerNodeHealthy, greaterNodeIll, greaterNodeHealthy);

            if(lowestImpurity > tmp)
            {
                threshold = localThreshold;
                lowestImpurity = tmp;
            }
        }

    }

    /**
     * zakładamy, że dobrze sklasyfikowanych próbek będzie zawsze więcej niż tych źle JAKOŚ INACZEJ TO ZROBIĆ? JAK WERYFIKOWAĆ KTÓRE SĄ DOBRE, A KTÓRE ZŁE
     */
    public void calculateAmountOfSay(ArrayList<Incident> incidents)
    {
        double totalError;

        if(greaterNodeHealthy + lowerNodeIll > greaterNodeIll + lowerNodeHealthy)
        {
            correctlyClassified = greaterNodeHealthy + lowerNodeIll;
            wronglyClassified = greaterNodeIll + lowerNodeHealthy;
            greaterIll = false;
        }
        else
        {
            wronglyClassified = greaterNodeHealthy + lowerNodeIll;
            correctlyClassified = greaterNodeIll + lowerNodeHealthy;
            greaterIll = true;
        }

        totalError = wronglyClassified * incidents.get(0).getWeight(); // obojętnie jaki rekord, wszystkie na tym etapie będą miały takie same wagi, nowa tablica, rozkład prawdop

        if(totalError != 0)
            amountOfSay = 0.5 * Math.log((1 - totalError) / totalError);
        else
            amountOfSay = 10; // jakoś dużo, przymyśleć jeszcze



    }

    /**
     * ustawia nowe wagi dla incidents, im wiekszy stump ma glos, tym slabiej będą liczyły się trafione przez niego probki,
     * ale o wiele mocniej beda liczyly sie nietrafione przez niego probki.
     */
    public void updateIncidentWeights(ArrayList<Incident> incidents) // cos za ladnie sie dodaja wszystkie wagi przed normalizacja
    {
        double value;
        double normalization = 0.0;
        double tmp = 0.0;




        if(greaterIll)
        {

            for (Incident incident : incidents) {
                value = incident.getterSuperieur(attribute);


                if (value <= threshold && incident.getNum() > 0) { // nietrafiona probka
                    incident.setWeight(incident.getWeight() * exp(amountOfSay));
                }
                else if (value <= threshold && incident.getNum() == 0) { // trafiona probka
                    incident.setWeight(incident.getWeight() * exp((-1) * amountOfSay));
                }
                else if (value > threshold && incident.getNum() > 0) { // trafiona probka
                    incident.setWeight(incident.getWeight() * exp((-1) * amountOfSay));
                }
                else if (value > threshold && incident.getNum() == 0) { // nietrafiona probka
                    incident.setWeight(incident.getWeight() * exp(amountOfSay));
                }

            }
        }
        else
        {
            for (Incident incident : incidents)
            {
                value = incident.getterSuperieur(attribute);

                if (value <= threshold && incident.getNum() > 0) // trafiona probka
                    incident.setWeight(incident.getWeight() * exp((-1) * amountOfSay));
                else if (value <= threshold && incident.getNum() == 0) // nietrafiona probka
                    incident.setWeight(incident.getWeight() * exp(amountOfSay));
                else if (value > threshold && incident.getNum() > 0) // nietrafiona probka
                    incident.setWeight(incident.getWeight() * exp(amountOfSay));
                else if (value > threshold && incident.getNum() == 0) // trafiona probka
                    incident.setWeight(incident.getWeight() * exp((-1) * amountOfSay));
            }
        }




        // Normalizacja wag:
        for (Incident incident : incidents)
        {
            normalization = normalization + incident.getWeight();
        }



        double xd = 0;
        for (Incident incident : incidents)
        {
            xd = xd + (incident.getWeight() / normalization);
            incident.setWeight(incident.getWeight() / normalization);
        }

    }

    /**
     * tworzy nową tablicę dla nastepnego słabego klasyfikatora
     */
    public ArrayList<Incident> createNewIncidents(ArrayList<Incident> incidents)
    {
        ArrayList<Incident> newIncidents = new ArrayList<Incident>();
        double weight = 0;


        for (Incident incident : incidents)
        {
            weight = weight + incident.getWeight();
            incident.setWeight(weight);
        }

        Random random = new Random();
        double randomValue;

        //System.out.println(incidents.get(0).getWeight());
        for (int i = 0; i < incidents.size(); i++)
        {
            randomValue = random.nextDouble();
            for (int j = 0; j < incidents.size(); j++)
            {
                if(randomValue < incidents.get(j).getWeight())
                {
                    Incident tmp = new Incident();
                    tmp.copyAttributes(incidents.get(i));
                    newIncidents.add(tmp);
                    break;
                }
            }
        }

        return newIncidents;
    }

    /**
     * 1 - zakwalifikowano jako chory, 0 - zakwalifikowano jako zdrowy
     */
    public int classify(Incident incident)
    {
        if(greaterIll)
        {
            if(incident.getterSuperieur(attribute) <= threshold)
                return 0;
            else
                return 1;
        }
        else
        {
            if(incident.getterSuperieur(attribute) <= threshold)
                return 1;
            else
                return 0;
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

    public double getAmountOfSay()
    {
        return amountOfSay;
    }

    public void setAmountOfSay(double amountOfSay)
    {
        this.amountOfSay = amountOfSay;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public boolean isIfUsed()
    {
        return ifUsed;
    }

    public void setIfUsed(boolean ifUsed)
    {
        this.ifUsed = ifUsed;
    }
}