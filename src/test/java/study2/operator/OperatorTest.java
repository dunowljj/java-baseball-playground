package study2.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    Operator operator;

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void plus(int num) {
        //when
        Operator operator = new PlusOperator();
        //then
        assertThat(operator.operate(num, 2)).isEqualTo(num + 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void minus(int num) {
        //when
        Operator operator = new MinusOperator();
        //then
        assertThat(operator.operate(num, 2)).isEqualTo(num - 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void multiply(int num) {
        //when
        Operator operator = new MultiplyOperator();
        //then
        assertThat(operator.operate(num, 2)).isEqualTo(num * 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void divide(int num) {
        //when
        Operator operator = new DivideOperator();
        //then
        assertThat(operator.operate(num, 2)).isEqualTo(num / 2);
    }
    @Test
    void 숫자0_나누기_예외던지기테스트(){
        //given
        int zero = 0;

        //when
        Operator operator = new DivideOperator();

        //then
        assertThatThrownBy(() -> operator.operate(2, zero))
                .isInstanceOf(ArithmeticException.class);
    }

}
