import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    public List<Student> students;

    public GradeBook() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public float calculateAverageGrade() {
        float total = 0;
        int count = 0;
        for (Student student : students) {
            total += student.calculateAverageGrade();
            count++;
        }
        return count == 0 ? 0 : total / count;
    }

    public float calculateSubjectAverageGrade(Subject subject) {
        float total = 0;
        int count = 0;
        for (Student student : students) {
            total += student.getGrade(subject);
            count++;
        }
        return count == 0 ? 0 : total / count;
    }

    public Student getHighestScoringStudent() {
        if (students.isEmpty()) return null;
        Student highest = students.get(0);
        for (Student student : students) {
            if (student.calculateAverageGrade() > highest.calculateAverageGrade()) {
                highest = student;
            }
        }
        return highest;
    }

    public Student getLowestScoringStudent() {
        if (students.isEmpty()) return null;
        Student lowest = students.get(0);
        for (Student student : students) {
            if (student.calculateAverageGrade() < lowest.calculateAverageGrade()) {
                lowest = student;
            }
        }
        return lowest;
    }
}
