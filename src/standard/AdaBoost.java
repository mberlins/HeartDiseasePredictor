package standard;


import java.util.ArrayList;

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
            //System.out.println(quality);
            if (quality < lowest && !defaultStumps.get(i).isIfUsed())
            {
                lowest = quality;
                result = i;
            }
        }

        //System.out.println(result);
        defaultStumps.get(result).setIfUsed(true);
        return defaultStumps.get(result);
    }

    public void train()
    {
        DecisionStump tmp;

        int i = 0;
        while(i < 5) // dla płci threshold ustawić
        {

            tmp = chooseBestStump(dataSet.incidents);


            //System.out.println(tmp.getThreshold());

            dataSet.setInitialWeights();



            tmp.calculateAmountOfSay(dataSet.incidents);

            /*for (int j = 0; j < dataSet.incidents.size(); j++)
            {

                System.out.println(dataSet.incidents.get(j).getWeight());
            }*/



            tmp.updateIncidentWeights(dataSet.incidents);

            /*for (int j = 0; j < dataSet.incidents.size(); j++)
            {

                System.out.println(dataSet.incidents.get(j).getWeight());
                i++;
            }
*/
            /*if(i == 1)
                break;*/



            dataSet.incidents = tmp.createNewIncidents(dataSet.incidents);




            //dataSet.incidents = tmp;

            //dataSet.setInitialWeights();


            i++;
        }

        for(int k = 0; k < 13; k++)
            System.out.println(defaultStumps.get(k).amountOfSay);
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
