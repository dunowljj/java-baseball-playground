package study2;

import org.junit.jupiter.api.Test;

import java.util.MissingFormatArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSeperatorTest {

    StringSeperator stringSeperator = new StringSeperator();

    @Test
    void 숫자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";
        String[] inputArr = input.split(" ");
        int[] expectedArr1 = {3, 5, 2, 6, 1, 2};

        //when
        stringSeperator = stringSeperator.divideOperatorsWithNumsFrom(inputArr);

        //then
        for (int i = 0; i < expectedArr1.length; i++) {
            assertThat(stringSeperator.getNumberSources()[i] == expectedArr1[i]).isTrue();
        }

    }

    @Test
    void 연산자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";
        String[] inputArr = input.split(" ");
        String[] expectedArr = {"+", "-", "+", "/", "*"};

        //when
        stringSeperator = stringSeperator.divideOperatorsWithNumsFrom(inputArr);

        //then
        for (int i = 0; i < expectedArr.length; i++) {
            assertThat(stringSeperator.getOperatorSources()[i]).isEqualTo(expectedArr[i]);
        }
    }

    @Test
    void refine_숫자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";

        int[] expectedArr1 = {3, 5, 2, 6, 1, 2};

        //when
        stringSeperator = stringSeperator.refine(input);

        //then
        for (int i = 0; i < expectedArr1.length; i++) {
            assertThat(stringSeperator.getNumberSources()[i] == expectedArr1[i]).isTrue();
        }

    }

    @Test
    void refine_연산자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";
        String[] expectedArr = {"+", "-", "+", "/", "*"};

        //when
        stringSeperator = stringSeperator.refine(input);

        //then
        for (int i = 0; i < expectedArr.length; i++) {
            assertThat(stringSeperator.getOperatorSources()[i]).isEqualTo(expectedArr[i]);
        }
    }
    @Test
    void 숫자예외체크_테스트(){
        //given
        String input = "% + 5 - 2 + 6 / 1 * 2";

        //when,then
        assertThatThrownBy(() -> stringSeperator = stringSeperator.refine(input))
                .isInstanceOf(MissingFormatArgumentException.class)
                .hasMessageContaining("홀수번째에는 숫자를 입력하세요.");
    }
}