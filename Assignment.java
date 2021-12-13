public class Assignment {
    private String name;
    private int tier;
    private String topic;

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    public String getTopic() {
        return topic;
    }

    public Assignment(String name, int tier, String topic) {
        this.name = name;
        this.tier = tier;
        this.topic = topic;
    }

    public static void main(String[] args) {
        StdOut.println("Hi I'm useless");
    }
}
