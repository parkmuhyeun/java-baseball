package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.NoticeMessage.*;

public class InputView {

    public String inputDigit() {
        System.out.println(INPUT_DIGIT);
        return Console.readLine();
    }

    public String inputSelect() {
        System.out.println(ADDITIONAL_GAME);
        return Console.readLine();
    }
}
