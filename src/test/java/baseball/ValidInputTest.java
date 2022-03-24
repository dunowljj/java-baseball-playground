package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

public class ValidInputTest {

    @DisplayName("입력값 검증 예외 메시지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3222","2","#$2","43#","","120"})
    void constructValidInput(String input){
        Assertions.assertThatThrownBy(() -> new ValidInput(input))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("잘못된 입력입니다. 3자리 숫자를 입력하세요. ex) 123");
    }
}
