package baseball;

import static baseball.ErrorMessage.INCORRECT_SELECT;

public class BaseballController {
    private static final int CONTINUE = 1;
    private static final int END = 2;
    private static final int SELECT_LENGTH = 1;

    private final OutputView outputView;
    private final InputView inputView;
    private int system = CONTINUE;

    public BaseballController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        outputView.outputStartMessage();
        while (isContinue(system)) {
            Computer computer = new Computer();
            User user = new User();

            playGame(computer, user);
            outputView.outputEndMessage();
            inputAdditionalGame();
        }
    }

    private void inputAdditionalGame() {
        String select = inputView.inputSelect();
        validateSelect(select);
        system = Integer.parseInt(select);
    }

    private void validateSelect(String select) {
        if (isRightLength(select) && Character.isDigit(getCharacter(select)) && isRightSelect(select)) {
            return;
        }
        throw new IllegalArgumentException(INCORRECT_SELECT);
    }

    private boolean isRightLength(String select) {
        return select.length() == SELECT_LENGTH;
    }

    private boolean isRightSelect(String select) {
        int digit = Integer.parseInt(select);
        return digit == CONTINUE || digit == END;
    }

    private char getCharacter(String select) {
        return select.charAt(0);
    }

    private void playGame(Computer computer, User user) {
        int game = CONTINUE;
        while (isContinue(game)) {
            String inputDigit = inputView.inputDigit();
            Ball ball = computer.compareDigits(user.input(inputDigit));
            outputView.outputResult(ball.toString());
            game = isEnd(ball);
        }
    }

    private boolean isContinue(int game) {
        return game == CONTINUE;
    }

    private int isEnd(Ball ball) {
        if (ball.isEnd())
            return END;
        return CONTINUE;
    }
}
