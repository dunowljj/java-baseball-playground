package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Grader(채점자 객체) 테스트")
public class GraderTest {

    Grader grader = new Grader();

    @DisplayName("스트라이크, 볼 카운팅 테스트 - 1스트라이크")
    @Test
    void countStrikeAndBall_1strike(){
        //given
        String[] input = {"4","2","5"};
        String[] answers = {"1", "2", "3"};
        int expectedStrike = 1;
        int expectedBall = 0;

        //when
        grader = grader.countStrikeAndBall(input,answers);
        int strike = grader.getStrike();
        int ball = grader.getBall();

        //then
        Assertions.assertThat(strike).isEqualTo(expectedStrike);
        Assertions.assertThat(ball).isEqualTo(expectedBall);
    }

    @DisplayName("스트라이크, 볼 카운팅 테스트 - 1볼")
    @Test
    void countStrikeAndBall_1ball(){
        //given
        String[] input = {"4","2","5"};
        String[] answers = {"1", "5", "3"};
        int expectedStrike = 0;
        int expectedBall = 1;

        //when
        grader = grader.countStrikeAndBall(input,answers);
        int strike = grader.getStrike();
        int ball = grader.getBall();

        //then
        Assertions.assertThat(strike).isEqualTo(expectedStrike);
        Assertions.assertThat(ball).isEqualTo(expectedBall);
    }

    @DisplayName("스트라이크, 볼 카운팅 테스트 - 1볼 1스트라이크")
    @Test
    void grade_1ball_1strike(){
        //given
        String[] input = {"4","2","5"};
        String[] answers = {"4", "5", "6"};
        int expectedStrike = 1;
        int expectedBall = 1;

        //when
        grader = grader.countStrikeAndBall(input,answers);
        int strike = grader.getStrike();
        int ball = grader.getBall();

        //then
        Assertions.assertThat(strike).isEqualTo(expectedStrike);
        Assertions.assertThat(ball).isEqualTo(expectedBall);
    }
    @DisplayName("스트라이크, 볼 카운팅 테스트 - 2볼 1스트라이크")
    @Test
    void grade_2ball_1strike(){
        //given
        String[] input = {"3","5","4"};
        String[] answers = {"4", "5", "3"};
        int expectedStrike = 1;
        int expectedBall = 2;

        //when
        grader = grader.countStrikeAndBall(input,answers);
        int strike = grader.getStrike();
        int ball = grader.getBall();

        //then
        Assertions.assertThat(strike).isEqualTo(expectedStrike);
        Assertions.assertThat(ball).isEqualTo(expectedBall);
    }
    @DisplayName("스트라이크, 볼 카운팅 테스트 - 0볼 0스트라이크")
    @Test
    void grade_nothing(){
        //given
        String[] input = {"4","2","5"};
        String[] answers = {"7", "8", "9"};
        int expectedStrike = 0;
        int expectedBall = 0;

        //when
        grader = grader.countStrikeAndBall(input,answers);
        int strike = grader.getStrike();
        int ball = grader.getBall();

        //then
        Assertions.assertThat(strike).isEqualTo(expectedStrike);
        Assertions.assertThat(ball).isEqualTo(expectedBall);
    }
}
