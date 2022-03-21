package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BaseballTest")
public class BaseballTest {
    Baseball baseball = new Baseball();
    Balls comBalls;
    @BeforeEach
    void setUp(){
        comBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @DisplayName("play_받아온 결과 확인 : 1볼")
    @Test
    void play_1BALL(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.BALL;

        //when
        playResult.count(ballStatus);
        baseball.play(playResult);

        //then
        assertThat(baseball.getResult()).isEqualTo("1볼");
    }
    @DisplayName("play_받아온 결과 확인 : 1스트라이크")
    @Test
    void play_1STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        playResult.count(ballStatus);
        baseball.play(playResult);

        //then
        assertThat(baseball.getResult()).isEqualTo("1스트라이크");
    }
    @DisplayName("play_받아온 결과 확인 : 1볼 1스크라이크")
    @Test
    void play_1BALL1STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus statusS = BallStatus.STRIKE;
        BallStatus statusB = BallStatus.BALL;

        //when
        playResult.count(statusS);
        playResult.count(statusB);
        baseball.play(playResult);

        //then
        assertThat(baseball.getResult()).isEqualTo("1볼 1스트라이크");
    }
    @DisplayName("play_받아온 결과 확인: 3스트라이크")
    @Test
    void play_3STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        for (int i = 0; i < 3; i++) {
            playResult.count(ballStatus);
        }
        baseball.play(playResult);

        //then
        assertThat(baseball.getResult()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다!");

    }
    @DisplayName("play_받아온 결과 확인: 낫싱")
    @Test
    void play_nothing(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.NOTHING;

        //when
        playResult.count(ballStatus);
        baseball.play(playResult);

        //then
        assertThat(baseball.getResult()).isEqualTo("nothing");
    }

}
