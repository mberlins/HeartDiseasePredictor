package standard;

public class Test
{
    Reading start;
    AdaBoost adaBoost;

    Test(Reading reading, AdaBoost adaBoost)
    {
        start = reading;
        this.adaBoost = adaBoost;
    }

    void test()
    {
        for (int j = 0; j < start.getCounters().size(); j++)
        {
            int tmp = 0;
            int correct = 0;

            for(int i = 0; i < start.getCounters().get(j); i++)
            {
                tmp = adaBoost.classify(start.samples.get(j).incidents.get(i));
                if(start.samples.get(j).incidents.get(i).getNum() == 0 && tmp == 0)
                    correct++;
                if(start.samples.get(j).incidents.get(i).getNum() > 0 && tmp == 1)
                    correct++;
            }
            double help = (double)correct/start.getCounters().get(j) * 100;
            System.out.println("Skutecznosc przewidywania wynosi: " + help +"%");
        }
    }
}


