// Represents an assignment given to the player through a course
// Allows for the generation of assignments and manipulation of assignment
// difficulty, type, and topic.
public class Assignment {
    private String assignmentType; // Represents the type of assignment
    private String assignmentTopic; // Represents the topic of the assignment
    private String assignmentMessage; // Represents the String form of the assignment
    private int tier; // Represents the tier of assignment, lower being harder
    private double score; // Represents the final score on the assignment

    public Assignment(String type, int assignmentTier, String topic, String message) {
        tier = assignmentTier;
        assignmentTopic = topic;
        assignmentType = type;
        assignmentMessage = message;
        score = 0.0;
    }

    // Retrieves the assignment's message
    public String getAssignmentMessage() {
        return assignmentMessage;
    }

    // Retrieves the topic of the assignment
    public String getAssignmentTopic() {
        return assignmentTopic;
    }

    // Retrieves the type of assignment
    public String getAssignmentType() {
        return assignmentType;
    }

    // Retrieves the tier of the assignment
    public int getTier() {
        return tier;
    }

    // Sets the score of the assignment to a given score
    public void setScore(double score) {
        this.score = score;
    }

    // Retrieves the score of the assignment
    public double getScore() {
        return score;
    }

    // Generates assignments from a list of topics and types
    // Returns a new assignment and gives it a tier
    public static Assignment generateAssignment(Course course) {
        String assignmentType = "";
        String assignmentTopic = "";
        int tier;
        String[] topicArrayAB = {
                "18th century sex appeal", "gargoyles", "the history of P = NP",
                "monarchs", "the emu war", "dinosaur ethics", "life as a clock",
                "the history of pepper jack cheese", "Pepperidge farms", "cranberry stomping",
                "the music theory of Weird Al"

        };
        String[] assignmentTypeAB = {
                "paper", "reading", "discussion", "close reading", "exam"
        };

        String[] topicArrayBSE = {
                "multivariable calculus", "titrations", "geometry of plates",
                "intermolecular bonding", "the reproductive system", "rat anatomy",
                "inheritance", "recursion", "Sierpinski's triangles", "boolean algebra",
                "arson"
        };
        String[] assignmentTypeBSE = {
                "problem set", "exam", "exam prep", "lab report", "quiz"
        };

        if (course.getName().equals("BSE")) {
            int assignmentTypeIndex = StdRandom.uniform(assignmentTypeBSE.length);
            assignmentType = assignmentTypeBSE[assignmentTypeIndex];
            int topicIndex = StdRandom.uniform(topicArrayBSE.length);
            assignmentTopic = topicArrayBSE[topicIndex];
        }
        else if (course.getName().equals("AB")) {
            int assignmentTypeIndex = StdRandom.uniform(assignmentTypeAB.length);
            assignmentType = assignmentTypeAB[assignmentTypeIndex];
            int topicIndex = StdRandom.uniform(topicArrayAB.length);
            assignmentTopic = topicArrayAB[topicIndex];
        }

        if (assignmentType.equals("exam") || assignmentType.equals("paper"))
            tier = 1;
        else if (assignmentType.equals("close reading") || assignmentType.equals("quiz")
                || assignmentType.equals("exam prep"))
            tier = 2;
        else
            tier = 3;
        String message = "You have been assigned a(n) " + assignmentType
                + " on " + assignmentTopic;
        return new Assignment(assignmentType, tier, assignmentTopic, message);
    }

    // Converts the assignment into String form through the assignmentMessage
    public String toString() {
        return assignmentMessage;
    }

    public static void main(String[] args) {
        Course ab = new Course("AB");
        Assignment superbAss = Assignment.generateAssignment(ab);
        StdOut.println(superbAss);
        superbAss.setScore(12.3);
        StdOut.println(superbAss.getScore());
        StdOut.println(superbAss.getTier());
        StdOut.println(superbAss.getAssignmentTopic());
        StdOut.println(superbAss.getAssignmentType());
        StdOut.println(superbAss.getAssignmentMessage());
    }
}
