import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {
    public String name;
    public Map<Subject, Float> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
        assignRandomGrades();
    }

    public void setGrade(Subject subject, float grade) {
        grades.put(subject, grade);
    }

    public float getGrade(Subject subject) {
        return grades.getOrDefault(subject, 0.0f);
    }

    public float calculateAverageGrade() {
        float total = 0;
        int count = 0;
        for (Float grade : grades.values()) {
            total += grade;
            count++;
        }
        return count == 0 ? 0 : total / count;
    }

    public String getName() {
        return name;
    }

    public void assignRandomGrades() {
        Random random = new Random();
        for (Subject subject : Subject.SUBJECTS.values()) {
            setGrade(subject, random.nextFloat() * 100);
        }
    }
}
