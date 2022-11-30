package baseball;

import static baseball.NoticeMessage.*;

public class OutputView {

    public void outputStartMessage() {
        System.out.println(START);
    }

    public void outputInputDigit() {
        System.out.println(INPUT_DIGIT);
    }

    public void outputEndMessage() {
        System.out.println(END);
    }

    public void outputAdditionalGame() {
        System.out.println(ADDITIONAL_GAME);
    }
}
