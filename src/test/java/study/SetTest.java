package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @DisplayName("Set Size 테스트")
    @Test
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set contain 테스트")
    @Test
    void isContains(){
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }
    @DisplayName("Set contain Parameterized 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContains1(int number){
        assertThat(numbers).contains(number);

    }

    @DisplayName("Set contain CSV 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void isContains2(int number, boolean expected){
        Assertions.assertEquals(numbers.contains(number), expected);
    }
}
