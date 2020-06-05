package standard;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {

        Reading start = new Reading();
        File cleveland = new File("C:\\Users\\Admin\\IdeaProjects\\HeartDiseasePredictor\\src\\standard\\processed.cleveland.data");
        File magyarorszag = new File("C:\\Users\\Admin\\IdeaProjects\\HeartDiseasePredictor\\src\\standard\\processed.hungarian.data");
        File suisse = new File("C:\\Users\\Admin\\IdeaProjects\\HeartDiseasePredictor\\src\\standard\\processed.switzerland.data");
        File va = new File("C:\\Users\\Admin\\IdeaProjects\\HeartDiseasePredictor\\src\\standard\\processed.va.data");
        start.readFile(cleveland);
        start.readFile(magyarorszag);
        start.readFile(suisse);
        start.readFile(va);

    }
}
