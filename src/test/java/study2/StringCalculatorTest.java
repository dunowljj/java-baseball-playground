package study2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study2.operator.DivideOperator;
import study2.operator.Operator;

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
    void tryToCalculate(){
        //given
        int value = 0;
        int nextValue = 0;
        Operator devideOperator = new DivideOperator();

        //when, then
        /*Assertions.assertThrows(ArithmeticException.class,
                () -> stringCalculator.tryTocalculate(value, nextValue, devideOperator));*/

        assertThatThrownBy(() -> stringCalculator.tryTocalculate(value, nextValue, devideOperator))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0은 나누는 수가 될 수 없습니다.");
    }

    @Test
    void calculate_중간계산(){

        //given
        String value = "3 - 3 + 15 / 15 * 29";

        //when
        int actual = stringCalculator.calculate(value);

        //then
        assertThat(actual).isEqualTo((3-3+15)/15*29);
    }

    @Test
    void calculate_전체계산(){

        //given
        String value = "3 - 3 + 15 / 15 * 29";

        //when
        int actual = stringCalculator.calculate(value);

        //then
        assertThat(actual).isEqualTo((3-3+15)/15*29);
    }

}
