import java.util.ArrayList;

public class Grades {
    private static ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();

    public static void addAssignment(Assignment a) {
        assignmentList.add(a);
    }

    public static void scoreAssignment(Assignment a, Person p) {
        int tier = a.getTier();
        int intelligence = p.getIntelligence();
        // SAMPLE CALCULATION --> change this calculation later
        double score = tier * intelligence;
        a.setScore(score);
    }

    public static double calculateGPA() {
        if (assignmentList.size() == 0)
            return 100.0;

        double total = 0.0;
        for (Assignment a : assignmentList) {
            total += a.getScore();
        }
        return total / assignmentList.size();
    }

    /* public String assignment(String class, int time, int intelligence) {
        int index = 0;
        for (int i = 0; i < classes.length; i++) {

        }
    } */
}
