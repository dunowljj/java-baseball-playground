package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballTest {
    NumberBaseball baseball = new NumberBaseball();

    @DisplayName("readInput - 입력값을 분리해서 읽기 테스트")
    @Test
    void readInput(){
        //given
        String input = "357";

        //when
        String[] submittedAnswer = new String[3];
        for(int i=0; i<submittedAnswer.length; i++){
            submittedAnswer[i] = input.substring(i,i+1);
        }

        //then
        assertThat(submittedAnswer[0]).isEqualTo("3");
        assertThat(submittedAnswer[1]).isEqualTo("5");
        assertThat(submittedAnswer[2]).isEqualTo("7");
    }
    @DisplayName("readInput - 입력값을 분리해서 읽기 테스트-추상화")
    @Test
    void readInput2(){
        //given
        String input = "357";

        //when
        String[] submittedAnswer = baseball.makeInputToArr(input);
        //then
        assertThat(submittedAnswer[0]).isEqualTo("3");
        assertThat(submittedAnswer[1]).isEqualTo("5");
        assertThat(submittedAnswer[2]).isEqualTo("7");
    }
    @DisplayName("getScore - 볼, 스트라이크 횟수 잘 세는지 테스트")
    @Test
    void getScore(){
        //given
        String[] input = {"4", "5", "7"};
        String[] answers = {"4", "7", "5"};
        int expectedStrike = 1;
        int expectedBall = 2;


        //when
        Grader grade = baseball.getScore(input,answers);
        int strike = grade.getStrike();
        int ball = grade.getBall();

        //then
        assertThat(strike).isEqualTo(expectedStrike);
        assertThat(ball).isEqualTo(expectedBall);
    }

}
