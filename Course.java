import java.util.ArrayList;

public class Course {
    private String cName;
    private ArrayList<Double> grades;

    public Course(String name) {
        cName = name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public String getName() {
        return cName;
    }

    public double getAvg() {
        if (grades.isEmpty()) {
            return 100;
        }

        int avg = 0;
        for (int i = 0; i < grades.size(); i++) {
            avg += grades.get(i);
        }
        return avg / (grades.size());
    }

    public double assignment(int size, double time, int intelligence) {
        double score = 0;
        if (time == 0)
        {
            return 0;
        }
        else if (5 * size * time >= intelligence)
        {
            return intelligence;
        }
        else
        {
            return StdRandom.uniform(5 * size * time, intelligence);
        }
    }

    public static void main(String[] args) {

    }
}
