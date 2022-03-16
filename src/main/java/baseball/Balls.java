package baseball;

import java.util.List;

public class Balls {

    List<Ball> answers;
    public Balls(List<Ball> balls) {
        this.answers = balls;
    }

    public BallStatus check(Ball userBall) {
        return answers.stream()
                .map((ball) -> ball.check(userBall))
                .filter((status) -> status != BallStatus.NOTHING)
               .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
