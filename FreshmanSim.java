// Acts as a runner for the overall game
// The main engine of our MVP
public class FreshmanSim {
    private static int day = 1; // Counter for the days
    private static Person player; // The player
    private static Course course; // The course the player decides on
    private static Grades grades; // The grades of the player
    private static boolean alive = true; // The tracker for game running

    public static void advanceDay() {
        // run assignment and event generators
        // ask user how many hours to spend on each assignment/event
        // calculate corresponding grade changes, attribute changes, etc.
        StdOut.println("Day " + day + " begins!");
        int hours = 24;
        Event event = Event.generateEvent(player.getCharisma());
        if (!event.isVoluntary()) {
            StdOut.println(event.getEventMessage());
            int healthDecrease = StdRandom.uniform(-10, -5);
            int charismaDecrease = StdRandom.uniform(-10, -5);
            double moneyDecrease = event.getCost();
            player.incrementHealth(healthDecrease);
            player.incrementCharisma(charismaDecrease);
            player.getBank().withdraw(moneyDecrease);

            StdOut.println("Your health decreased by " + -healthDecrease
                                   + "\n" + "Your charisma decreased by " + -charismaDecrease
                                   + "\n" + "Your bank balance decreased by " + -moneyDecrease);
            StdOut.println("------------------------------");
            hours -= event.getHours();
        }
        else {
            StdOut.println(event.getEventMessage());
            StdOut.println("How long do you wish to spend at this event?");
            StdOut.println("------------------------------");
            StdOut.println("Enter an integer from 0 to " + hours + ":");
            int work = (int) StdIn.readDouble();
            boolean hoursChecked = false;
            while (!hoursChecked) {
                if (work > 0 && work <= hours) {
                    hours -= work;
                    int charisma = StdRandom.uniform(1, 5);
                    player.incrementCharisma(charisma);
                    StdOut.println("Your charisma increased by " + charisma);
                    double moneyDecrease = event.getCost();
                    player.getBank().withdraw(moneyDecrease);
                    StdOut.println("You spent $" + moneyDecrease + " at this event.");
                    hoursChecked = true;
                }
                else if (work == 0) {
                    int charisma = StdRandom.uniform(-5, -1);
                    player.incrementCharisma(charisma);
                    StdOut.println(
                            "You skipped the event! Your charisma decreased by " + -charisma);
                    StdOut.println("------------------------------");
                    hoursChecked = true;
                }
                else {
                    StdOut.print("There is not enough time in the day for that."
                                         + "\n" + "Enter the number of hours: ");
                    work = StdIn.readInt();
                }
            }

        }
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
            StdOut.println("Enter an integer from 0 to " + hours + ":");
            int work = (int) StdIn.readDouble();
            boolean hoursChecked = false;
            while (!hoursChecked) {
                if (work >= 0 && work <= hours) {
                    hours -= work;
                    Grades.addAssignment(assignments[i]);
                    Grades.scoreAssignment(assignments[i], player, work);
                    StdOut.println(
                            "You scored a " + assignments[i].getScore() + " on the " +
                                    assignments[i].getAssignmentType() + ". \n");
                    hoursChecked = true;
                }
                else {
                    StdOut.print("There is not enough time in the day for that."
                                         + "\n" + "Enter the number of hours: ");
                    work = StdIn.readInt();
                }

            }
        }

        StdOut.println("<<<<<<<<<<<<<<<<<<<<<<< End of Day >>>>>>>>>>>>>>>>>>>>>>");
        StdOut.println("You slept " + hours + " hours.");
        player.incrementHealth(hours - 8);
        player.incrementHappiness(hours - 8);
        if (player.getHealth() > 100) player.incrementHealth(100 - player.getHealth());
        if (player.getHealth() <= 0) {
            alive = false;
            StdOut.println("You died! Should've gotten some sleep!");
        }
        if (player.getCharisma() < 20) {
            StdOut.println("Nobody seems to like you here! I'd suggest transferring to Harvard...");
            alive = false;
        }
        StdOut.println("Your GPA is now " + Grades.calculateGPA() + ".");
        if (Grades.calculateGPA() > 70) {
            player.incrementintelligence(1);
            player.incrementHappiness((int) (Grades.calculateGPA() - 70) / 10);
        }
        else if (Grades.calculateGPA() < 60) player.incrementintelligence(-1);

        if (Grades.calculateGPA() < 50) {
            alive = false;
            StdOut.println("Failures don't belong in Princeton! Get out!");
        }
        else if (Grades.calculateGPA() < 70) {
            player.incrementHappiness(-day / 2);
        }
        else {
            player.incrementHappiness(-day / 3);
        }

        if (player.getHappiness() < 0) {
            StdOut.println("You have no motivation! You dropped out!");
            alive = false;
        }

        if (player.getBank().getBalance() < 0) {
            StdOut.println("You're broke! Even Princeton doesn't have "
                                   + "enough financial aid to save you!");
            alive = false;
        }
        StdOut.println(player);
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
                player = new Person(100, 100, bank, 85);
                StdOut.println(player);
            }
            else if (difficulty == 2) {
                StdOut.println("Medium Mode...");
                levelChecked = true;
                balance = 2500;
                bank = new Financials(balance);
                player = new Person(80, 80, bank, 70);
                StdOut.println(player);
            }
            else if (difficulty == 3) {
                StdOut.println("Hard Mode...");
                levelChecked = true;
                balance = 100;
                bank = new Financials(balance);
                player = new Person(50, 50, bank, 60);
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
        while (alive) {
            FreshmanSim.advanceDay();
        }

        StdOut.println("Game Over! You survived " + (day - 1) + " days at Princeton.");

    }
}
