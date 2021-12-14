public class Person {
    private int health;
    private int happiness;
    private Financials bank; // Represents person's bank account
    private int intelligence;

    public Person(int health, int happiness, Financials bank, int intelligence) {
        this.health = health;
        this.happiness = happiness;
        this.bank = bank;
        this.intelligence = intelligence;
    }

    public void incrementHappiness(int a) {
        happiness += a;
    }

    public void incrementHealth(int a) {
        if (a < 0) {
            health += 2 * a;
        }
        else {
            health += a;
        }
    }

    public void incrementintelligence(int a) {
        intelligence += a;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public String toString() {
        return "<<<<<<<<<<<<<<<<<<< Player Attributes >>>>>>>>>>>>>>>>>>>" + "\n"
                + "Health : " + health + "\n"
                + "Happiness: " + happiness + "\n"
                + "Bank balance: " + bank.getBalance() + "\n"
                + "Intelligence: " + intelligence + "\n"
                + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    }

}
