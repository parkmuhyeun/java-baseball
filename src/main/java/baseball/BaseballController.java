package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private static final int CONTINUE = 1;
    private static final int END = 2;
    private static final char NEW_LINE = '\n';
    private static final int SELECT_LENGTH = 1;

    private final OutputView outputView;
    private int system = CONTINUE;

    public BaseballController() {
        outputView = new OutputView();
    }

    public void run() {
        outputView.outputStartMessage();
        while (isContinue(system)) {
            Computer computer = new Computer();
            User user = new User();

            playGame(computer, user);
            outputView.outputEndMessage();
            printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + NEW_LINE);
            inputAdditionalGame();
        }
    }

    private void inputAdditionalGame() {
        String select = inputSelect();
        validateSelect(select);
        system = Integer.parseInt(select);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    private void validateSelect(String select) {
        if (isRightLength(select) && Character.isDigit(getCharacter(select)) && isRightSelect(select)) {
            return;
        }
        throw new IllegalArgumentException("1이나 2만 입력 가능합니다.");
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

    private String inputSelect() {
        return Console.readLine();
    }

    private void playGame(Computer computer, User user) {
        int game = CONTINUE;
        while (isContinue(game)) {
            printMessage("숫자를 입력해주세요 : ");
            Ball ball = computer.compareDigits(user.input());
            printMessage(ball.toString() + NEW_LINE);
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
