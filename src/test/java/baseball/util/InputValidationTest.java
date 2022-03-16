package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {
    InputValidation validation;
    @BeforeEach
    void setUp(){
        validation = new InputValidation();
    }


    @DisplayName("입력값 1-9사이 세 자리 벗어나면 false 인지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234","12","#!@","da","120","3","3@1"," ",""," 32"})
    void validateInput_false(String input){
        //when
        boolean isVaild = validation.isValidInput(input);

        //then
        Assertions.assertThat(isVaild).isFalse();
    }

    @DisplayName("입력값 1-9사이 세 자리이면 true 인지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123","234","345","147","789"})
    void validateInput_true(String input){
        //when
        boolean isVaild = validation.isValidInput(input);

        //then
        Assertions.assertThat(isVaild).isTrue();
    }
}
