package tutorials;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Level level;
    private String department;
    private List<Course> courses;
    private List<Lecturer> lecturers;

    public Student(String name, Level level, String department) {
        this.name = name;
        this.level = level;
        this.department = department;
        courses = new ArrayList<>();
        lecturers = new ArrayList<>();
    }


    public void addCourse(Course course) {}

    public List<Course> getCourses() {
        return null;
    }
}
