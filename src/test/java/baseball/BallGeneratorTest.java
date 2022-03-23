package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class BallGeneratorTest {

    BallGenerator ballGenerator = new BallGenerator();

    @DisplayName("생성된 볼이 1-9 인지 반복 테스트")
    @Test
    void genrateBalls_range() {
        //when
        Balls comBalls = ballGenerator.generateBalls();

        //then
        assertThat(comBalls.getBalls().stream().map(Ball::getBallNum)
                .allMatch(num -> 1 <= num && num <= 9)).isTrue();
    }

    @DisplayName("생성된 볼이 중복이 없는지 테스트")
    @Test
    void genrateBalls_duplicate() {
        //given
        Balls comBalls = ballGenerator.generateBalls();

        //when, then
        assertThat(comBalls.getBalls().stream().map(Ball::getBallNum)
                .distinct().count()).isEqualTo(3);
    }
    @DisplayName("생성된 볼이 길이 테스트")
    @Test
    void genrateBalls_length() {
        //given
        Balls comBalls = ballGenerator.generateBalls();

        //when, then
        assertThat(comBalls.getBalls().size()).isEqualTo(3);
    }
}
