public class Main {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.loadGradesFromCSV("成績.csv");
        
        gradeBook.printOverallAverage();
        gradeBook.printSubjectStatistics(Subject.ENGLISH);
        gradeBook.printSubjectStatistics(Subject.MATH);
        gradeBook.printSubjectStatistics(Subject.JAPANESE);
        gradeBook.printSubjectStatistics(Subject.SCIENCE);
        gradeBook.printSubjectStatistics(Subject.HISTORY);
    }
}
