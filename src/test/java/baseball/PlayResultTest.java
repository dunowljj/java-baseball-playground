package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayResultTest {
    PlayResult playResult;

    @BeforeEach
    void setUp(){
        playResult = new PlayResult();
    }

    @DisplayName("3스트라이크 확인")
    @Test
    void isCorrect(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        for (int i = 0; i < 3; i++) {
            playResult.count(ballStatus);
        }


        //then
        assertThat(playResult.isCorrect()).isTrue();
    }


    @DisplayName("play_결과 메시지 확인 : 1볼")
    @Test
    void play_1BALL(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.BALL;

        //when
        playResult.count(ballStatus);

        //then
        assertThat(playResult.getMessage()).isEqualTo("1볼");
    }
    @DisplayName("play_결과 메시지 확인 : 1스트라이크")
    @Test
    void play_1STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        playResult.count(ballStatus);

        //then
        assertThat(playResult.getMessage()).isEqualTo("1스트라이크");
    }
    @DisplayName("play_볼,스트라이크 판정에 대한 결과 메시지 테스트  : 1볼 1스크라이크")
    @Test
    void play_1BALL1STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus statusS = BallStatus.STRIKE;
        BallStatus statusB = BallStatus.BALL;

        //when
        playResult.count(statusS);
        playResult.count(statusB);

        //then
        assertThat(playResult.getMessage()).isEqualTo("1볼 1스트라이크");
    }
    @DisplayName("play_볼,스트라이크 판정에 대한 결과 메시지 테스트 : 3스트라이크")
    @Test
    void play_3STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        for (int i = 0; i < 3; i++) {
            playResult.count(ballStatus);
        }

        //then
        assertThat(playResult.getMessage()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다!");

    }
    @DisplayName("play_볼,스트라이크 판정에 대한 결과 메시지 테스트 : 낫싱")
    @Test
    void play_nothing(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.NOTHING;

        //when
        playResult.count(ballStatus);

        //then
        assertThat(playResult.getMessage()).isEqualTo("nothing");
    }


    @DisplayName("count_볼들끼리 비교한 결과 - 볼,스트라이크 개수 테스트 : 1볼")
    @Test
    void count_1BALL(){
        //given
        BallStatus ballStatus = BallStatus.BALL;

        //when
        playResult.count(ballStatus);

        //then
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }
    @DisplayName("count_볼들끼리 비교한 결과 - 볼,스트라이크 개수 테스트 : 1스트라이크")
    @Test
    void count_1STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        playResult.count(ballStatus);

        //then
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }
    @DisplayName("count_볼들끼리 비교한 결과 - 볼,스트라이크 개수 테스트 : 1볼 1스크라이크")
    @Test
    void count_1BALL1STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus statusS = BallStatus.STRIKE;
        BallStatus statusB = BallStatus.BALL;

        //when
        playResult.count(statusS);
        playResult.count(statusB);

        //then
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }
    @DisplayName("count_볼들끼리 비교한 결과 - 볼,스트라이크 개수 테스트: 3스트라이크")
    @Test
    void count_3STRIKE(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.STRIKE;

        //when
        for (int i = 0; i < 3; i++) {
            playResult.count(ballStatus);
        }

        //then
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
    }
    @DisplayName("count_볼들끼리 비교한 결과 - 볼,스트라이크 개수 테스트: 낫싱")
    @Test
    void count_nothing(){
        //given
        PlayResult playResult = new PlayResult();
        BallStatus ballStatus = BallStatus.NOTHING;

        //when
        playResult.count(ballStatus);

        //then
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }


}
