public class Person {
    private int health;
    private int happiness;
    private Financials bank; // Represents person's bank account

    public Person(int health, int happiness, Financials bank) {
        this.health = health;
        this.happiness = happiness;
        this.bank = bank;
    }


    public String toString() {
        return "<<<<<<<<<<<<<<<<<<< Player Attributes >>>>>>>>>>>>>>>>>>>" + "\n"
                + "Health : " + health + "\n"
                + "Happiness: " + happiness + "\n"
                + "Bank balance: " + bank.getBalance() + "\n"
                + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    }

}
