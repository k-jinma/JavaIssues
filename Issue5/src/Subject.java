import java.util.HashMap;
import java.util.Map;

public class Subject {
    public static final Map<String, Subject> SUBJECTS = new HashMap<>();
    public final String name;

    public Subject(String name) {
        this.name = name;
        SUBJECTS.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Subject getSubject(String name) {
        return SUBJECTS.get(name);
    }

    // 定義済みの科目
    public static final Subject MATH = new Subject("数学");
    public static final Subject JAPANESE = new Subject("国語");
    public static final Subject ENGLISH = new Subject("英語");
    public static final Subject SCIENCE = new Subject("理科");
    public static final Subject SOCIAL_STUDIES = new Subject("社会");

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Subject subject = (Subject) obj;
        return name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
