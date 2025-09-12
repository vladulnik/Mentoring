package problemSolvingClasses.workWithEnum;

public enum Grade {
    A(5),
    B(4),
    C(3),
    D(2),
    F(1);

    private final int score;

    Grade(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public boolean isTheScorePassing(Grade other) {
        return other.score >= this.score;
    }

    public static double calculateAverage(Grade[] points) {
        double sum = 0;
        for(int i = 0; i < points.length; i++) {
            sum += points[i].getScore();
        }
        return sum/points.length;
    }
}
