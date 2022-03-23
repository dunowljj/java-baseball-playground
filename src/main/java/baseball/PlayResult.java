package baseball;

public class PlayResult {
    private int ball = 0;
    private int strike = 0;


    public void count(BallStatus ballStatus) {

        if (isBALL(ballStatus)) {
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
        if (isCorrect()) {
            return getStrike() + "스트라이크\n3개의 숫자를 모두 맞히셨습니다!";
        }
        if (isNOTHING()) {
            return "nothing";
        }
        if (hasBothBALLAndSTRIKE()) {
            return getBall() + "볼 " + getStrike() + "스트라이크";
        }
        if (hasOnlyBALL()) {
            return getBall() + "볼";
        }
        if (hasOnlySTRIKE()) {
            return getStrike() + "스트라이크";
        }
        return "에러";
    }

    public boolean isCorrect() {
        return this.getStrike() == 3;
    }

    private boolean isNOTHING() {
        return this.getBall() == 0 && this.getStrike() == 0;
    }

    private boolean hasBothBALLAndSTRIKE() {
        return this.getBall() > 0 && this.getStrike() > 0;
    }

    private boolean hasOnlySTRIKE() {
        return this.getBall() == 0 && this.getStrike() > 0;
    }
    private boolean hasOnlyBALL() {
        return this.getBall() > 0 && this.getStrike() == 0;
    }

    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }





}
