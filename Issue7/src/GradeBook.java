import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private List<Student> students;

    public GradeBook() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public float getAverage() {
        float totalSum = 0;
        int totalGrades = 0;

        for (Student student : students) {
            totalSum += student.getAverage() * student.getTotalSubjects();
            totalGrades += student.getTotalSubjects();
        }

        return totalGrades == 0 ? 0 : totalSum / totalGrades;
    }

    public float getSubjectAverage(Subject subject) {
        float totalSum = 0;
        int totalGrades = 0;

        for (Student student : students) {
            Integer grade = student.getSubjectGrade(subject);
            if (grade != null) {
                totalSum += grade;
                totalGrades++;
            }
        }

        return totalGrades == 0 ? 0 : totalSum / totalGrades;
    }

    public Student getTopStudentInSubject(Subject subject) {
        Student topStudent = null;
        int highestGrade = -1;

        for (Student student : students) {
            Integer grade = student.getSubjectGrade(subject);
            if (grade != null && grade > highestGrade) {
                highestGrade = grade;
                topStudent = student;
            }
        }

        return topStudent;
    }

    public Student getBottomStudentInSubject(Subject subject) {
        Student bottomStudent = null;
        int lowestGrade = 101;

        for (Student student : students) {
            Integer grade = student.getSubjectGrade(subject);
            if (grade != null && grade < lowestGrade) {
                lowestGrade = grade;
                bottomStudent = student;
            }
        }

        return bottomStudent;
    }
}
