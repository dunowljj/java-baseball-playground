package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballTest {
    NumberBaseball baseball = new NumberBaseball();

    @DisplayName("readInput - 입력값을 분리해서 읽기 테스트")
    @Test
    void makeInputToArr(){
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

    @DisplayName("checkInput - 연속된 숫자 문자열 세 자리 정규표현식 매칭 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123","456","789","124"})
    void checkInput(String input){
        //when, then
        baseball.checkInput(input);
    }

    @DisplayName("checkInput - 연속된 숫자 문자열 세 자리 정규표현식 매칭 실패 시 예외 던지기 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234","asd","","12","a13","#"})
    void checkInputException(String input){
        //when, then
        assertThatThrownBy(() -> baseball.checkInput(input))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("잘못된 입력입니다. 3자리 숫자를 연속해서 입력해주세요. ex) 123");
    }

    @DisplayName("validateInput - checkInput에서 정규표현식 매칭 실패 후 로직 실행")
    @ParameterizedTest
    @ValueSource(strings = {"1234","asd","","12","a13","#"})
    void validateInput(String input){
        String output = "20";
        //when
        try {
            checkInput(input);
        } catch (InputMismatchException e){
            System.out.println(e.getMessage()+", input : "+input);
            output = "12";
        }

        //then
        assertThat(output).isEqualTo("12");
    }

}
