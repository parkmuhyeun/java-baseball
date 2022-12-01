package baseball.model;

public enum Digit {
    RANGE_START(1),
    RANGE_END(9),
    DIGIT_SIZE(3);

    private final int value;

    Digit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
