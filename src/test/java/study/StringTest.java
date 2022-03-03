package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Nested
    class split {
        @DisplayName("1이랑 2가 잘 분리 되는지")
        @Test
        void split1() {
            String[] actual = "1,2".split(",");
            assertThat(actual).contains("1");
            assertThat(actual).contains("2");
        }

        @DisplayName("1만 포함하는 배열 반환되는지")
        @Test
        void split2() {
            String[] actual = "1".split(",");
            assertThat(actual).containsExactly("1");
        }
    }

    @Test
    void substring(){
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Nested
    class charAt{

        @Test
        @DisplayName("기능테스트")
        void charAt(){
            char actual = "abc".charAt(0);
            assertThat(actual).isEqualTo('a');

            actual = "abc".charAt(1);
            assertThat(actual).isEqualTo('b');

            actual = "abc".charAt(2);
            assertThat(actual).isEqualTo('c');
        }

        @Test
        @DisplayName("예외테스트")
        void charAtException(){
            assertThatThrownBy(() -> "abc".charAt(3))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3");


    //                .hasMessageContaining("String index out of range: 3");
    //        assertThatThrownBy(() -> {throw new StringIndexOutOfBoundsException("boom");})
    //                .isInstanceOf(StringIndexOutOfBoundsException.class)
    //                .hasMessageContaining("boom");
        }
        @Test
        @DisplayName("예외테스트2")
        void charAtException2() {
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> "abc".charAt(3))
                    .withMessageMatching("String index out of range: \\d+");
        }
    }

}
