package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("Examiner(문제 출제 객체) 테스트")
public class ExaminerTest {

    Examiner examiner = new Examiner();

    @DisplayName("생성한 문자열배열 1-9 범위에 포함 여부 테스트")
    @Test
    void makeExam(){
        //given
        String[] givenNum = {"1","2","3","4","5","6","7","8","9"};
        String[] answers = new String[3];

        //when
        Arrays.setAll(answers, (i) -> String.valueOf((int)(Math.random()*9+1)));

        //then
        Assertions.assertThat(givenNum).contains(answers);
    }

    @DisplayName("생성한 문자열배열 1-9 범위 포함 여부 테스트-추상화")
    @Test
    void makeExam2(){
        //given
        String[] givenNum = {"1","2","3","4","5","6","7","8","9"};

        //when
        String[] answers = examiner.makeExam();

        //then
        Assertions.assertThat(givenNum).contains(answers);
    }
}
