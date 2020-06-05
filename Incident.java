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

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getSex() {
        return sex;
    }

    public void setSex(double sex) {
        this.sex = sex;
    }

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getTrestbps() {
        return trestbps;
    }

    public void setTrestbps(double trestbps) {
        this.trestbps = trestbps;
    }

    public double getChol() {
        return chol;
    }

    public void setChol(double chol) {
        this.chol = chol;
    }

    public double getFbs() {
        return fbs;
    }

    public void setFbs(double fbs) {
        this.fbs = fbs;
    }

    public double getRestecg() {
        return restecg;
    }

    public void setRestecg(double restecg) {
        this.restecg = restecg;
    }

    public double getThalach() {
        return thalach;
    }

    public void setThalach(double thalach) {
        this.thalach = thalach;
    }

    public double getExang() {
        return exang;
    }

    public void setExang(double exang) {
        this.exang = exang;
    }

    public double getOldpeak() {
        return oldpeak;
    }

    public void setOldpeak(double oldpeak) {
        this.oldpeak = oldpeak;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getThal() {
        return thal;
    }

    public void setThal(double thal) {
        this.thal = thal;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

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

    Incident()
    {

    }

    void print()
    {
        System.out.print(age);
        System.out.print(" ");
        System.out.print(sex);
        System.out.print(" ");
        System.out.print(cp);
        System.out.print(" ");
        System.out.print(trestbps);
        System.out.print(" ");
        System.out.print(chol);
        System.out.print(" ");
        System.out.print(fbs);
        System.out.print(" ");
        System.out.print(restecg);
        System.out.print(" ");
        System.out.print(thalach);
        System.out.print(" ");
        System.out.print(exang);
        System.out.print(" ");
        System.out.print(oldpeak);
        System.out.print(" ");
        System.out.print(slope);
        System.out.print(" ");
        System.out.print(ca);
        System.out.print(" ");
        System.out.print(thal);
        System.out.print(" ");
        System.out.print(num);
        System.out.print(" ");
    }
}
