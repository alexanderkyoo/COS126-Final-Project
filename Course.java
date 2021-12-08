

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

    public String getName()
    {
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

    public static void main(String[] args) {

    }
}
