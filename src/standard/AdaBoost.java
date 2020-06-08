package standard;

import java.util.ArrayList;

public class AdaBoost
{
    private ArrayList<DecisionStump> trainedStumps = new ArrayList<DecisionStump>();
    private ArrayList<DecisionStump> defaultStumps = new ArrayList<DecisionStump>();

    DataSet dataSet = new DataSet();
    Reading start = new Reading();




    public AdaBoost()
    {
        for( int i = 0; i < 13; i++)
        {
            defaultStumps.add(new DecisionStump(i));
        }
    }

    public DecisionStump chooseBestStump(ArrayList<Incident> incidents)
    {
        DecisionStump tmp;
        double quality;
        double lowest = 1234567;
        int result = -1;

        for( int i = 0; i < 13; i++)
        {
            quality = defaultStumps.get(i).stumpGiniImpurity(incidents);

            if (quality < lowest)
            {
                lowest = quality;
                result = i;
            }
        }

        defaultStumps.get(result).setIfUsed(true);
        return defaultStumps.get(result);
    }

    public void train()
    {
        int i = 0;

        while(i < 13)
        {

        }
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
