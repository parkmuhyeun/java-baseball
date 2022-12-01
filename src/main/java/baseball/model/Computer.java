package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.model.Digit.*;

public class Computer {
    private List<Integer> digits = new ArrayList<>();

    public Computer() {
        generateRandomNumber();
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public Ball compareDigits(List<Integer> inputDigits) {
        Ball ball = new Ball();

        for (int row = 0; row < DIGIT_SIZE.getValue(); row++) {
            compareDigitsByColumn(inputDigits, ball, row);
        }
        return ball;
    }

    private void compareDigitsByColumn(List<Integer> inputDigits, Ball ball, int row) {
        for (int column = 0; column < DIGIT_SIZE.getValue(); column++) {
            if (isStrike(inputDigits, row, column)) {
                ball.addStrike();
                return;
            }

            if (isSameDigit(inputDigits.get(row), digits.get(column))) {
                ball.addBall();
                return;
            }
        }
    }

    private boolean isStrike(List<Integer> inputDigits, int row, int column) {
        return isSameDigit(inputDigits.get(row), digits.get(column)) && isSameIndex(row, column);
    }

    private boolean isSameIndex(int row, int column) {
        return row == column;
    }

    private boolean isSameDigit(Integer inputDigit, Integer digit) {
        return inputDigit == digit;
    }

    private void generateRandomNumber() {
        while (isValidRange()) {
            addNumber(Randoms.pickNumberInRange(RANGE_START.getValue(), RANGE_END.getValue()));
        }
    }

    private boolean isValidRange() {
        return digits.size() != DIGIT_SIZE.getValue();
    }

    private void addNumber(int pickNumber) {
        if (isUnique(pickNumber)) {
            digits.add(pickNumber);
        }
    }

    private boolean isUnique(int pickNumber) {
        return !digits.contains(pickNumber);
    }
}
