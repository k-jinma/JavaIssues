import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<Subject, Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addSubjectGrade(Subject subject, int grade) {
        grades.put(subject, grade);
    }

    public Integer getSubjectGrade(Subject subject) {
        return grades.get(subject);
    }

    public float getAverage() {
        float sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return grades.size() == 0 ? 0 : sum / grades.size();
    }

    public int getTotalSubjects() {
        return grades.size();
    }
}
