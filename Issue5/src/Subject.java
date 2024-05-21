public enum Subject {
    MATH("数学"),
    JAPANESE("国語"),
    ENGLISH("英語"),
    SCIENCE("理科"),
    SOCIAL_STUDIES("社会");

    private final String displayName;

    Subject(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
