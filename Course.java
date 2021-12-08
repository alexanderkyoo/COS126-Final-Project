import java.util.ArrayList;

public class Course {
    private String Cname;
    private ArrayList<Double> grades;

    public Course(String name) {
        Cname = name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public String getName()
    {
        return Cname;
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
