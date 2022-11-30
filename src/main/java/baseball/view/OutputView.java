package baseball.view;

import static baseball.message.NoticeMessage.*;

public class OutputView {

    public void outputStartMessage() {
        System.out.println(START);
    }

    public void outputResult(String result) {
        System.out.println(result);
    }

    public void outputEndMessage() {
        System.out.println(END);
    }

}
