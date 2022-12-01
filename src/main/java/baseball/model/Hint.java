package baseball.model;

import static baseball.model.HintStatus.*;

public class Hint {
    private static final int END = 3;

    private int strike;
    private int ball;

    public Hint() {
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public boolean isEnd() {
        return strike == END;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (isNothing()) {
            return NOTHING.getName();
        }
        appendBall(string);
        return string.toString();
    }

    private void appendBall(StringBuilder string) {
        if (hasBall(ball)){
            string.append(ball + BALL.getName() + " ");
        }
        if (hasBall(strike)) {
            string.append(strike + STRIKE.getName());
        }
    }

    private boolean hasBall(int ball) {
        return ball != 0;
    }

    private boolean isNothing() {
        return (strike + ball) == 0;
    }
}
