import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public List<Student> getStudents() {
        return students;
    }

    public void loadGradesFromCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Student student = new Student(values[0]);
                for (int i = 1; i < values.length; i += 2) {
                    Subject subject = Subject.getSubject(values[i]);
                    int grade = Integer.parseInt(values[i + 1]);
                    student.setGrade(subject, grade);
                }
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSubjectStatistics(Subject subject) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String maxScorer = "";
        String minScorer = "";
        
        for (Student student : students) {
            int grade = student.getGrade(subject);
            total += grade;
            if (grade > max) {
                max = grade;
                maxScorer = student.getName();
            }
            if (grade < min) {
                min = grade;
                minScorer = student.getName();
            }
        }
        
        double average = (double) total / students.size();
        System.out.println(subject.getName() + "成績平均 : " + average);
        System.out.println(subject.getName() + "最高成績 : " + max);
        System.out.println(subject.getName() + "最高成績得点者 : " + maxScorer);
        System.out.println(subject.getName() + "最低成績 : " + min);
        System.out.println(subject.getName() + "最低成績得点者 : " + minScorer);
    }

    public void printOverallAverage() {
        int total = 0;
        int count = 0;
        
        for (Student student : students) {
            for (int grade : student.getGrades().values()) {
                total += grade;
                count++;
            }
        }
        
        double average = (double) total / count;
        System.out.println("成績平均 : " + average);
    }
}
