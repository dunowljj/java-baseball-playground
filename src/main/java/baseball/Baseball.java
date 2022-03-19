package baseball;

public class Baseball {
    private int ball = 0;
    private int strike = 0;

    public PlayResult play(Balls comBalls, Balls userBalls) {
        PlayResult playResult = new PlayResult();
        count(comBalls, userBalls);
        playResult.grade(ball, strike);
        return playResult;
    }

    public void count(Balls comBalls, Balls userBalls){
        this.ball = 0;
        this.strike = 0;

        for (int i = 0; i < 3; i++) {
            BallStatus ballStatus = comBalls.check(userBalls.getBall(i));
            countIfBALL(ballStatus);
            countIfSTRIKE(ballStatus);
        }
    }

    private void countIfBALL(BallStatus ballStatus) {
        if(isBALL(ballStatus)){
            ball++;
        }
    }
    private boolean isBALL(BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
    }

    private void countIfSTRIKE(BallStatus ballStatus) {
        if (isSTRIKE(ballStatus)) {
            strike++;
        }
    }
    private boolean isSTRIKE(BallStatus ballStatus) {
        return ballStatus == BallStatus.STRIKE;
    }


    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
