package standard;

import java.util.ArrayList;

/**
 * klasa obsługująca algorytm adaptive boosting
 */
public class AdaBoost
{
    private ArrayList<DecisionStump> trainedStumps = new ArrayList<DecisionStump>();
    private ArrayList<DecisionStump> defaultStumps = new ArrayList<DecisionStump>();
    private ArrayList<Incident> tmpp = new ArrayList<Incident>();

    DataSet dataSet;

    public AdaBoost(DataSet dataSet)
    {
        this.dataSet = dataSet;

        for( int i = 0; i < 13; i++)
        {
            defaultStumps.add(new DecisionStump(i));
        }
    }

    /**
     * wybiera klasyfikator z najniższym gini impurity, najlepiej dzielącego dane
     */
    public DecisionStump chooseBestStump(ArrayList<Incident> incidents)
    {
        DecisionStump tmp;
        double quality;
        double lowest = 1234567;
        int result = -1;

        for( int i = 0; i < 13; i++)
        {
            if(i == 1)
                defaultStumps.get(i).setThreshold(0.5);
            else
                defaultStumps.get(i).calculateThreshold(incidents);



            quality = defaultStumps.get(i).stumpGiniImpurity(incidents);

            if (quality < lowest && !defaultStumps.get(i).isIfUsed())
            {
                lowest = quality;
                result = i;
            }
        }

        System.out.println(result);
        defaultStumps.get(result).setIfUsed(true);
        return defaultStumps.get(result);
    }

    /**
     * metoda odpowiadająca za trenowanie klasyfikatorów
     */
    public void train()
    {
        DecisionStump tmp;

        int i = 0;
        while(i < 13) // dla płci threshold ustawić
        {
            tmp = chooseBestStump(dataSet.incidents);

            dataSet.setInitialWeights();

            tmp.calculateAmountOfSay(dataSet.incidents);


            tmp.updateIncidentWeights(dataSet.incidents);

            dataSet.incidents = tmp.createNewIncidents(dataSet.incidents);

            i++;
        }
    }

    /**
     * klasyfikuje rekordy
     */
    public int classify(Incident incident)
    {
        double illAmountOfSay = 0.0;
        double healthyAmountOfSay = 0.0;
        int tmp;

        for(int i = 0; i < 13; i++)
        {
            tmp = defaultStumps.get(i).classify(incident);
            if(tmp == 1)
                illAmountOfSay = illAmountOfSay + defaultStumps.get(i).getAmountOfSay();
            if(tmp == 0)
                healthyAmountOfSay = healthyAmountOfSay + defaultStumps.get(i).getAmountOfSay();
        }

        if(healthyAmountOfSay <= illAmountOfSay)
            return 1;
        else
            return 0;
    }

    public ArrayList<DecisionStump> getTrainedStumps() {
        return trainedStumps;
    }

    public void setTrainedStumps(ArrayList<DecisionStump> trainedStumps) {
        this.trainedStumps = trainedStumps;
    }

    public ArrayList<DecisionStump> getDefaultStumps() {
        return defaultStumps;
    }

    public void setDefaultStumps(ArrayList<DecisionStump> defaultStumps) {
        this.defaultStumps = defaultStumps;
    }
}