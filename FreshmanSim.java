public class FreshmanSim {
    private static int day = 0;
    private static Person player;
    private static Course course;
    private static Grades grades;

    public static void advanceDay() {
        // run assignment and event generators
        // ask user how many hours to spend on each assignment/event
        // calculate corresponding grade changes, attribute changes, etc.
        StdOut.println("Day " + day + " begins!");
        int hours = 24;
        Assignment todays = Assignment.generateAssignment(course);
        StdOut.println("How long do you wish to spend on this " + todays.getAssignmentType() + "?");
        StdOut.println("------------------------------");
        StdOut.println("Enter a number from 0 to " + hours + ":");
        int work = StdIn.readInt();
        boolean hoursChecked = false;
        while (!hoursChecked) {
            if (work >= 0 || work <= hours) {
                hours -= work;
                grades.addAssignment(todays);
                grades.scoreAssignment(todays, player);
                StdOut.println(
                        "You scored a " + todays.getScore() + todays.getAssignmentType() + ".");
            }
        }

    }

    public static void main(String[] args) {

        StdOut.println("Welcome to the Princeton Freshman Simulator!");
        StdOut.println("Please select your difficulty: ");
        StdOut.println("------------------------------");
        StdOut.println("(1) - Easy" + "\n" + "(2) - Medium" + "\n" + "(3) - Hard");
        int difficulty = StdIn.readInt();
        double balance = 0.0;
        Financials bank;
        boolean levelChecked = false;

        while (!levelChecked) {
            if (difficulty == 1) {
                StdOut.println("Easy Mode...");
                levelChecked = true;
                balance = 5000;
                bank = new Financials(balance);
                player = new Person(100, 100, bank, 100);
                StdOut.println(player);
            }
            else if (difficulty == 2) {
                StdOut.println("Medium Mode...");
                levelChecked = true;
                balance = 2500;
                bank = new Financials(balance);
                player = new Person(80, 80, bank, 80);
                StdOut.println(player);
            }
            else if (difficulty == 3) {
                StdOut.println("Hard Mode...");
                levelChecked = true;
                balance = 100;
                bank = new Financials(balance);
                player = new Person(50, 50, bank, 50);
                StdOut.println(player);
            }
            else {
                StdOut.println("Please select an applicable difficulty level.");
                difficulty = StdIn.readInt();
            }
        }

        StdOut.println("Select your general concentration area:");
        StdOut.println("(1) - B.S.E." + "\n" + "(2) - A.B." + "\n");
        int concentration = StdIn.readInt();
        boolean concentrationChecked = false;

        while (!concentrationChecked) {
            if (concentration == 1) {
                StdOut.println("You selected B.S.E.");
                course = new Course("BSE");
                concentrationChecked = true;
            }
            else if (concentration == 2) {
                StdOut.println("You selected A.B.");
                course = new Course("AB");
                concentrationChecked = true;
            }
            else {
                StdOut.println("Please select an applicable concentration area.");
                concentration = StdIn.readInt();
            }
        }


    }
}
