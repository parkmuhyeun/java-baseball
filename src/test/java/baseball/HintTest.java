package baseball;

import baseball.model.Hint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {

    @Test
    @DisplayName("스트라이크 추가")
    void addStrike() {
        int result = 1;
        Hint hint = new Hint();

        hint.addStrike();
        assertEquals(result, hint.getStrike());
    }

    @Test
    @DisplayName("볼 추가")
    void addBall() {
        int result = 1;
        Hint hint = new Hint();

        hint.addBall();
        assertEquals(result, hint.getBall());
    }

    @Test
    @DisplayName("게임 끝났는지")
    void isEnd() {
        Hint hint = new Hint();
        addStrike(hint, 3);

        assertTrue(hint.isEnd());
    }

    private void addStrike(Hint hint, int count) {
        for (int now = 0; now < count; now++) {
            hint.addStrike();
        }
    }

    @Test
    @DisplayName("결과 출력")
    void testToString() {
        String result = "1볼 2스트라이크";
        Hint hint = new Hint();
        addStrike(hint, 2);
        hint.addBall();

        assertEquals(result, hint.toString());
    }
}