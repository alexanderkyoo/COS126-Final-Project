public class Assignment {
    private String assignmentType;
    private String assignmentTopic;
    private String assignmentMessage;
    private int tier;
    private double score;

    public Assignment(String type, int assignmentTier, String topic, String message) {
        tier = assignmentTier;
        assignmentTopic = topic;
        assignmentType = type;
        assignmentMessage = message;
        score = 0.0;
    }

    public String getAssignmentMessage() {
        return assignmentMessage;
    }

    public String getAssignmentTopic() {
        return assignmentTopic;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public int getTier() {
        return tier;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public static Assignment generateAssignment(Course course) {
        String assignmentType = "";
        String assignmentTopic = "";
        int tier = 0;
        String[] topicArrayAB = {
                "18th century sex appeal", "gargoyles", "the history of P = NP",
                "monarchs", "the emu war"
        };
        String[] assignmentTypeAB = {
                "paper", "reading", "discussion", "close reading", "exam"
        };

        String[] topicArrayBSE = {
                "multivariable calculus", "titrations", "geometry of plates",
                "intermolecular bonding", "the reproductive system", "rat anatomy",
                "inheritance", "recursion", "Sierpinski's triangles", "boolean algebra"
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
        String message = "You have been assigned a(n) " + assignmentType
                + " on " + assignmentTopic;
        return new Assignment(assignmentType, tier, assignmentTopic, message);
    }

    public String toString() {
        return assignmentMessage;
    }

}
