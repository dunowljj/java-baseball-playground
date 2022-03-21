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
    @DisplayName("play_받아온 결과 확인 : 1볼")
    @Test
    void play_1BALL(){
        //given, when
        PlayResult playResult = comBalls.play(Arrays.asList(4,5,1));

        //then
        assertThat(playResult.getBall()).isEqualTo(1);
    }
    @DisplayName("play_받아온 결과 확인 : 1스트라이크")
    @Test
    void play_1STRIKE(){
        //given, when
        PlayResult playResult = comBalls.play(Arrays.asList(1,4,5));

        //then
        assertThat(playResult.getStrike()).isEqualTo(1);
    }
    @DisplayName("play_받아온 결과 확인 : 1볼 1스크라이크")
    @Test
    void play_1BALL1STRIKE(){
        //given, when
        PlayResult playResult = comBalls.play(Arrays.asList(1,3,5));

        //then
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }
    @DisplayName("play_받아온 결과 확인: 3스트라이크")
    @Test
    void play_3STRIKE(){
        //given, when
        PlayResult playResult = comBalls.play(Arrays.asList(1,2,3));

        //then
        assertThat(playResult.getStrike()).isEqualTo(3);
    }
    @DisplayName("play_받아온 결과 확인: 낫싱")
    @Test
    void play_nothing(){
        //given, when
        PlayResult playResult = comBalls.play(Arrays.asList(4,5,6));

        //then
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }
    @DisplayName("볼들과 볼 하나 비교 - BALL")
    @Test
    void check_ball(){
        //given
        Ball userBall = new Ball(1,3);

        //when
        BallStatus ballType = comBalls.check(userBall);

        //then
        assertThat(ballType).isEqualTo(BallStatus.BALL);
    }
    @DisplayName("볼들과 볼 하나 비교 - STRIKE")
    @Test
    void check_strike(){
        //given
        Ball userBall = new Ball(1,1);

        //when
        BallStatus ballType = comBalls.check(userBall);

        //then
        assertThat(ballType).isEqualTo(BallStatus.STRIKE);
    }
    @DisplayName("볼들과 볼 하나 비교 - NOTHING")
    @Test
    void check_nothing(){
        //given
        Ball userBall = new Ball(1,5);

        //when
        BallStatus ballType = comBalls.check(userBall);

        //then
        assertThat(ballType).isEqualTo(BallStatus.NOTHING);
    }
}
