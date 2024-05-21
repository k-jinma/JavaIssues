import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        Random random = new Random();

        // 生徒の作成
        String[] studentNames = {"Tom", "John", "Mary"};
        for (String name : studentNames) {
            Student student = new Student(name);
            for (Subject subject : Subject.values()) {
                student.addSubject(subject);
                int grade = random.nextInt(101); // 0から100までのランダムな点数を生成
                student.addSubjectGrade(subject, grade);
            }
            gradeBook.addStudent(student);
        }

        // 平均点の出力
        System.out.printf("生徒平均点: %.4f\n", gradeBook.getAverage());
        System.out.printf("生徒数学平均点: %.4f\n", gradeBook.getSubjectAverage(Subject.MATH));

        // 最高点数者の出力
        Student topStudent = gradeBook.getTopStudentInSubject(Subject.MATH);
        System.out.println("数学の最高点数生徒: " + (topStudent != null ? topStudent.getName() : "なし"));

        // 最低点数者の出力
        Student bottomStudent = gradeBook.getBottomStudentInSubject(Subject.MATH);
        System.out.println("数学の最低点数生徒: " + (bottomStudent != null ? bottomStudent.getName() : "なし"));
    }
}
