package workWithEnum;

public enum TaskPriority {
    HIGH(1, 2),
    MEDIUM(2, 5),
    LOW(3, 10);

    private final int level;
    private final int executionTime;

    TaskPriority(int level, int executionTime) {
        this.level = level;
        this.executionTime = executionTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public boolean isHigherThan(TaskPriority other) {
        return this.level < other.level;
    }

    public boolean isLowerThan(TaskPriority other) {
        return this.level > other.level;
    }
}
