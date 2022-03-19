package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    Balls comBalls;

    @BeforeEach
    void setUp(){
        comBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @DisplayName("볼들과 볼 하나 비교 - BALL")
    @Test
    void ball(){
        //given
        Ball userBall = new Ball(1,3);

        //when
        BallStatus ballType = comBalls.check(userBall);

        //then
        assertThat(ballType).isEqualTo(BallStatus.BALL);
    }
    @DisplayName("볼들과 볼 하나 비교 - STRIKE")
    @Test
    void strike(){
        //given
        Ball userBall = new Ball(1,1);

        //when
        BallStatus ballType = comBalls.check(userBall);

        //then
        assertThat(ballType).isEqualTo(BallStatus.STRIKE);
    }
    @DisplayName("볼들과 볼 하나 비교 - NOTHING")
    @Test
    void nothing(){
        //given
        Ball userBall = new Ball(1,5);

        //when
        BallStatus ballType = comBalls.check(userBall);

        //then
        assertThat(ballType).isEqualTo(BallStatus.NOTHING);
    }
}
