public enum Subject {
    ENGLISH("英語"),
    MATH("算数"),
    JAPANESE("国語"),
    SCIENCE("理科"),
    SOCIAL_STUDIES("社会");

    private String name;

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Subject fromName(String name) {
        for (Subject subject : values()) {
            if (subject.name.equals(name)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Invalid subject name: " + name);
    }
}
