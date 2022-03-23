package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("BaseballTest")
    public class BaseballTest {

    @BeforeEach
    void setUp(){
    }

    @Test
    void input(){
        //when
        String input = "123";
        Balls comBalls = new Balls(Arrays.asList(1, 2, 3));

        //given

    }


}
