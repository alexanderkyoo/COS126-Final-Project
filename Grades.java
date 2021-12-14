import java.util.ArrayList;

public class Grades {
    private static ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();

    public static void addAssignment(Assignment a) {
        assignmentList.add(a);
    }

    public static void scoreAssignment(Assignment a, Person p, int hours) {
        int tier = a.getTier();
        int intelligence = p.getIntelligence();
        double score = ((double) tier) / 5 * hours * hours + intelligence;
        a.setScore(score);
    }

    public static double calculateGPA() {
        if (assignmentList.size() == 0)
            return 100.0;
        double weight = 0.0;
        double total = 0.0;
        for (Assignment a : assignmentList) {
            weight += 1 / (double) a.getTier();
            total += (1 / (double) a.getTier()) * a.getScore();
        }
        return total / weight;
    }

    /* public String assignment(String class, int time, int intelligence) {
        int index = 0;
        for (int i = 0; i < classes.length; i++) {
        }
    } */
}
