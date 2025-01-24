package relationships;

import java.util.ArrayList;
import java.util.List;

// Two-Way Relationship: This creates a two-way relationship between the Student and Course classes.
// A Student knows about the Courses they are enrolled in.
// A Course knows about the Students enrolled in it.
public class Course {
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public void register(Student student) {
        if (!enrolledStudents.contains(student)) { // Check for duplicates
            enrolledStudents.add(student);

            // Notify the Student that this Student has enrolled
            student.enrollInCourse(this);
        } else {
            System.out.println("Already enrolled: " + student);
        }

    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course(" + name + ")";
    }
}
