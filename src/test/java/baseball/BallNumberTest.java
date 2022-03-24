package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNumberTest {

    @DisplayName("BallNumber_볼 범위가 1-9 아닐 때 예외 테스트")
    @Test
    void ball_range() {
        //given
        assertThatThrownBy(() -> new BallNumber(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1-9 사이 숫자를 입력하세요.");
    }
}
