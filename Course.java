// Represents a Course that has a name
public class Course {
    private String cName; // Represents the name of the course

    public Course(String name) {
        cName = name;
    }

    // Retrieves the course name and also functions as the toString method
    public String toString() {
        return cName;
    }


    public static void main(String[] args) {
        Course bezosBuks = new Course("Bezos Bucks");
        StdOut.println(bezosBuks);
    }
}
