package study;

import org.junit.jupiter.api.Test;
import study.exception.OperatorException;
import study.exception.StringCalculatorException;


import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void split() {

        //given
        String value = "3 + 4 * 5";

        //when
        String[] actual = value.split(" ");

        //then
        assertThat(actual[0]).isEqualTo("3");
        assertThat(actual[1]).isEqualTo("+");
        assertThat(actual[2]).isEqualTo("4");
        assertThat(actual[3]).isEqualTo("*");
        assertThat(actual[4]).isEqualTo("5");
    }

    @Test
    void calculateOrThrow_전체계산(){

        //given
        String input = "3 - 3 + 15 / 15 * 29";

        //when
        int actual = stringCalculator.calculateOrThrow(input);

        //then
        assertThat(actual).isEqualTo((3-3+15)/15*29);
    }
    @Test
    void calculateOrThrow_숫자입력_예외(){
        //given
        String input = "3 - # + 15 / 15 * 29";

        //when, then
        assertThatThrownBy(() -> stringCalculator.calculateOrThrow(input))
                .isInstanceOf(StringCalculatorException.class)
                .hasMessageContaining("숫자를 입력해야할 자리에 다른 값이 존재합니다.");
    }
    @Test
    void calculate_나누기0_예외() {
        //given
        String input = "3 - 3 + 15 / 0 * 29";

        //when, then
        assertThatThrownBy(() -> stringCalculator.calculateOrThrow(input))
                .isInstanceOf(StringCalculatorException.class)
                .hasMessageContaining("0은 나누는 수가 될 수 없습니다.");
    }
    @Test
        void calculateOrThrow_연산자입력_예외() {
        //given
        String input = "3 ! 3 + 15 / 15 * 29";

        //when, then
        assertThatThrownBy(() -> stringCalculator.calculateOrThrow(input))
                .isInstanceOf(OperatorException.class)
                .hasMessageContaining("존재하지 않는 연산자입니다.");
    }
}
