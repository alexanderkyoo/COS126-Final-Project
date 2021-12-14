public class Event {
    private static String eventMessage;
    private String descrip;
    private double cost;
    private boolean voluntary;

    public Event(String descrip, double cost, boolean voluntary, String message) {
        this.descrip = descrip;
        this.cost = cost;
        this.voluntary = voluntary;
        eventMessage = message;
    }

    public String getDescrip() {
        return descrip;
    }

    public double getCost() {
        return cost;
    }

    public boolean isVoluntary() {
        return voluntary;
    }

    public static Event generateEvent(int charisma) {
        String name, message;
        double price;
        boolean willing;
        if (charisma > 80) {
            String[] events = {
                    "presidential nomination", "secret party", "VIP get-together",
                    "ritualistic headbutting ceremony", "pickup game"
            };
            name = events[StdRandom.uniform(events.length)];
            price = StdRandom.uniform(0, 40) * 10;
            willing = true;
        }
        else if (charisma > 40) {
            String[] events = { "party", "eat out", "grill", "street fight", "hit job" };
            name = events[StdRandom.uniform(events.length)];
            price = StdRandom.uniform(0, 20) * 10;
            willing = true;
        }
        else {
            String[] events = { "mugging", "wedgie", "blackmail", "coercion", "extortion" };
            name = events[StdRandom.uniform(events.length)];
            price = StdRandom.uniform(35, 55) * 10;
            willing = false;
        }
        if (willing)
            message = "You have been invited to a " + name;
        else
            message = "You are involved in a(n) " + name;

        return new Event(name, price, willing, message);
    }

    public String toString() {
        return eventMessage;
    }
}
