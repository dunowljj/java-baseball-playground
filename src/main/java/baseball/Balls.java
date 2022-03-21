package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBalls(answers);
    }

    private List<Ball> mapBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i+1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> balls) {
        PlayResult playResult = new PlayResult();
        Balls userBalls = new Balls(balls);

        for(Ball ball : userBalls.getBalls()){
            BallStatus ballStatus = check(ball);
            playResult.count(ballStatus);
        }
        return playResult;
    }

    public BallStatus check(Ball userBall) {
        return answers.stream()
                .map((ball) -> ball.check(userBall))
                .filter((status) -> status != BallStatus.NOTHING)
               .findFirst()
                .orElse(BallStatus.NOTHING);
    }
    public List<Ball> getBalls() {
        return answers;
    }
    public Ball getBall(int i){
        return answers.get(i);
    }
}
