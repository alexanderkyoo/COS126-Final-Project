import java.util.ArrayList;

public class Grades {
    private static ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();

    public static void addAssignment(Assignment a) {
        assignmentList.add(a);
    }

    public static void scoreAssignment(Assignment a, Person p, int hours) {
        double score;
        if (hours == 0) {
            score = 0;
        }
        else {
            int tier = a.getTier();
            int intelligence = p.getIntelligence();
            score = intelligence + ((double) tier / 5) * Math.pow(hours, 2);
            if (score > 100)
                score = 100;
        }
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
        if (total / weight > 100)
            return 100;
        else
            return (double) ((int) (100 * (total / weight))) / 100;
    }

    /* public String assignment(String class, int time, int intelligence) {
        int index = 0;
        for (int i = 0; i < classes.length; i++) {
        }
    } */
}
