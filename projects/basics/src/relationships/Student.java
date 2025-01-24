package relationships;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) { // Check for duplicates
            this.enrolledCourses.add(course);
            // mutate the course object passed as a parameter.
            // Notify the Course that this Student has enrolled
            course.register(this);
        } else {
            System.out.println("Already enrolled: " + course);
        }

    }

    public List<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student(" + name + ")";
    }
}
