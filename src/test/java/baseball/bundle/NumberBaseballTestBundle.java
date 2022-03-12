package baseball.bundle;

import TestBundle.NumberBaseballBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballTestBundle {
    NumberBaseballBundle baseballT = new NumberBaseballBundle();


    @DisplayName("readInput - 입력값을 분리해서 읽기 테스트-추상화")
    @Test
    void readInput(){
        //given
        String input = "357";

        //when
        String[] submittedAnswer = baseballT.makeInputToArr(input);
        //then
        assertThat(submittedAnswer[0]).isEqualTo("3");
        assertThat(submittedAnswer[1]).isEqualTo("5");
        assertThat(submittedAnswer[2]).isEqualTo("7");
    }

    @DisplayName("askContinue - 정답 후 1,2 입력 확인")
    @Test
    void askContinue(){
        //given
        String input1 = "1";
        String input2 = "2";
        String input3 = "dasf";

        //when
        boolean isTrue = baseballT.askContinue(input1);
        boolean isFalse = baseballT.askContinue(input2);

        //then
        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();
    }

    @DisplayName("askContinue - 정답 후 1,2 입력 안할 시 예외")
    @Test
    void askContinueException(){
        //given
        String input = "dasf";

        //when
        assertThatThrownBy(() -> baseballT.askContinue(input))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("");
    }
    @DisplayName("decideRetryOrThrow - askContinue 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"1234","asd","","12","a13","#"})
    void decideRetryOrThrow(String input){

        //when ,then
        assertThat(baseballT.decideRetryOrThrow(input)).isTrue();
    }
}
