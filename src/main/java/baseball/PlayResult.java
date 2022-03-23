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

    public String getMessage() {
        if(isCorrect(this)){
            return getStrike() + "스트라이크\n3개의 숫자를 모두 맞히셨습니다!";
        }
        if(isNOTHING(this)){
            return "nothing";
        }
        if(hasBothBALLAndSTRIKE(this)){
            return getBall() + "볼 " + getStrike() + "스트라이크";
        }
        if(hasOnlyBALL(this)){
            return getBall() + "볼";
        }
        if(hasOnlySTRIKE(this)){
            return getStrike() + "스트라이크";
        }
        return "에러";
    }
    public boolean isCorrect(PlayResult playResult) {
        return playResult.getStrike() == 3;
    }
    private boolean isNOTHING(PlayResult playResult) {
        return playResult.getBall() == 0 && playResult.getStrike() == 0;
    }
    private boolean hasBothBALLAndSTRIKE(PlayResult playResult) {
        return playResult.getBall() > 0 && playResult.getStrike() > 0;
    }
    private boolean hasOnlySTRIKE(PlayResult playResult) {
        return playResult.getBall() == 0 && playResult.getStrike() > 0;
    }
    private boolean hasOnlyBALL(PlayResult playResult) {
        return playResult.getBall() > 0 && playResult.getStrike() == 0;
    }
    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }





}
