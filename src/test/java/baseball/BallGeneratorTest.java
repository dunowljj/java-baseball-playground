package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BallGeneratorTest {

    BallGenerator ballGenerator;

    @DisplayName("생성된 볼이 1-9에 속하는 지 반복 테스트")
    @Test
    void genrateBalls1() {
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        //when
        Balls comBalls = ballGenerator.generateBalls();
        //then
//        Assertions.assertThat(list)
//                .contains(comBalls.getBalls().stream().mapToInt((Ball ball) -> ball.getNum()));

    }
}
