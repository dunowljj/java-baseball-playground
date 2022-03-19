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
        Balls userBalls = new Balls(Arrays.asList(4, 5, 1));

        //when
        PlayResult playResult = baseball.play(comBalls,userBalls);

        //then
        assertThat(playResult.getResult()).isEqualTo("1볼");
    }
    @DisplayName("play_받아온 결과 확인 : 1스트라이크볼")
    @Test
    void play_1STRIKE(){
        //given
        Balls userBalls = new Balls(Arrays.asList(1, 4, 5));

        //when
        PlayResult playResult = baseball.play(comBalls,userBalls);

        //then
        assertThat(playResult.getResult()).isEqualTo("1스트라이크");
    }
    @DisplayName("play_받아온 결과 확인 : 1볼 1스크라이크")
    @Test
    void play_1BALL1STRIKE(){
        //given
        Balls userBalls = new Balls(Arrays.asList(1, 3, 5));

        //when
        PlayResult playResult = baseball.play(comBalls,userBalls);

        //then
        assertThat(playResult.getResult()).isEqualTo("1볼 1스트라이크");
    }
    @DisplayName("play_받아온 결과 확인: 3스트라이크")
    @Test
    void play_3STRIKE(){
        //given
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        //when
        PlayResult playResult = baseball.play(comBalls,userBalls);

        //then
        assertThat(playResult.getResult()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다!");
    }
    @DisplayName("play_받아온 결과 확인: 3스트라이크")
    @Test
    void play_nothing(){
        //given
        Balls userBalls = new Balls(Arrays.asList(4, 5, 6));

        //when
        PlayResult playResult = baseball.play(comBalls,userBalls);

        //then
        assertThat(playResult.getResult()).isEqualTo("nothing");
    }


    @DisplayName("count_볼, 스트라이크 세기 : 1볼")
    @Test
    void count_1BALL(){
        //given
        Balls userBalls = new Balls(Arrays.asList(4, 5, 1));

        //when
        baseball.count(comBalls, userBalls);

        //then
        assertThat(baseball.getBall()).isEqualTo(1);
    }
    @DisplayName("count_볼, 스트라이크 세기 : 1스트라이크")
    @Test
    void count_1STRIKE(){
        //given
        Balls userBalls = new Balls(Arrays.asList(1, 4, 5));

        //when
        baseball.count(comBalls, userBalls);

        //then
        assertThat(baseball.getStrike()).isEqualTo(1);
    }
    @DisplayName("count_볼, 스트라이크 세기 : 1볼1스트라이크")
    @Test
    void count_1BALL1STRIKE(){
        //given
        Balls userBalls = new Balls(Arrays.asList(1, 3, 5));

        //when
        baseball.count(comBalls, userBalls);

        //then
        assertThat(baseball.getBall()).isEqualTo(1);
        assertThat(baseball.getStrike()).isEqualTo(1);
    }
    @DisplayName("count_볼, 스트라이크 세기 : 3스트라이크")
    @Test
    void count_3STRIKE(){
        //given
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        //when
        baseball.count(comBalls, userBalls);

        //then
        assertThat(baseball.getStrike()).isEqualTo(3);
    }
    @DisplayName("count_볼, 스트라이크 세기 : 낫싱, 0볼0스트라이크")
    @Test
    void count_NOTHING(){
        //given
        Balls userBalls = new Balls(Arrays.asList(4, 5, 6));

        //when
        baseball.count(comBalls, userBalls);

        //then
        assertThat(baseball.getStrike()).isEqualTo(0);
        assertThat(baseball.getBall()).isEqualTo(0);
    }
}