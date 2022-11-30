package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.ErrorMessage.*;

public class User {
    private static final int DIGITS_SIZE = 3;
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
        for (int row = 0; row < DIGITS_SIZE - 1; row++) {
            validateSameDigitByColumn(input, row);
        }
    }

    private void validateSameDigitByColumn(char[] input, int row) {
        for (int column = row + 1; column < DIGITS_SIZE; column++) {
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
        for (int index = 0; index < DIGITS_SIZE; index++) {
            digits.add(toInt(input[index]));
        }
    }

    private int toInt(char input) {
        return input - ZERO;
    }

    private void validateDigit(char[] digits) {
        for (int index = 0; index < DIGITS_SIZE; index++) {
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
        if (input.length != DIGITS_SIZE) {
            throw new IllegalArgumentException(USER_DIGIT_LENGTH);
        }
    }

}