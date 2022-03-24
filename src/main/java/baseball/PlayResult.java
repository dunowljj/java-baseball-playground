package baseball;

public class PlayResult {
    private int ball = 0;
    private int strike = 0;

    public void count(BallStatus ballStatus) {
        if (isBALL(ballStatus)) {
            ball++;
            return;
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
            return strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다!";
        }
        if (isNOTHING()) {
            return "nothing";
        }
        if (hasBothBALLAndSTRIKE()) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (hasOnlyBALL()) {
            return ball + "볼";
        }
        if (hasOnlySTRIKE()) {
            return strike + "스트라이크";
        }
        return "에러";
    }

    public boolean isCorrect() {
        return strike == 3;
    }
    private boolean isNOTHING() {
        return ball == 0 && strike == 0;
    }
    private boolean hasBothBALLAndSTRIKE() {
        return ball > 0 && strike > 0;
    }
    private boolean hasOnlySTRIKE() {
        return ball == 0 && strike > 0;
    }
    private boolean hasOnlyBALL() {
        return ball > 0 && strike == 0;
    }

    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }
}
