package standard;

import java.util.ArrayList;

public class DataSet
{
    ArrayList<Incident> incidents = new ArrayList<Incident>();

    void addIncident(Incident sample)
    {
        incidents.add(sample);
    }

    void print()
    {
        Incident tmp = new Incident();

        System.out.print("\n\nPrinting initialized \n\n\n\n");
        for (int i=0; i < incidents.size(); i++)
        {
            tmp.setAge(incidents.get(i).getAge());
            tmp.setSex(incidents.get(i).getSex());
            tmp.setCp(incidents.get(i).getCp());
            tmp.setTrestbps(incidents.get(i).getTrestbps());
            tmp.setChol(incidents.get(i).getChol());
            tmp.setFbs(incidents.get(i).getFbs());
            tmp.setRestecg(incidents.get(i).getRestecg());
            tmp.setThalach(incidents.get(i).getThalach());
            tmp.setExang(incidents.get(i).getExang());
            tmp.setOldpeak(incidents.get(i).getOldpeak());
            tmp.setSlope(incidents.get(i).getSlope());
            tmp.setCa(incidents.get(i).getCa());
            tmp.setThal(incidents.get(i).getThal());
            tmp.setNum(incidents.get(i).getNum());

            tmp.print();
            System.out.print("\n");

        }
    }
}
