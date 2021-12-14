public class Event {
    private String eventMessage;
    private String descrip;
    private double cost;
    private boolean voluntary;
    private int involuntaryHours = 0;

    public Event(String descrip, double cost, boolean voluntary, String message, int hours) {
        this.descrip = descrip;
        this.cost = cost;
        this.voluntary = voluntary;
        eventMessage = message;
        if (!voluntary)
            involuntaryHours = hours;
    }

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

    public String getEventMessage() {
        return eventMessage;
    }

    public int getHours() {
        return involuntaryHours;
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
            price = StdRandom.uniform(0, 400);
            willing = true;
        }
        else if (charisma > 30) {
            String[] events = { "party", "eat out", "grill", "street fight", "hit job" };
            name = events[StdRandom.uniform(events.length)];
            price = StdRandom.uniform(0, 200);
            willing = true;
        }
        else {
            String[] events = { "mugging", "wedgie", "blackmail", "coercion", "extortion" };
            name = events[StdRandom.uniform(events.length)];
            price = StdRandom.uniform(400, 550);
            willing = false;
        }
        if (willing) {
            message = "You have been invited to a " + name;
            return new Event(name, price, true, message);
        }
        else {
            int hours = StdRandom.uniform(1, 6);
            message = "You are involved in a(n) " + name + ". This will take " + hours
                    + " hours.";
            return new Event(name, price, false, message, hours);
        }
    }

    public String toString() {
        return eventMessage;
    }
}
