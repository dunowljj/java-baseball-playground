package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PlayResultTest {

    PlayResult playResult;

    @BeforeEach
    void setUp(){
        playResult = new PlayResult();
    }


    @ParameterizedTest
    @CsvSource({"1,1볼","2,2볼","3,3볼"})
    void grade_1BALL(int ball, String ballResult){
        //given
        int strike = 0;

        //when
        playResult.grade(ball,strike);

        //then
        assertThat(playResult.getResult()).isEqualTo(ballResult);
    }

    @ParameterizedTest
    @CsvSource({"1,1스트라이크","2,2스트라이크"})
    void grade_1BALL1STRIKE(int strike, String strikeResult){
        //given
        int ball = 1;

        //when
        playResult.grade(ball,strike);

        //then
        assertThat(playResult.getResult()).isEqualTo("1볼 "+strikeResult);
    }
    @ParameterizedTest
    @CsvSource({"1,1스트라이크","2,2스트라이크"})
    void grade_STRIKE(int strike, String strikeResult){
        //given
        int ball = 0;

        //when
        playResult.grade(ball,strike);

        //then
        assertThat(playResult.getResult()).isEqualTo(strikeResult);
    }
    @Test
    void grade_3STRIKE(){
        //given
        int strike = 3;
        int ball = 0;

        //when
        playResult.grade(ball,strike);

        //then
        assertThat(playResult.getResult()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다!");
    }
}
