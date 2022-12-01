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
    
    public Hint compareInputDigits(List<Integer> inputDigits) {
        Hint hint = new Hint();
        
        for (int inputIndex = 0; inputIndex < DIGIT_SIZE.getValue(); inputIndex++) {
            compareDigits(inputDigits, hint, inputIndex);
        }
        return hint;
    }

    private void compareDigits(List<Integer> inputDigits, Hint hint, int row) {
        for (int digitIndex = 0; digitIndex < DIGIT_SIZE.getValue(); digitIndex++) {
            if (isStrike(inputDigits, row, digitIndex)) {
                hint.addStrike();
                return;
            }

            if (isSameDigit(inputDigits.get(row), digits.get(digitIndex))) {
                hint.addBall();
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
