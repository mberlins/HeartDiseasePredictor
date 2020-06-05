package standard;

public class Incident
{
    private double age;
    private double sex;
    private double cp;
    private double trestbps;
    private double chol;
    private double fbs;
    private double restecg;
    private double thalach;
    private double exang;
    private double oldpeak;
    private double slope;
    private double ca;
    private double thal;
    private double num;                //predicted atribute

    Incident(double[] values)
    {
        this.age = values[0];
        this.sex = values[1];
        this.cp = values[2];
        this.trestbps = values[3];
        this.chol = values[4];
        this.fbs = values[5];
        this.restecg = values[6];
        this.thalach = values[7];
        this.exang = values[8];
        this.oldpeak = values[9];
        this.slope = values[10];
        this.ca = values[11];
        this.thal = values[12];
        this.num = values[13];
    }
}
