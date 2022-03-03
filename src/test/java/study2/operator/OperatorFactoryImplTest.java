package study2.operator;

import org.junit.jupiter.api.Test;

import java.util.MissingFormatArgumentException;

import static org.assertj.core.api.Assertions.*;

public class OperatorFactoryImplTest {

    OperatorFactoryImpl operatorFactory = new OperatorFactoryImpl();

    @Test
    void choosePlus() {
        //when
        String symbol = "+";
        //then
        assertThat(operatorFactory.create(symbol).getClass()).isEqualTo(PlusOperator.class);
    }

    @Test
    void chooseMinus() {

        //when
        String symbol = "-";
        //then
        assertThat(operatorFactory.create(symbol).getClass()).isEqualTo(MinusOperator.class);
    }

    @Test
    void chooseMultiply() {
        //when
        String symbol = "*";
        //then
        assertThat(operatorFactory.create(symbol).getClass()).isEqualTo(MultiplyOperator.class);
    }

    @Test
    void chooseDivide() {
        //when
        String symbol = "/";
        //then
        assertThat(operatorFactory.create(symbol).getClass()).isEqualTo(DivideOperator.class);
    }
    @Test
    void create_연산자검증_예외던지기테스트(){
        //given
        String symbol = "$"; //없는 연산자
        //when
        assertThatThrownBy(() -> operatorFactory.create(symbol))
                .isInstanceOf(MissingFormatArgumentException.class)
                .hasMessageContaining("사용가능한 연산자가 없습니다.");
    }
}
