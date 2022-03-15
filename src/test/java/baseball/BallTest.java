package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    Ball comBall;
    @BeforeEach
    void ballTest(){
        comBall = new Ball(1,3);
    }

    @Test
    void ball(){
        //given
        Ball user = new Ball(1,4);

        //when
        BallType ballType = comBall.checkUserBall(user);

        //then
        assertThat(ballType).isEqualTo(BallType.BALL);
    }
    @Test
    void strike(){
        //given
        Ball user = new Ball(1,3);

        //when
        BallType ballType = comBall.checkUserBall(user);

        //then
        assertThat(ballType).isEqualTo(BallType.STRIKE);
    }
    @Test
    void nothing(){
        //given
        Ball user = new Ball(3,1);

        //when
        BallType ballType = comBall.checkUserBall(user);

        //then
        assertThat(ballType).isEqualTo(BallType.NOTHING);
    }
}
