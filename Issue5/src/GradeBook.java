import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private List<Student> students;

    public GradeBook() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double getAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getAverage();
        }
        return sum / students.size();
    }

    public double getSubjectAverage(Subject subject) {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            int grade = student.getSubjectGrade(subject);
            if (grade > 0) {
                sum += grade;
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    public Student getTopStudentInSubject(Subject subject) {
        Student topStudent = null;
        int maxGrade = Integer.MIN_VALUE;
        for (Student student : students) {
            int grade = student.getSubjectGrade(subject);
            if (grade > maxGrade) {
                maxGrade = grade;
                topStudent = student;
            }
        }
        return topStudent;
    }

    public Student getBottomStudentInSubject(Subject subject) {
        Student bottomStudent = null;
        int minGrade = Integer.MAX_VALUE;
        for (Student student : students) {
            int grade = student.getSubjectGrade(subject);
            if (grade < minGrade) {
                minGrade = grade;
                bottomStudent = student;
            }
        }
        return bottomStudent;
    }
}
