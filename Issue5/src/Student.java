import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<Subject, Integer> subjectGrades;

    public Student(String name) {
        this.name = name;
        this.subjectGrades = new HashMap<>();
    }

    public void addSubject(Subject subject) {
        subjectGrades.put(subject, 0); // 初期点数は0として追加
    }

    public void addSubjectGrade(Subject subject, int grade) {
        if (subjectGrades.containsKey(subject)) {
            subjectGrades.put(subject, grade);
        } else {
            System.out.println("Error: 科目が見つかりませんでした。");
        }
    }

    public String getName() {
        return name;
    }

    public int getSubjectGrade(Subject subject) {
        return subjectGrades.getOrDefault(subject, 0);
    }

    public double getAverage() {
        double sum = 0;
        for (int grade : subjectGrades.values()) {
            sum += grade;
        }
        return sum / subjectGrades.size();
    }
}
