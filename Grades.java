import java.util.ArrayList;

// Represents a collection of assignments and allows for operations to be
// performed on individual assignments and the collection as a whole
public class Grades {
    private static ArrayList<Assignment> assignmentList
            = new ArrayList<Assignment>(); // The array list of assignments

    // Adds an assignment to the assignment list
    public static void addAssignment(Assignment a) {
        assignmentList.add(a);
    }

    // Scores a given assignment, based on the person, and especially their
    // intelligence, and the number of hours put into work
    // Algorithm for grading is tier/5 * hours ^ 2 + intelligence
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

    // Returns the GPA, based on the total assignments done
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

    public static void main(String[] args) {
        Course bse = new Course("BSE");
        // testing of one assignment
        Assignment assn1 = Assignment.generateAssignment(bse);
        Financials bank = new Financials(100);
        Person p = new Person(50, 50, bank, 60);
        Grades.addAssignment(assn1);
        Grades.scoreAssignment(assn1, p, 5);
        StdOut.println("get score of assignment 1: " + assn1.getScore());
        StdOut.println("get tier of assignment 1: " + assn1.getTier());
        StdOut.println("GPA after 1 assignment added: " + Grades.calculateGPA());
        // testing of multiple assignments
        Assignment assn2 = Assignment.generateAssignment(bse);
        Grades.addAssignment(assn2);
        Grades.scoreAssignment(assn2, p, 5);
        StdOut.println("get score of assignment 2: " + assn2.getScore());
        StdOut.println("get tier of assignment 2: " + assn2.getTier());
        StdOut.println("GPA after 2 assginemnts added: " + Grades.calculateGPA());
    }
}
