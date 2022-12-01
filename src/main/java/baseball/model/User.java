package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.message.ErrorMessage.*;
import static baseball.model.Digit.DIGIT_SIZE;

public class User {
    private static final char ZERO = '0';

    public User() {
    }

    public List<Integer> input(String input) {
        char[] inputDigit = input.toCharArray();
        List<Integer> digits = new ArrayList<>();

        validateLength(inputDigit);
        validateDigit(inputDigit);
        validateSameDigit(inputDigit);
        convertToInt(inputDigit, digits);
        return digits;
    }

    private void validateSameDigit(char[] input) {
        for (int row = 0; row < DIGIT_SIZE.getValue() - 1; row++) {
            validateSameDigitByColumn(input, row);
        }
    }

    private void validateSameDigitByColumn(char[] input, int row) {
        for (int column = row + 1; column < DIGIT_SIZE.getValue(); column++) {
            checkSameDigit(input, row, column);
        }
    }

    private void checkSameDigit(char[] input, int row, int column) {
        if (isSameDigit(input[row], input[column])) {
            throw new IllegalArgumentException(USER_SAME_DIGIT);
        }
    }

    private boolean isSameDigit(char rowCharacter, char columnCharacter) {
        return rowCharacter == columnCharacter;
    }

    private void convertToInt(char[] input, List<Integer> digits) {
        for (int index = 0; index < DIGIT_SIZE.getValue(); index++) {
            digits.add(toInt(input[index]));
        }
    }

    private int toInt(char input) {
        return input - ZERO;
    }

    private void validateDigit(char[] digits) {
        for (int index = 0; index < DIGIT_SIZE.getValue(); index++) {
            checkDigit(digits, index);
        }
    }

    private void checkDigit(char[] digits, int index) {
        if (isWrong(digits[index])) {
            throw new IllegalArgumentException(USER_DIGIT_CHECK);
        }
    }

    private boolean isWrong(char digit) {
        return !Character.isDigit(digit) || digit == ZERO;
    }

    private void validateLength(char[] input) {
        if (input.length != DIGIT_SIZE.getValue()) {
            throw new IllegalArgumentException(USER_DIGIT_LENGTH);
        }
    }

}