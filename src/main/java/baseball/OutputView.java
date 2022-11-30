package baseball;

import static baseball.NoticeMessage.END;
import static baseball.NoticeMessage.START;

public class OutputView {

    public void outputStartMessage() {
        System.out.println(START);
    }

    public void outputEndMessage() {
        System.out.println(END);
    }
}
