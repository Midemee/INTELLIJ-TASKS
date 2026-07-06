package tutorials;

import java.util.ArrayList;
import java.util.List;

public class Lecturer {
    private String name;
    private List<Course> courses;
    private String department;
    private List<Student> students;

    public Lecturer(String name, String department) {
        this.name = name;
        this.department = department;
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }
}
