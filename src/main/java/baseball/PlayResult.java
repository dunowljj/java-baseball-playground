package baseball;

public class PlayResult {
    private int ball = 0;
    private int strike = 0;


    public void count(BallStatus ballStatus){
        if(isBALL(ballStatus)){
            ball++;
        }
        if (isSTRIKE(ballStatus)) {
            strike++;
        }
    }
    private boolean isBALL(BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
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
