package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    Ball comBall;

    @BeforeEach
    void setUp() {
        comBall = new Ball(3, 1);
    }

    @DisplayName("BallNumber_볼 범위가 1-9 아닐 때 예외 테스트")
    @Test
    void ball_range() {
        //given
        assertThatThrownBy(() -> new BallNumber(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1-9 사이 숫자를 입력하세요.");
    }

    @DisplayName("check_한 쌍의 볼끼리만 비교 테스트 - 값만 같으면 BALL")
    @Test
    void ball() {
        //given
        Ball user = new Ball(2, 1);

        //when
        BallStatus ballType = comBall.check(user);

        //then
        assertThat(ballType).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("한 쌍의 볼끼리만 비교 테스트 - 값과 인덱스 모두 같으면 STRIKE")
    @Test
    void strike() {
        //given
        Ball user = new Ball(3, 1);

        //when
        BallStatus ballType = comBall.check(user);

        //then
        assertThat(ballType).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("한 쌍의 볼끼리만 비교 테스트 - 값과 인덱스 모두 다르면 NOTHING")
    @Test
    void nothing() {
        //given
        Ball user = new Ball(1, 3);

        //when
        BallStatus ballType = comBall.check(user);

        //then
        assertThat(ballType).isEqualTo(BallStatus.NOTHING);
    }
}
