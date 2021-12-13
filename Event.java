public class Event {
    private String descrip;
    private double cost;
    private boolean voluntary;

    public Event(String descrip, double cost, boolean voluntary) {
        this.descrip = descrip;
        this.cost = cost;
        this.voluntary = voluntary;
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
        Event nextEvent;
        String name;
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
            price = Double.MAX_VALUE;
            willing = false;
        }
        nextEvent = new Event(name, price, willing);
        return nextEvent;
    }

    public static void main(String[] args) {

    }
}
