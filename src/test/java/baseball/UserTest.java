package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("사용자 입력 - 성공")
    void 입력_성공() {
        String input = "345";
        initData(input);
        User user = new User();
        List<Integer> digits = user.input(input);

        assertEquals(3, digits.size());
        assertNotSame(digits.get(0), digits.get(1));
        assertNotSame(digits.get(1), digits.get(2));
    }

    private void initData(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("사용자 입력 - 실패")
    void 입력_개수_실패() {
        String input = "34621";
        initData(input);
        User user = new User();

        assertThatThrownBy(() -> user.input(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리를 입력해 주세요.");
    }

    @Test
    @DisplayName("사용자 입력 - 실패")
    void 숫자외_다른값_입력_실패() {
        String input = "wea";
        initData(input);
        User user = new User();

        assertThatThrownBy(() -> user.input(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("사용자 입력 - 실패")
    void 같은_숫자_입력_실패() {
        String input = "221";
        initData(input);
        User user = new User();

        assertThatThrownBy(() -> user.input(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("동일한 수를 입력할 수 없습니다.");
    }
}