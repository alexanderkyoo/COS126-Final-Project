// Represents an event that could happen to the player
// Allows for the generation of an event, within a set list
public class Event {
    private String eventMessage; // Represents the String form of the event
    private String descrip; // Represents a description of the event
    private double cost; // Represents the cost of the event
    private boolean voluntary; // Is the event voluntary
    private int involuntaryHours = 0; // Represents length of an involuntary event

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

    // Retrieves the description of the event
    public String getDescrip() {
        return descrip;
    }

    // Retrieves the cost of the event
    public double getCost() {
        return cost;
    }

    // Retrieves whether the event is voluntary
    public boolean isVoluntary() {
        return voluntary;
    }

    // Retrieves the event message
    public String getEventMessage() {
        return eventMessage;
    }

    // Retrieves the number of hours spent in the involuntary event
    public int getHours() {
        return involuntaryHours;
    }

    // Generates an event, based on charisma, and based on a preset list of events
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

    // Converts the event into a String format
    public String toString() {
        return eventMessage;
    }

    public static void main(String[] args) {
        Event ex1 = Event.generateEvent(100);
        StdOut.println(ex1.getDescrip());
        StdOut.println(ex1.getCost());
        StdOut.println(ex1);
        Event ex2 = Event.generateEvent(70);
        StdOut.println(ex2.isVoluntary());
        StdOut.println(ex2.getEventMessage());
        StdOut.println(ex2);
        Event ex3 = Event.generateEvent(10);
        StdOut.println(ex3.isVoluntary());
        StdOut.println(ex3.involuntaryHours);
        StdOut.println(ex3);
    }
}

