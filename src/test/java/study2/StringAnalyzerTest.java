package study2;

import org.junit.jupiter.api.Test;

import java.util.MissingFormatArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAnalyzerTest {

    StringAnalyzer stringAnalyzer = new StringAnalyzer();

    @Test
    void 숫자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";
        String[] inputArr = input.split(" ");
        int[] expectedArr1 = {3, 5, 2, 6, 1, 2};

        //when
        stringAnalyzer = stringAnalyzer.divideOperatorsWithNumsFrom(inputArr);

        //then
        for (int i = 0; i < expectedArr1.length; i++) {
            assertThat(stringAnalyzer.getNumberSources()[i] == expectedArr1[i]).isTrue();
        }

    }

    @Test
    void 연산자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";
        String[] inputArr = input.split(" ");
        String[] expectedArr = {"+", "-", "+", "/", "*"};

        //when
        stringAnalyzer = stringAnalyzer.divideOperatorsWithNumsFrom(inputArr);

        //then
        for (int i = 0; i < expectedArr.length; i++) {
            assertThat(stringAnalyzer.getOperatorSources()[i]).isEqualTo(expectedArr[i]);
        }
    }

    @Test
    void refine_숫자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";

        int[] expectedArr1 = {3, 5, 2, 6, 1, 2};

        //when
        stringAnalyzer = stringAnalyzer.refine(input);

        //then
        for (int i = 0; i < expectedArr1.length; i++) {
            assertThat(stringAnalyzer.getNumberSources()[i] == expectedArr1[i]).isTrue();
        }

    }

    @Test
    void refine_연산자배열_반환테스트() {
        //given
        String input = "3 + 5 - 2 + 6 / 1 * 2";
        String[] expectedArr = {"+", "-", "+", "/", "*"};

        //when
        stringAnalyzer = stringAnalyzer.refine(input);

        //then
        for (int i = 0; i < expectedArr.length; i++) {
            assertThat(stringAnalyzer.getOperatorSources()[i]).isEqualTo(expectedArr[i]);
        }
    }
    @Test
    void 숫자예외체크_테스트(){
        //given
        String input = "% + 5 - 2 + 6 / 1 * 2";

        //when,then
        assertThatThrownBy(() -> stringAnalyzer = stringAnalyzer.refine(input))
                .isInstanceOf(MissingFormatArgumentException.class)
                .hasMessageContaining("홀수번째에는 숫자를 입력하세요.");
    }
}