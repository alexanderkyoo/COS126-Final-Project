public class FreshmanSim {

    public static void advanceDay() {
        // run assignment and event generators
        // ask user how many hours to spend on each assignment/event
        // calculate corresponding grade changes, attribute changes, etc.
    }

    public static void main(String[] args) {

        StdOut.println("Welcome to the Princeton Freshman Simulator!");
        StdOut.println("Please select your difficulty: ");
        StdOut.println("------------------------------");
        StdOut.println("(1) - Easy" + "\n" + "(2) - Medium" + "\n" + "(3) - Hard");
        int difficulty = StdIn.readInt();
        Person player;
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
                Course course = new Course("BSE");
                concentrationChecked = true;
            }
            else if (concentration == 2) {
                StdOut.println("You selected A.B.");
                Course course = new Course("AB");
                concentrationChecked = true;
            }
            else {
                StdOut.println("Please select an applicable concentration area.");
                concentration = StdIn.readInt();
            }
        }


    }
}
