package standard;

public class Incident
{
    /**
     * Oznacza wiek pacjenta w latach
     */
    private double age;
    /**
     * Oznacza płeć pacjenta (1 - mężczyzna, 0 - kobieta)
     */
    private double sex;
    /**
     * Typ bólu w klatce piersiowej
     */
    private double cp;
    /**
     * Ciśnienie krwi spoczynkowe
     */
    private double trestbps;
    /**
     * Poziom cholesterolu
     */
    private double chol;
    /**
     * poziom cukru we krwi wyższy od 120mg/dl (1 - prawda, 0 - fałsz)
     */
    private double fbs;
    /**
     * Wynik elektrokardiografii
     */
    private double restecg;
    /**
     * Maksymalne osiągnięte tętno
     */
    private double thalach;
    /**
     * exercise induced angina (1 = yes; 0 = no)
     */
    private double exang;
    /**
     *
     */
    private double oldpeak;
    private double slope;
    private double ca;
    private double thal;
    private double num;                //predicted atribute
    private double weight;


    public double getterSuperieur(int index)
    {
        switch (index)
        {
            case 0:
                return age;
            case 1:
                return sex;
            case 2:
                return cp;
            case 3:
                return trestbps;
            case 4:
                return  chol;
            case 5:
                return  fbs;
            case 6:
                return restecg;
            case 7:
                return thalach;
            case 8:
                return exang;
            case 9:
                return oldpeak;
            case 10:
                return slope;
            case 11:
                return ca;
            case 12:
                return thal;
            case 13:
                return num;

            default: return -1;
        }
    }

    public void setterSuperieur(int index, double value)
    {
        switch (index)
        {
            case 0:
                setAge(value);
                break;
            case 1:
                setSex(value);
                break;
            case 2:
                setCp(value);
                break;
            case 3:
                setTrestbps(value);
                break;
            case 4:
                setChol(value);
                break;
            case 5:
                setFbs(value);
                break;
            case 6:
                setRestecg(value);
                break;
            case 7:
                setThalach(value);
                break;
            case 8:
                setExang(value);
                break;
            case 9:
                setOldpeak(value);
                break;
            case 10:
                setSlope(value);
                break;
            case 11:
                setCa(value);
                break;
            case 12:
                setThal(value);
                break;
            case 13:
                setNum(value);
                break;
        }
    }

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

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public void setNum(double num) {
        this.num = num;
    }

    /**
     * Konstruktor klasy Incident
     * @param values przekazuje wartości dla pól klasy
     */
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

    /**
     * Konstruktor bezargumentowy
     */
    Incident()
    {

    }

    /**
     * Funkcja wypisująca wartości wszystkich pól klasy i oddzielająca je spacjami
     */
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
        System.out.print(weight);
        System.out.print(" ");
    }

    void copyAttributes(Incident incident)
    {
        this.age = incident.getAge();
        this.sex = incident.getSex();
        this.cp = incident.getCp();
        this.trestbps = incident.getTrestbps();
        this.chol = incident.getChol();
        this.fbs = incident.getFbs();
        this.restecg = incident.getRestecg();
        this.thalach = incident.getThalach();
        this.exang = incident.getExang();
        this.oldpeak = incident.getOldpeak();
        this.slope = incident.getSlope();
        this.ca = incident.getCa();
        this.thal = incident.getThal();
        this.num = incident.getNum();
        this.weight = incident.getWeight();
    }
}

