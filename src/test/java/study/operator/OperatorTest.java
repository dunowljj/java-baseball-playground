package study.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.exception.OperatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @Test
    void getSymbol_PLUS(){
        //givenw
        String symbol = "+";

        //when
        OperatorType operatorType = OperatorType.PLUS;

        //then
        assertThat(operatorType.getSymbol()).isEqualTo(symbol);
    }
    @Test
    void getSymbol_MINUS(){
        //given
        String symbol = "-";

        //when
        OperatorType operatorType = OperatorType.MINUS;

        //then
        assertThat(operatorType.getSymbol()).isEqualTo(symbol);
    }
    @Test
    void getExpression(){
        //given
        OperatorType operatorType = OperatorType.PLUS;

        //when
        assertThat(operatorType.getExpression().apply(1, 2))
                .isEqualTo(1 + 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void apply_plus(int num) {
        //when
        OperatorType operatorType = OperatorType.PLUS;
        //then
        assertThat(operatorType.getExpression().apply(num, 2)).isEqualTo(num + 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void apply_minus(int num) {
        //when
        OperatorType operatorType = OperatorType.MINUS;
        //then
        assertThat(operatorType.getExpression().apply(num, 2)).isEqualTo(num - 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void apply_multiply(int num) {
        //when
        OperatorType operatorType = OperatorType.MULTIPLY;
        //then
        assertThat(operatorType.getExpression().apply(num, 2)).isEqualTo(num * 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void apply_divide(int num) {
        //when
        OperatorType operatorType = OperatorType.DIVIDE;
        //then
        assertThat(operatorType.getExpression().apply(num, 2)).isEqualTo(num / 2);
    }

    @Test
    void apply_숫자0_나누기_예외던지기테스트() {
        //given
        int value = 0;
        int nextValue = 0;
        study2.operator.OperatorType operatorType = study2.operator.OperatorType.DIVIDE;

        //when,then
        assertThatThrownBy(() -> operatorType.apply(value, nextValue))
                .isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void operate_plus(int num) {
        //when
        OperatorType operatorType = OperatorType.PLUS;
        //then
        assertThat(operatorType.operate(num, 2)).isEqualTo(num + 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void operate_minus(int num) {
        //when
        OperatorType operatorType = OperatorType.MINUS;
        //then
        assertThat(operatorType.operate(num, 2)).isEqualTo(num - 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void operate_multiply(int num) {
        //when
        OperatorType operatorType = OperatorType.MULTIPLY;
        //then
        assertThat(operatorType.operate(num, 2)).isEqualTo(num * 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 19, 100, 30})
    void operate_divide(int num) {
        //when
        OperatorType operatorType = OperatorType.DIVIDE;
        //then
        assertThat(operatorType.operate(num, 2)).isEqualTo(num / 2);
    }

    @Test
    void operate(){
        //given
        int value = 0;
        int nextValue = 0;
        OperatorType operatorType = OperatorType.DIVIDE;

        //when,then
        assertThatThrownBy(() -> operatorType.operate(value, nextValue))
                .isInstanceOf(ArithmeticException.class);
    }


    @ParameterizedTest
    @CsvSource({"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    void symbol로_연산자_반환값_잘_찾는지_확인(String symbol, String expected) {
        //when
        OperatorType operatorType = OperatorType.findOperatorBySymbol(symbol);

        //then
        assertThat(operatorType.name()).isEqualTo(expected);
    }

    @Test
    void symbol과_일치하는_연산_존재하지_않을떄_예외() {
        //given
        String symbol = "#@";

        //when, then
        assertThatThrownBy(() -> OperatorType.findOperatorBySymbol(symbol))
                .isInstanceOf(OperatorException.class)
                .hasMessageContaining("존재하지 않는 연산자입니다.");
    }
}
