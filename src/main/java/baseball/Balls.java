package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBalls(answers);
    }

    private List<Ball> mapBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i+1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus check(Ball userBall) {
        return balls.stream()
                .map((ball) -> ball.check(userBall))
                .filter((status) -> status != BallStatus.NOTHING)
               .findFirst()
                .orElse(BallStatus.NOTHING);
    }
    public List<Ball> getBalls() {
        return balls;
    }
    public Ball getBall(int i){
        return balls.get(i);
    }
}
