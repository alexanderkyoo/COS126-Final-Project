public class Grades {
    private Course[] courses;

    public Grades(Course[] courses) {
        this.courses = courses;
    }

    public int getClassIndex(String course) {
        for (int i = 0; i < courses.length; i++) {
            if (course.equals(courses[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public double getClassGrade(String course) {
        int index = getClassIndex(course);
        return courses[index].getAvg();
    }

    public double getGPA() {
        double avg = 0;
        for (int i = 0; i < courses.length; i++) {
            avg += courses[i].getAvg();
        }
        avg = avg / courses.length;
        return 4 * avg / 100;
    }

    public static void main(String[] args) {
    }


}
