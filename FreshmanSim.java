public class FreshmanSim {
    private static int day = 1;
    private static Person player;
    private static Course course;
    private static Grades grades;

        public static void advanceDay() {
        // run assignment and event generators
        // ask user how many hours to spend on each assignment/event
        // calculate corresponding grade changes, attribute changes, etc.
        StdOut.println("Day " + day + " begins!");
        int hours = 24;
        Assignment[] assignments = new Assignment[4];
        for (int i = 0; i < 4; i++) {
            assignments[i] = Assignment.generateAssignment(course);
            StdOut.println(assignments[i]);
        }

        StdOut.println("------------------------------");
        
        for (int i = 0; i < 4; i++) {
            StdOut.println(
                    "How long do you wish to spend on this " + assignments[i].getAssignmentType()
                            + " about " + assignments[i].getAssignmentTopic() + "?");
            StdOut.println("------------------------------");
            StdOut.println("Enter an *integer* from 0 to " + hours + ":");
            int work = (int) StdIn.readDouble();
            boolean hoursChecked = false;
            while (!hoursChecked) {
                if (work >= 0 && work <= hours) {
                    hours -= work;
                    Grades.addAssignment(assignments[i]);
                    Grades.scoreAssignment(assignments[i], player);
                    StdOut.println(
                            "You scored a " + assignments[i].getScore() + " on the " +
                                    assignments[i].getAssignmentType() + ".");
                    hoursChecked = true;
                }
                else {
                    StdOut.println("There is not enough time in the day for that."
                                           + "\n" + "Enter the number of hours: ");
                    work = StdIn.readInt();
                }

            }
        }
        StdOut.println("You slept " + hours + " hours.");
        player.incrementHealth(hours - 8);
        StdOut.println("Your health is now " + player.getHealth() + ".");
        if (player.getHealth() <= 0) {
            alive = false;
            StdOut.println("You died! Should've gotten some sleep!");
        }
        day++;

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
                FreshmanSim.advanceDay();
            }
            else if (concentration == 2) {
                StdOut.println("You selected A.B.");
                course = new Course("AB");
                concentrationChecked = true;
                FreshmanSim.advanceDay();
            }
            else {
                StdOut.println("Please select an applicable concentration area.");
                concentration = StdIn.readInt();
            }
        }


    }
}
