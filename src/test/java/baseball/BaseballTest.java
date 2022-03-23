package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DisplayName("BaseballTest")
public class BaseballTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("입력값이 잘 변환되는지 - true")
    @Test
    void input_true() {
        //given
        String ballNumbers = "123";
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));

        //when
        int num1 = ballNumbers.charAt(0) - '0';
        int num2 = ballNumbers.charAt(1) - '0';
        int num3 = ballNumbers.charAt(2) - '0';
        List<Integer> userBalls = new ArrayList<>(Arrays.asList(num1, num2, num3));

        //given
        for (int i = 0; i < 3; i++) {
            assertThat(userBalls.get(i).equals(expected.get(i))).isTrue();
        }
    }
    @DisplayName("입력값이 잘 변환되는지 - false")
    @Test
    void input_false() {
        //given
        String ballNumbers = "123";
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 2, 3));

        //when
        int num1 = ballNumbers.charAt(0) - '0';
        int num2 = ballNumbers.charAt(1) - '0';
        int num3 = ballNumbers.charAt(2) - '0';
        List<Integer> userBalls = new ArrayList<>(Arrays.asList(num1, num2, num3));

        //given
        assertThat(userBalls.get(0).equals(expected.get(0))).isFalse();
    }
}
