package enums;

public enum Role {
    USER(1),
    ADMIN(2);

    public final Integer priority;

    private Role(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}
