// Represents the main person in the Freshman Simulator
// Allows for alteration of basic stats
public class Person {
    private int health; // Numerically represents player's overall health
    private int happiness; // Numerically represents player's overall happiness
    private Financials bank; // Represents person's bank account
    private int intelligence; // Numerically represents person's intelligence

    public Person(int health, int happiness, Financials bank, int intelligence) {
        this.health = health;
        this.happiness = happiness;
        this.bank = bank;
        this.intelligence = intelligence;
    }

    // Increments player's happiness by a, which can be negative or positive
    public void incrementHappiness(int a) {
        happiness += a;
    }

    // Increments player's health by a, which can be negative or positive
    // We thought it should be harder to gain health than lose health
    // So we added the factor of 2 for negative incrementation
    public void incrementHealth(int a) {
        if (a < 0) {
            health += 2 * a;
        }
        else {
            health += a;
        }
    }

    // Increments player's intelligence by a, which can be negative or positive
    public void incrementintelligence(int a) {
        intelligence += a;
    }

    // Retrieves player's health
    public int getHealth() {
        return health;
    }

    // Retrieves player's happiness
    public int getHappiness() {
        return happiness;
    }

    // Retrieves player's intelligence
    public int getIntelligence() {
        return intelligence;
    }

    // Converts the person into String format by displaying attributes
    public String toString() {
        return "<<<<<<<<<<<<<<<<<<< Player Attributes >>>>>>>>>>>>>>>>>>>" + "\n"
                + "Health : " + health + "\n"
                + "Happiness: " + happiness + "\n"
                + "Bank balance: " + bank.getBalance() + "\n"
                + "Intelligence: " + intelligence + "\n"
                + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    }

    public static void main(String[] args) {
        Financials money = new Financials(1986);
        Person bezos = new Person(1, 2, money, 3);
        StdOut.println(bezos);
        bezos.incrementHealth(5);
        bezos.incrementHappiness(6);
        bezos.incrementintelligence(2);
        StdOut.println(bezos.getHealth());
        StdOut.println(bezos.getHappiness());
        StdOut.println(bezos.getIntelligence());

    }
}
