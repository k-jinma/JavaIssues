public class Main {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();

        Student john = new Student("john");
        Student jane = new Student("jane");
        Student tom = new Student("tom");

        gradeBook.addStudent(john);
        gradeBook.addStudent(jane);
        gradeBook.addStudent(tom);

        System.out.printf("生徒平均点 : %.4f%n", gradeBook.calculateAverageGrade());
        System.out.printf("生徒数学平均点: %.6f%n", gradeBook.calculateSubjectAverageGrade(Subject.MATH));
        System.out.println("最高点数生徒: " + gradeBook.getHighestScoringStudent().getName());
        System.out.println("最低点数生徒: " + gradeBook.getLowestScoringStudent().getName());
    }
}
