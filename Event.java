public class Event {
    private String descrip;
    private double cost;
    private boolean voluntary;

    public Event(String descrip, double cost, boolean voluntary) {
        this.descrip = descrip;
        this.cost = cost;
        this.voluntary = voluntary;
    }

    public static String generateEvent(int charisma) {
        if (charisma > 80) {
            String[] events = {
                    "presidential nomination", "secret party", "VIP get-together",
                    "ritualistic headbutting ceremony", "pickup game"
            };
        }
        else if (charisma > 40) {
            String[] events = { "party", "eat out", "grill", "street fight", "hit job" };
        }
        else {
            String[] events = { "mugging", "wedgie", "blackmail", "coercion", "extortion" };
        }
        return "You participated in a(n) " + events[StdRandom.uniform(events.length)];
    }

    public static void main(String[] args) {

    }
}
