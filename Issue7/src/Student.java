import java.util.HashMap;
import java.util.Map;

public class Student {
    public String name;
    public Map<Subject, Integer> grades;

    public Student(String name) {
        this.name = name;
        grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setGrade(Subject subject, int grade) {
        grades.put(subject, grade);
    }

    public int getGrade(Subject subject) {
        return grades.getOrDefault(subject, 0);
    }

    public Map<Subject, Integer> getGrades() {
        return grades;
    }
}
