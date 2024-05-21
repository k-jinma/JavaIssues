import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();

        try (BufferedReader br = new BufferedReader(new FileReader("成績.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String studentName = data[0];
                Student student = new Student(studentName);

                for (int i = 1; i < data.length; i += 2) {
                    String subjectName = data[i];
                    int grade = Integer.parseInt(data[i + 1]);
                    Subject subject = Subject.fromName(subjectName);
                    student.addSubjectGrade(subject, grade);
                }
                gradeBook.addStudent(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("成績平均 : %.1f\n", gradeBook.getAverage());
        
        for (Subject subject : Subject.values()) {
            System.out.printf("%s成績平均 : %.1f\n", subject.getName(), gradeBook.getSubjectAverage(subject));
            Student topStudent = gradeBook.getTopStudentInSubject(subject);
            Student bottomStudent = gradeBook.getBottomStudentInSubject(subject);

            System.out.printf("%s最高成績 : %d\n", subject.getName(), topStudent.getSubjectGrade(subject));
            System.out.printf("%s最高成績得点者 : %s\n", subject.getName(), topStudent.getName());

            System.out.printf("%s最低成績 : %d\n", subject.getName(), bottomStudent.getSubjectGrade(subject));
            System.out.printf("%s最低成績得点者 : %s\n", subject.getName(), bottomStudent.getName());
        }
    }
}
